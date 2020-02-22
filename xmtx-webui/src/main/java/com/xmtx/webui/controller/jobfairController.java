package com.xmtx.webui.controller;

import com.xmtx.common.VO.ResultVO;
import com.xmtx.jobfair.client.JobFairClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Slf4j
public class jobfairController {

    @Autowired
    private JobFairClient jobFairClient;

    @RequestMapping("/jobfair/getCommentList")
    @ResponseBody
    public ResultVO recommendJobsList(){
//        jobFairClient.list()
        ResultVO result= jobFairClient.list();
        log.error("测试");
        return result;
    }
}
