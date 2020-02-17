package com.xmtx.jobfairComment.service;

import com.xmtx.jobfairComment.dataobject.JobFairComment;

import java.util.List;

public interface JobCommentService {

    /**
     * 增加评论
     * @param jobFairComment
     */
    JobFairComment comment(JobFairComment jobFairComment);

    /**
     * 根据jobid查找评论
     */
    List<JobFairComment> findUpCommentByJobid(Integer jobid);

    /**
     * 根据id查找评论
     * @param id
     */
    JobFairComment findById(Integer id);

    /**
     * 根据id删除评论（用户）
     * @param id
     */
    void deleteByUser(Integer id);

}
