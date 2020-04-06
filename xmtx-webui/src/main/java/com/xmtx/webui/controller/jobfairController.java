package com.xmtx.webui.controller;

import com.xmtx.common.VO.ResultVO;
import com.xmtx.jobfair.client.JobFairClient;
import com.xmtx.jobfair.common.ReleaseInput;
import com.xmtx.jobfair.form.JobFairForm_Release;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;


@Controller
@Slf4j
public class jobfairController {
    @Autowired
    private JobFairClient jobFairClient;
//    @RequestMapping("/jobfair/getCommandList")
//    @ResponseBody
//    public ResultVO recommendJobsList(@RequestParam("pn") Integer pn){
////        jobFairClient.list()
//        ResultVO result= jobFairClient.list(pn);
//        log.error("测试");
//        return result;
//    }

    @PostMapping(value = "jobfair/release")
    public String release(
            @Valid ReleaseInput releaseInput,
            BindingResult bindingResult){
        jobFairClient.release(releaseInput,bindingResult);
        System.out.println(bindingResult.toString());
        System.out.println(releaseInput.toString());
        return "redirect:/index.html";
    }
}
