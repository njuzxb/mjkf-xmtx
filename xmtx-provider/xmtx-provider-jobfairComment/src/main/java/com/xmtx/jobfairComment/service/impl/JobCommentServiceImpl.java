package com.xmtx.jobfairComment.service.impl;

import com.xmtx.jobfairComment.dataobject.JobFairComment;
import com.xmtx.jobfairComment.enums.CommentStatusEnum;
import com.xmtx.jobfairComment.repository.JobFairCommentRepository;
import com.xmtx.jobfairComment.service.JobCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class JobCommentServiceImpl implements JobCommentService {

    @Autowired
    JobFairCommentRepository jobFairCommentRepository;


    /**
     * 新增评论
     * @param jobFairComment
     * @return
     */
    public JobFairComment comment(JobFairComment jobFairComment){
        //TODO 增加招聘文章评论数（调用招聘会服务）（暂定）

        // 存入数据库
        jobFairComment.setState(CommentStatusEnum.NORMAL.getCode());
        jobFairComment.setProve(0);
        jobFairComment.setPubtime(new Date());
        jobFairCommentRepository.save(jobFairComment);

        return jobFairComment;

    }

    /**
     * 根据jobid查找“正常”评论
     * @param jobid
     * @return
     */
    public List<JobFairComment> findUpCommentByJobid(Integer jobid){
        // 从数据库获取数据

        return jobFairCommentRepository.findAllByJobidAndState(jobid, CommentStatusEnum.NORMAL.getCode());

    }

    /**
     * 根据id查找
     * @param id
     */
    public JobFairComment findById(Integer id){

        return jobFairCommentRepository.findById(id).get();
    }

    /**
     * 根据id删除评论（用户）
     * @param id
     */
    public void deleteByUser(Integer id){



        // 从数据库删除评论(用户）
        jobFairCommentRepository.deleteById(id);
    }

}
