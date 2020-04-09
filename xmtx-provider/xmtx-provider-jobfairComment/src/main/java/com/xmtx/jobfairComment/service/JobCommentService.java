package com.xmtx.jobfairComment.service;

import com.xmtx.jobfairComment.vo.JobFairCommentVO;
import com.xmtx.jobfairComment.vo.JobFairSubCommentVO;
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
    List<JobFairCommentVO> findUpCommentByJobid(Integer jobid);

    /**
     * 找到该顶级评论所关联的所有二级评论
     * @param id
     * @return
     */
    List<JobFairSubCommentVO> findSubCommentById(Integer id);

    /**
     * 根据id查找评论
     * @param id
     */
    JobFairCommentVO findById(Integer id);

    /**
     * 根据id删除评论（用户）
     * @param id
     */
    void deleteByUser(Integer id);

    /**
     * 通过userId找到该用户所发出的评论
     * @param userId
     * @return
     */
    List<JobFairCommentVO> findUpCommentByUserId(Integer userId);

    /**
     * JobFairComment转VO
     */
    JobFairCommentVO transferToVO(JobFairComment jobFairComment);

    /**
     * List<JobFairComment>转VO的List
     * @param originList
     * @return
     */
    List<JobFairCommentVO> listVO(List<JobFairComment> originList);

}
