package com.xmtx.user.service.impl;

import com.xmtx.user.dataobject.User;
import com.xmtx.user.repository.UserRepository;
import com.xmtx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*通过账号查询用户信息*/
    @Override
    public Optional<User> findBuUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public void addNewUser(User user){
        user.setGmt_create(new Date());
        user.setGmt_modified(new Date());
        // 默认0是普通用户，1是企业用户
        user.setIs_enterprise(0);
        // 默认0时允许，1是封禁
        user.setEnabled(0);
        userRepository.save(user);
    }
}
