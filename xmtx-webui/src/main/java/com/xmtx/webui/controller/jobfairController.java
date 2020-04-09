//package com.xmtx.webui.controller;
//
//import com.xmtx.jobfair.common.JobFairForm_Release;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("/jobfair")
//@Slf4j
//@Service
//public class jobfairController {
//    @Autowired
//    private JobFairClient jobFairClient;
//    @RequestMapping("/getCommandList")
//    @ResponseBody
//    public ResultVO recommendJobsList(@RequestParam("pn") Integer pn){
////        jobFairClient.list()
//        ResultVO result= jobFairClient.list(pn);
//        log.error("测试");
//        return result;
//    }
//
//    @PostMapping("/release")
//    @ResponseBody
//    public String release(
//            @Valid JobFairForm_Release releaseInput,
//            BindingResult bindingResult){
//        jobFairClient.release(releaseInput,bindingResult);
//        System.out.println(bindingResult.toString());
//        System.out.println(releaseInput.toString());
//        return "redirect:/index.html";
//    }
//}
