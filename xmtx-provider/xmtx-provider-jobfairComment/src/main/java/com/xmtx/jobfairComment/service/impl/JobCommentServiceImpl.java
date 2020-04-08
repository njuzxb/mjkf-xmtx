package com.xmtx.jobfairComment.service.impl;

import com.xmtx.jobfairComment.VO.JobFairCommentVO;
import com.xmtx.jobfairComment.VO.JobFairSubCommentVO;
import com.xmtx.jobfairComment.dataobject.JobFairComment;
import com.xmtx.jobfairComment.dataobject.JobFairSubComment;
import com.xmtx.jobfairComment.enums.CommentStatusEnum;
import com.xmtx.jobfairComment.repository.JobFairCommentRepository;
import com.xmtx.jobfairComment.repository.JobFairSubCommentRepository;
import com.xmtx.jobfairComment.service.JobCommentService;
import com.xmtx.jobfairComment.service.JobSubCommentService;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class JobCommentServiceImpl implements JobCommentService {

    @Autowired
    JobFairCommentRepository jobFairCommentRepository;

    JobSubCommentService jobSubCommentService;


    /**
     * 新增评论
     * @param jobFairComment
     * @return
     */
    @Override
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
     * 根据jobid查找所有“正常”评论
     * 并查到该顶级评论下属所有二级评论
     * @param jobid
     * @return
     */
    @Override
    public List<JobFairCommentVO> findUpCommentByJobid(Integer jobid){
        // 从数据库查到jobid对应的所有JobFairComment，然后封装为List<JobFairCommentVO>返回

        List<JobFairComment> originList = jobFairCommentRepository.findAllByJobidAndState(jobid, CommentStatusEnum.NORMAL.getCode());
        List<JobFairCommentVO> jobFairCommentVOList = listVO(originList);
        return jobFairCommentVOList;
    }

    /**
     * 找到当前顶级评论所关联的所有二级评论
     * @param id
     * @return
     */
    @Override
    public List<JobFairSubCommentVO> findSubCommentById(Integer id) {
        return jobSubCommentService.findSubCommentByParentId(id);
    }

    /**
     * 根据id查找
     * @param id
     */
    @Override
    public JobFairCommentVO findById(Integer id){

        JobFairComment jobFairComment = jobFairCommentRepository.findById(id).get();
        JobFairCommentVO jobFairCommentVO = transferToVO(jobFairComment);
        return jobFairCommentVO;
    }

    /**
     * 根据id删除评论（用户）
     * @param id
     */
    @Override
    public void deleteByUser(Integer id){



        // 从数据库删除评论(用户）
        jobFairCommentRepository.deleteById(id);

        // 级联删除其下属二级评论
        List<JobFairSubCommentVO> subComments = jobSubCommentService.findSubCommentByParentId(id);

        for(JobFairSubCommentVO subComment : subComments) {
            jobSubCommentService.deleteById(subComment.getId());
        }
    }

    /**
     * 通过userId找到该用户所发出的所有顶级评论
     * @param userId
     * @return
     */
    @Override
    public List<JobFairCommentVO> findUpCommentByUserId(Integer userId) {
        List<JobFairComment> originList = jobFairCommentRepository.findAllByUserId(userId, CommentStatusEnum.NORMAL.getCode());
        List<JobFairCommentVO> jobFairCommentVOList = listVO(originList);
        return jobFairCommentVOList;
    }

    /**
     * JobFairComment转VO
     */
    @Override
    public JobFairCommentVO transferToVO(JobFairComment jobFairComment) {
        JobFairCommentVO jobFairCommentVO = new JobFairCommentVO();
        BeanUtils.copyProperties(jobFairComment, jobFairCommentVO);

        List<JobFairSubCommentVO> subCommentList = findSubCommentById(jobFairComment.getId());

        //设置顶级评论下属二级评论
        jobFairCommentVO.setRelys(subCommentList);

        return jobFairCommentVO;
    }

    /**
     * List<JobFairComment>转VO的List
     * @param originList
     * @return
     */
    @Override
    public List<JobFairCommentVO> listVO(List<JobFairComment> originList) {
        List<JobFairCommentVO> jobFairCommentVOList = originList.stream().map(jobFairComment -> {
            JobFairCommentVO jobFairCommentVO = new JobFairCommentVO();
            BeanUtils.copyProperties(jobFairComment, jobFairCommentVO);

            //通过顶级评论id找到其下属二级评论
            List<JobFairSubCommentVO> subCommentList = findSubCommentById(jobFairComment.getId());

            //设置顶级评论下属二级评论
            jobFairCommentVO.setRelys(subCommentList);

            return jobFairCommentVO;
        }).collect(Collectors.toList());

        return jobFairCommentVOList;
    }

}
