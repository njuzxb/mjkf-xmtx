package com.xmtx.jobfairComment.client;

import com.xmtx.jobfairComment.common.CommentCreateVO;
import com.xmtx.jobfairComment.common.ResultVO;
import com.xmtx.jobfairComment.common.SubCommentCreateVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 1:00 2020/2/19
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "xmtx-provider-common")
public interface JobFairCommentClient {
    @ResponseBody
    @PostMapping("/jobFairComment/comment")
    ResultVO comment(@RequestBody CommentCreateVO commentCreateVO);

    @ResponseBody
    @PostMapping("/subComment")
    ResultVO subComment(@RequestBody SubCommentCreateVO subCommentCreateVO);

    @ResponseBody
    @GetMapping("/jobFairComment/findUpCommentByJobid")
    ResultVO findUpCommentByJobid(@RequestParam("jobid") String jobid);

    @GetMapping("/jobFairComment/deleteComment")
    ResultVO deleteByUser(@RequestParam("id") String id);
}
