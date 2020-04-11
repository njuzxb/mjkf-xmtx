package com.xmtx.jobfairComment.repository;

import com.xmtx.jobfairComment.dataobject.JobFairComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobCommentRepository extends JpaRepository<JobFairComment, Integer> {

    //找到id为jobid的帖子下的所有评论
    List<JobFairComment> findAllByJobIdAndState(Integer jobId, Integer state);

    //找到id为userid的用户所发起的所有评论
    List<JobFairComment> findAllByUserIdAndState(Integer userId, Integer state);

    //通过id和状态找顶级评论
    Optional<JobFairComment> findByIdAndState(Integer id, Integer state);

}
