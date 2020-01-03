package com.xmtx.provider.service;

import com.xmtx.provider.AdminApplicationTests;
import com.xmtx.provider.model.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServiceTest extends AdminApplicationTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void findAllWait() {
        List<Admin>list = adminService.findAllWait();
        Assert.assertTrue(list.size()>0);
    }
}