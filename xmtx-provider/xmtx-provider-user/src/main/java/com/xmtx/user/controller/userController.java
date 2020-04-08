package com.xmtx.user.controller;

import com.xmtx.common.VO.UserVO;
import com.xmtx.common.utils.CommonConstant;
import com.xmtx.common.utils.CommonUtils;
import com.xmtx.redis.client.RedisClient;
import com.xmtx.common.VO.ResultVO;
import com.xmtx.user.VO.UserSignSuccessVO;
import com.xmtx.user.VO.UserSignVO;
import com.xmtx.user.converter.UserVOtoUser;
import com.xmtx.user.dataobject.User;
import com.xmtx.common.enums.ResultEnum;
import com.xmtx.user.service.UserService;
import com.xmtx.common.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @Autowired
    RedisClient redisClient;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;



    @RequestMapping("/login")
    public ResultVO login(UserSignVO userSignVO) {

        // 根据登录账号查询数据库获取User对象
        Optional<User> user = userService.findBuUsername(userSignVO.getLoginAcct());
        // 检测对象是否为空
        if (!user.isPresent()) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
        }
        // 获取从数据库查询得到的密码
        String userpswdDatabase = user.get().getPassword();

        //  比较密码
        boolean matcheResult = passwordEncoder.matches(userSignVO.getUserPswd(), userpswdDatabase);
        if(!matcheResult) {
            return ResultVOUtil.error(ResultEnum.PSW_ERROR);
        }

        // 生成token
        String token = CommonUtils.generateToken();

        // 从User对象获取memberId
        String userId = user.get().getId() + "";

        // 将token和userId存入Redis
         ResultVO resultVOSaveToken = redisClient.saveNormalStringKeyValue(token, userId, 30);

        if(resultVOSaveToken.getCode() != ResultEnum.Success.getCode()) {
            return ResultVOUtil.error(resultVOSaveToken.getMsg());
        }

        // 封装UserSignSuccessVO对象
        UserSignSuccessVO userSignSuccessVO = new UserSignSuccessVO();

        BeanUtils.copyProperties(user.get(), userSignSuccessVO);
        userSignSuccessVO.setToken(token);

        // 返回结果
        return ResultVOUtil.success(userSignSuccessVO);
    }


    @RequestMapping("/register")
    public ResultVO register(UserVO userVO) {

        // 1.检查验证码是否有效
//        String randomCode = userVO.getRandomCode();
//        if(!CrowdUtils.strEffectiveCheck(randomCode)) {
//            return ResultEntity.failed(CrowdConstant.MESSAGE_CODE_INVALID);
//        }

        // 2.检查手机号是否有效
        String phoneNum = userVO.getUserPhone();
        if(!CommonUtils.strEffectiveCheck(phoneNum)) {
            return ResultVOUtil.error(CommonConstant.MESSAGE_PHONE_NUM_INVALID);
        }

//        // 3.拼接随机验证码的KEY
//        String randomCodeKey = CommonConstant.REDIS_RANDOM_CODE_PREFIX + phoneNum;
//
//        // 4.远程调用redis-provider的方法获取对应的验证码值
//        ResultEntity<String> resultEntity = redisRemoteService.retrieveStringValueByStringKey(randomCodeKey);
//
//        if(ResultEntity.FAILED.equals(resultEntity.getResult())) {
//            return resultEntity;
//        }
//
//        String randomCodeRedis = resultEntity.getData();
//
//        // 5.没有查询到值：返回失败信息，停止执行
//        if(randomCodeRedis == null) {
//            return ResultEntity.failed(CommonConstant.MESSAGE_CODE_NOT_EXISTS);
//        }
//
//        // 6.进行比较
//        if(!Objects.equal(randomCode, randomCodeRedis)) {
//            return ResultEntity.failed(CommonConstant.MESSAGE_CODE_NOT_MATCH);
//        }
//
//        // 7.从Redis中删除当前KEY对应的验证码
//        ResultEntity<String> resultEntityRemoveByKey = redisRemoteService.removeByKey(randomCodeKey);
//
//        if(ResultEntity.FAILED.equals(resultEntityRemoveByKey.getResult())) {
//            return resultEntityRemoveByKey;
//        }

        // 8.远程调用database-provider方法检查登录账号是否被占用
        String loginAcct = userVO.getLoginName();
        Optional<User> user = userService.findBuUsername(loginAcct);

        if(user.isPresent()) {
            return ResultVOUtil.error(CommonConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
        }

        // 10.密码加密
        String userpswd = userVO.getLoginPswd();
        String userpswdEncoded = passwordEncoder.encode(userpswd);
        userVO.setLoginPswd(userpswdEncoded);

        // 11.远程调用database-provider方法执行保存操作
        User userDO = UserVOtoUser.convert(userVO);

        userService.addNewUser(userDO);


        return ResultVOUtil.success();
    }


}
