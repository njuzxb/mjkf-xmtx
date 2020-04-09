package com.xmtx.webui.controller;

import com.xmtx.common.VO.ResultVO;
import com.xmtx.common.enums.ResultEnum;
import com.xmtx.common.utils.CommonUtils;
import com.xmtx.common.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * @ Author     ：djq.
 * @ Date       ：Created in 12:41 PM 4/6/2020
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Controller
@Slf4j
public class webui_userController {
    @PostMapping(value = "user/login")
    public String login(
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Map<String,Object> map) {
        if ("123@qq.com".equals(email) || "123".equals(password)){
            return "redirect:/index.html";
        }
        else {
            log.error("账号密码错误，请重新输入");
            return "redirect:/sign-in.html";
        }
    }

}
