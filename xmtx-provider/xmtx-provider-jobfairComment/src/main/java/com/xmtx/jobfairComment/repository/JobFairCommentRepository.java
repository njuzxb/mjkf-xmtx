package com.xmtx.jobfairComment.repository;

import com.xmtx.jobfairComment.dataobject.JobFairComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobFairCommentRepository extends JpaRepository<JobFairComment, Integer> {

    List<JobFairComment> findAllByJobidAndState(Integer jobid, Integer state);

}
