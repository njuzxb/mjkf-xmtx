package com.xmtx.provider.service.impl;

import com.xmtx.provider.enums.AdminStatusEnums;
import com.xmtx.provider.model.Admin;
import com.xmtx.provider.repository.AdminRepository;
import com.xmtx.provider.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public List<Admin> findAllWait() {
        return adminRepository.findAllByEnabled(AdminStatusEnums.WAIT.getCode());
    }
}
