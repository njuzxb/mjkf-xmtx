package com.xmtx.provider.repository;

import com.xmtx.provider.AdminApplicationTests;
import com.xmtx.provider.model.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRepositoryTest extends AdminApplicationTests {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void findAllByEnabled() {
        List<Admin> list = adminRepository.findAllByEnabled(1);
        Assert.assertTrue( list.size() > 0);
    }
}