package com.xmtx.provider.controller;

import com.xmtx.provider.VO.ResultVO;
import com.xmtx.provider.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 管理员
* */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 查询wait权限的管理员
 /*   @GetMapping("/wait")
    public ResultVO<> wait(){

    }*/
}
