package com.xmtx.jobfairComment.controller;

import com.xmtx.jobfairComment.VO.ResultVO;
import com.xmtx.jobfairComment.dataobject.JobFairComment;
import com.xmtx.jobfairComment.enums.ResultEnum;
import com.xmtx.jobfairComment.service.JobCommentService;
import com.xmtx.jobfairComment.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobFairComment")
public class JobCommentController {

    @Autowired
    JobCommentService jobCommentService;

    /**
     * 1. 参数校验(form中，这里基本不需要)
     * 2. 增加招聘文章评论数（调用招聘会服务）（暂定）
     * 3. 存入数据库
     */
    @PostMapping("/comment")
    public ResultVO comment(@RequestParam("jobid") String jobid, @RequestParam("content") String content){

        JobFairComment jobFairComment = new JobFairComment();
        jobFairComment.setJobid(Integer.valueOf(jobid));
        jobFairComment.setUsername("还没登陆功能");
        jobFairComment.setContent(content);

        jobFairComment = jobCommentService.comment(jobFairComment);

        return ResultVOUtil.success(jobFairComment);

    }

    /**
     * 根据jobid查找“正常”评论
     */
    @GetMapping("/findUpCommentByJobid")
    public ResultVO findUpCommentByJobid(@RequestParam("jobid") String jobid){

        List<JobFairComment> list = jobCommentService.findUpCommentByJobid(Integer.valueOf(jobid));

        return ResultVOUtil.success(list);

    }

    /**
     * 1. 校验用户名（获取登陆的用户名）
     * 2. 删除评论(用户）
     */
    @GetMapping("/deleteComment")
    public ResultVO deleteByUser(@RequestParam("id") String id){
        //TODO 获取登陆的用户名
        String username = "还没登陆功能";
        // 从数据库查询该评论并比较用户名是否一致
        JobFairComment jobFairComment = jobCommentService.findById(Integer.valueOf(id));
        if (!jobFairComment.getUsername().equals(username)){

            return ResultVOUtil.error(ResultEnum.NO_POWER);
        }
        // 删除评论
        jobCommentService.deleteByUser(Integer.valueOf(id));
        return ResultVOUtil.success();


    }




}
