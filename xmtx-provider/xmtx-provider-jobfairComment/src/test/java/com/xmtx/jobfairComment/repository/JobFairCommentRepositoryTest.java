package com.xmtx.jobfairComment.repository;

import com.xmtx.jobfairComment.JobCommentProviderApplicationTests;
import com.xmtx.jobfairComment.dataobject.JobFairComment;
import com.xmtx.jobfairComment.enums.CommentStatusEnum;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JobFairCommentRepositoryTest extends JobCommentProviderApplicationTests {

    @Autowired
    private JobCommentRepository jobCommentRepository;

    @Test
    public void testSave(){
        JobFairComment jobfairComment = new JobFairComment();
        jobfairComment.setJobId(1);
        jobfairComment.setUserId(3);
        jobfairComment.setUsername("test");
        jobfairComment.setContent("测试添加评论");
        jobfairComment.setState(CommentStatusEnum.NORMAL.getCode());
        jobfairComment.setProve(1);
        jobfairComment.setPubtime(DateTime.now().toDate());

        JobFairComment result = jobCommentRepository.save(jobfairComment);
        Assert.assertTrue(result != null);
    }
}