package com.xmtx.jobfairComment.client;

import com.xmtx.jobfairComment.common.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 1:00 2020/2/19
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "xmtx-provider-common")
public interface JobFairCommentClient {
    @PostMapping("/jobFairComment/comment")
    ResultVO comment(@RequestParam("jobid") String jobid, @RequestParam("content") String content);
    @GetMapping("/jobFairComment/findUpCommentByJobid")
    ResultVO findUpCommentByJobid(@RequestParam("jobid") String jobid);
    @GetMapping("/jobFairComment/deleteComment")
    ResultVO deleteByUser(@RequestParam("id") String id);
}
