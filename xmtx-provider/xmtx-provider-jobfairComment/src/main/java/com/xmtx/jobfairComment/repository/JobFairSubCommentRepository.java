package com.xmtx.jobfairComment.repository;

import com.xmtx.jobfairComment.dataobject.JobFairSubComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobFairSubCommentRepository extends JpaRepository<JobFairSubComment, Integer> {

    //找到id为parentId的父级评论下的所有二级评论
    List<JobFairSubComment> findByParentIdAndState(Integer parentId, Integer state);

    //找到userId对应的用户所发起的二级评论
    List<JobFairSubComment> findByUserIdAndState(Integer userId, Integer state);
}
