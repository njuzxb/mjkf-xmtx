package com.xmtx.user.service.impl;

import com.xmtx.user.dataobject.User;
import com.xmtx.user.repository.UserRepository;
import com.xmtx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*通过账号查询用户信息*/
    public User findBuUsername(String username){
        return userRepository.findByUsername(username);
    }

}
