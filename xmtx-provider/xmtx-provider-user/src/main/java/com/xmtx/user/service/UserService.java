package com.xmtx.user.service;


import com.xmtx.user.dataobject.User;

public interface UserService {

    /*通过账号查找用户信息*/
    User findBuUsername(String username);

}
