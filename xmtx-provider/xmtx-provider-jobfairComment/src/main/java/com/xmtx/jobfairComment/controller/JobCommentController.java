package com.xmtx.jobfairComment.controller;

import com.xmtx.jobfairComment.VO.CommentCreateVO;
import com.xmtx.jobfairComment.VO.JobFairCommentVO;
import com.xmtx.jobfairComment.VO.ResultVO;
import com.xmtx.jobfairComment.dataobject.JobFairComment;
import com.xmtx.jobfairComment.dataobject.JobFairSubComment;
import com.xmtx.jobfairComment.enums.CommentErrorCode;
import com.xmtx.jobfairComment.enums.CommentTypeEnum;
import com.xmtx.jobfairComment.enums.ResultEnum;
import com.xmtx.jobfairComment.exception.CommentException;
import com.xmtx.jobfairComment.service.JobCommentService;
import com.xmtx.jobfairComment.service.JobSubCommentService;
import com.xmtx.jobfairComment.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/jobFairComment")
public class JobCommentController {

    @Autowired
    JobCommentService jobCommentService;

    @Autowired
    JobSubCommentService jobSubCommentService;

    /*
     *//**
     * 1. 参数校验(form中，这里基本不需要)
     * 2. 增加招聘文章评论数（调用招聘会服务）（暂定）
     * 3. 存入数据库
     *//*
    @PostMapping("/comment")
    public ResultVO comment(@RequestParam("jobid") String jobid, @RequestParam("content") String content){

        JobFairComment jobFairComment = new JobFairComment();
        jobFairComment.setJobId(Integer.valueOf(jobid));
        jobFairComment.setUsername("还没登陆功能");
        jobFairComment.setContent(content);

        jobFairComment = jobCommentService.comment(jobFairComment);

        return ResultVOUtil.success(jobFairComment);

    }
    */

    @ResponseBody
    @PostMapping("/comment")
    public ResultVO comment(@RequestBody CommentCreateVO commentCreateVO) {
        //检查当前发起评论的用户

        //检查所评论的上级内容是否存在

        //检查评论内容是否为空
        if(commentCreateVO.getContent() == null || "".equals(commentCreateVO.getContent())) {
            throw new CommentException(CommentErrorCode.CONTENT_IS_EMPTY);
        }

        //顶级评论
        if(CommentTypeEnum.PRIMARY_COMMENT.getType().equals(commentCreateVO.getType())) {
            JobFairComment jobFairComment = new JobFairComment();

            jobFairComment.setJobId(commentCreateVO.getParentId());

            //设置当前发出评论的用户的信息
            jobFairComment.setUserId(commentCreateVO.getUserId());
            //setUsername

            jobFairComment.setContent(commentCreateVO.getContent());
            jobFairComment.setPubtime(new Date());

            //jobFairComment.setProve();
            //jobFairComment.setState();

            jobCommentService.comment(jobFairComment);

            return ResultVOUtil.success(jobFairComment);
        }

        //二级评论
        else if(CommentTypeEnum.SUB_COMMENT.getType().equals(commentCreateVO.getType())) {
            JobFairSubComment jobFairSubComment = new JobFairSubComment();

            jobFairSubComment.setParentId(commentCreateVO.getParentId());

            //设置当前发起评论的用户信息
            jobFairSubComment.setUserId(commentCreateVO.getUserId());
            //jobFairSubComment.setUsername();

            //找到父级评论的信息
            JobFairCommentVO parentComment = jobCommentService.findById(commentCreateVO.getParentId());
            jobFairSubComment.setReplyUserId(parentComment.getUserId());
            jobFairSubComment.setReplyUsername(parentComment.getUsername());

            jobFairSubComment.setPubtime(new Date());
            jobFairSubComment.setContent(commentCreateVO.getContent());

            //jobFairSubComment.setProve();
            //jobFairSubComment.setState();

            jobSubCommentService.addSubComment(jobFairSubComment, commentCreateVO.getParentId());

            return ResultVOUtil.success(jobFairSubComment);
        }

        return ResultVOUtil.success();
    }

    /**
     * 根据jobid查找“正常”的顶级评论
     * 其中顶级评论中包含了其下属二级评论
     */
    @GetMapping("/findUpCommentByJobid")
    public ResultVO findUpCommentByJobid(@RequestParam("jobid") String jobid){

        List<JobFairCommentVO> list = jobCommentService.findUpCommentByJobid(Integer.valueOf(jobid));

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
        JobFairCommentVO jobFairCommentVO = jobCommentService.findById(Integer.valueOf(id));
        if (!jobFairCommentVO.getUsername().equals(username)){

            return ResultVOUtil.error(ResultEnum.NO_POWER);
        }
        // 删除顶级评论，同时这里会级联删除其下属二级评论
        jobCommentService.deleteByUser(Integer.valueOf(id));
        return ResultVOUtil.success();


    }




}
