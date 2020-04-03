package com.xmtx.user.controller;

import com.xmtx.common.utils.CommonUtils;
import com.xmtx.redis.client.RedisClient;
import com.xmtx.common.VO.ResultVO;
import com.xmtx.user.VO.UserSignSuccessVO;
import com.xmtx.user.dataobject.User;
import com.xmtx.common.enums.ResultEnum;
import com.xmtx.user.service.UserService;
import com.xmtx.common.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @Autowired
    RedisClient redisClient;



    @RequestMapping("/login")
    public ResultVO login(
            @RequestParam("loginAcct") String loginAcct,
            @RequestParam("userPswd") String userPswd) {

        // 根据登录账号查询数据库获取User对象
        User user = userService.findBuUsername(loginAcct);
        // 检测对象是否为空
        if (user == null) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
        }
        // 获取从数据库查询得到的密码
        String userpswdDatabase = user.getPassword();

        // TODO 4.比较密码  （需要和注册一起做，进行bcrypt加密再存入数据库）
        //boolean matcheResult = passwordEncoder.matches(userPswd, userpswdDatabase);
        boolean matcheResult = userPswd.equals(userpswdDatabase);
        if(!matcheResult) {
            return ResultVOUtil.error(ResultEnum.PSW_ERROR);
        }
        // 生成token
        String token = CommonUtils.generateToken();

        // 从User对象获取memberId
        String userId = user.getId() + "";

        // 将token和userId存入Redis
         ResultVO resultVOSaveToken = redisClient.saveNormalStringKeyValue(token, userId, 30);

        if(resultVOSaveToken.getCode() != ResultEnum.Success.getCode()) {
            return ResultVOUtil.error(resultVOSaveToken.getMsg());
        }

        // 封装UserSignSuccessVO对象
        UserSignSuccessVO userSignSuccessVO = new UserSignSuccessVO();

        BeanUtils.copyProperties(user, userSignSuccessVO);
        userSignSuccessVO.setToken(token);

        // 1返回结果
        return ResultVOUtil.success(userSignSuccessVO);
    }


}
