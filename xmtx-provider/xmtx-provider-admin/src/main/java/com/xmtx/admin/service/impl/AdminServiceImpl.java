package com.xmtx.admin.service.impl;

import com.xmtx.admin.service.AdminService;
import com.xmtx.admin.enums.AdminStatusEnums;
import com.xmtx.admin.model.Admin;
import com.xmtx.admin.repository.AdminRepository;
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
