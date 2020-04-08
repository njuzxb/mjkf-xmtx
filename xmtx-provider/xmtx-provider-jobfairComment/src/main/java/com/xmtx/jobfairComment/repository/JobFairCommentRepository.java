package com.xmtx.jobfairComment.repository;

import com.xmtx.jobfairComment.dataobject.JobFairComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobFairCommentRepository extends JpaRepository<JobFairComment, Integer> {

    //找到id为jobid的帖子下的所有评论
    List<JobFairComment> findAllByJobidAndState(Integer jobId, Integer state);

    //找到id为userid的用户所发起的所有评论
    List<JobFairComment> findAllByUserId(Integer userId, Integer state);

}
