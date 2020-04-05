package com.xmtx.user.service;


import com.xmtx.user.dataobject.User;

import java.util.Optional;

public interface UserService {

    /*通过账号查找用户信息*/
    Optional<User> findBuUsername(String username);

    public void addNewUser(User user);

}
