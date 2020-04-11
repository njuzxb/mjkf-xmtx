package com.xmtx.jobfairComment.service.impl;

import com.xmtx.jobfairComment.repository.JobCommentRepository;
import com.xmtx.jobfairComment.repository.JobSubCommentRepository;
import com.xmtx.jobfairComment.vo.JobFairSubCommentVO;
import com.xmtx.jobfairComment.dataobject.JobFairSubComment;
import com.xmtx.jobfairComment.enums.CommentErrorCode;
import com.xmtx.jobfairComment.enums.CommentStatusEnum;
import com.xmtx.jobfairComment.exception.CommentException;
import com.xmtx.jobfairComment.service.JobSubCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobSubCommentServiceImpl implements JobSubCommentService {

    @Autowired
    JobSubCommentRepository jobSubCommentRepository;

    @Autowired
    JobCommentRepository jobCommentRepository;

    /**
     * 向parentId所指的父级评论回复二级评论
     */
    @Override
    public JobFairSubComment addSubComment(JobFairSubComment jobFairSubComment, Integer parentId) {

        jobFairSubComment.setParentId(parentId);
        jobFairSubComment.setState(CommentStatusEnum.NORMAL.getCode());
        jobFairSubComment.setProve(0);
        jobFairSubComment.setPubtime(new Date());

        jobSubCommentRepository.save(jobFairSubComment);

        return jobFairSubComment;
    }

    /**
     * 通过父级评论parentId找到其所关联的所有二级评论
     */
    @Override
    public List<JobFairSubCommentVO> findAllSubCommentByParentId(Integer parentId) {
        List<JobFairSubComment> originList = jobSubCommentRepository.findAllByParentIdAndState(parentId, CommentStatusEnum.NORMAL.getCode());
        List<JobFairSubCommentVO> jobFairSubCommentVOList = listVO(originList);
        return jobFairSubCommentVOList;
    }

    /**
     * 找到id对应的二级评论
     */
    @Override
    public JobFairSubCommentVO findById(Integer id) {
        Optional<JobFairSubComment> optionalJobFairSubComment = jobSubCommentRepository.findById(id);
        if(!optionalJobFairSubComment.isPresent()) {
            throw new CommentException(CommentErrorCode.SUBCOMMENT_NOT_EXIST);
        } else {
            JobFairSubComment jobFairSubComment = optionalJobFairSubComment.get();
            JobFairSubCommentVO jobFairSubCommentVO = transferToVO(jobFairSubComment);
            return jobFairSubCommentVO;
        }
    }

    /**
     * 删除某个二级评论
     */
    @Override
    public void deleteById(Integer id) {
        Optional<JobFairSubComment> optionalJobFairSubComment = jobSubCommentRepository.findById(id);
        if(!optionalJobFairSubComment.isPresent()) {
            throw new CommentException(CommentErrorCode.SUBCOMMENT_NOT_EXIST);
        }

        jobSubCommentRepository.deleteById(id);
    }

    /**
     * 通过userId找该用户所发出的二级评论
     */
    @Override
    public List<JobFairSubCommentVO> findByUserId(Integer userId) {
        List<JobFairSubComment> originList = jobSubCommentRepository.findAllByUserIdAndState(userId, CommentStatusEnum.NORMAL.getCode());
        List<JobFairSubCommentVO> jobFairSubCommentVOList = listVO(originList);
        return jobFairSubCommentVOList;
    }

    /**
     * JobFairSubComment转VO
     */
    @Override
    public JobFairSubCommentVO transferToVO(JobFairSubComment jobFairSubComment) {
        JobFairSubCommentVO jobFairSubCommentVO = new JobFairSubCommentVO();
        BeanUtils.copyProperties(jobFairSubComment, jobFairSubCommentVO);
        return jobFairSubCommentVO;
    }

    /**
     * List<JobFairSubComment>转VO的List
     * @param originList
     * @return
     */
    @Override
    public List<JobFairSubCommentVO> listVO(List<JobFairSubComment> originList) {

        List<JobFairSubCommentVO> jobFairSubCommentVOList = originList.stream().map(jobFairSubComment -> {
            JobFairSubCommentVO jobFairSubCommentVO = new JobFairSubCommentVO();
            BeanUtils.copyProperties(jobFairSubComment, jobFairSubCommentVO);
            return jobFairSubCommentVO;
        }).collect(Collectors.toList());

        return jobFairSubCommentVOList;
    }
}
