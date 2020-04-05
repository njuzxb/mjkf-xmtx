package com.xmtx.webui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 相当于：<mvc:view-controller path="/to/login/page.html" view-name="member-login" />

        // 跳转到登录页面
        String urlPath = "/index.html";
        String viewName = "index";

        registry.addViewController(urlPath).setViewName(viewName);

        // 跳转到登录页面
        urlPath = "/sign-in.html";
        viewName = "sign-in";

        registry.addViewController(urlPath).setViewName(viewName);

        // 跳转到注册
        urlPath = "/sign-up.html";
        viewName = "sign-up";

        registry.addViewController(urlPath).setViewName(viewName);

        // 跳转到招聘信息详情
        urlPath = "/job-profile.html";
        viewName = "job-profile";

        registry.addViewController(urlPath).setViewName(viewName);

        // 跳转到招聘信息列表
        urlPath = "/jobs.html";
        viewName = "jobs";

        registry.addViewController(urlPath).setViewName(viewName);

        // 跳转到个人中心
        urlPath = "/profile.html";
        viewName = "profile";

        registry.addViewController(urlPath).setViewName(viewName);
    }

}
