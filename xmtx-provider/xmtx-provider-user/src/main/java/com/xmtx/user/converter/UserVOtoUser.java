package com.xmtx.user.converter;

import com.xmtx.common.VO.UserVO;
import com.xmtx.user.dataobject.User;

public class UserVOtoUser {

    public static User convert(UserVO userVO){
        User user = new User();
        user.setUsername(userVO.getLoginName());
        user.setPassword(userVO.getLoginPswd());
        user.setName(userVO.getUserName());
        user.setPhone(userVO.getUserPhone());
        user.setEmail(userVO.getUserEmail());
        return user;
    }

}
