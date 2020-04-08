package com.xmtx.jobfairComment.service;

import com.xmtx.jobfairComment.VO.JobFairSubCommentVO;
import com.xmtx.jobfairComment.dataobject.JobFairSubComment;

import java.util.List;

public interface JobSubCommentService {

    /**
     * 添加二级评论
     */
    JobFairSubComment addSubComment(JobFairSubComment jobFairSubComment, Integer parentId);

    /**
     * 通过父级评论id查其所关联的二级评论
     * @param parentId 该二级评论所关联的父级评论
     */
    List<JobFairSubCommentVO> findSubCommentByParentId(Integer parentId);

    /**
     * 通过id找对应的二级评论
     */
    JobFairSubCommentVO findById(Integer id);

    /**
     * 删除某个二级评论
     */
    void deleteById(Integer id);

    /**
     * 通过userId找该用户所发出的二级评论
     */
    List<JobFairSubCommentVO> findByUserId(Integer userId);

    /**
     * JobFairSubComment转VO
     */
    JobFairSubCommentVO transferToVO(JobFairSubComment jobFairSubComment);

    /**
     * List<JobFairSubComment>转VO的List
     * @param originList
     * @return
     */
    List<JobFairSubCommentVO> listVO(List<JobFairSubComment> originList);
}
