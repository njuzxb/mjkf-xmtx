package com.xmtx.jobfair.service.Impl;

import com.xmtx.jobfair.dataObject.EnterpriseInfo;
import com.xmtx.jobfair.dataObject.JobFair;
import com.xmtx.jobfair.enums.JobFairStatusEnum;
import com.xmtx.jobfair.enums.ResultEnum;
import com.xmtx.jobfair.exception.JobFairException;
import com.xmtx.jobfair.repository.EnterpriseInfoRepository;
import com.xmtx.jobfair.repository.JobFairRepository;
import com.xmtx.jobfair.service.JobFairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 22:39 2020/2/13
 * @ Description：招聘会服务具体实现
 * @ Modified By：
 * @Version: $
 */
@Service
public class JobFairServiceImpl implements JobFairService {
    @Autowired
    JobFairRepository jobFairRepository;

    @Autowired
    EnterpriseInfoRepository enterpriseInfoRepository;

    @Override
    public List<JobFair> job_fair_showAll() {
        return jobFairRepository.findAll();
    }

    //发布招聘会时，要先检查有没有这个公司。
    @Override
    public void job_fair_release(JobFair jobFair) {
        int eid = jobFair.getEid();
        //根据eid判断公司是否存在
        Optional<EnterpriseInfo> enterpriseInfoOptional = enterpriseInfoRepository.findById(eid);
        if(!enterpriseInfoOptional.isPresent()){
            throw new JobFairException(ResultEnum.JOBFAIR_NOT_EXIST);
        }
        System.out.println("存在该公司");
        //判断该公司的Enable字段是否为true，若为false。则没有发布招聘会的资格
        EnterpriseInfo enterpriseInfo = enterpriseInfoOptional.get();
        if(!enterpriseInfo.isEnabled() || !jobFair.isEnabled()){
            throw new JobFairException(JobFairStatusEnum.DISABLE);
        }
        System.out.println(JobFairStatusEnum.ENABLE.getMsg());
        jobFairRepository.save(jobFair);
    }


    @Override
    public void job_fair_update(JobFair jobFair) {
        int eid = jobFair.getEid();
        //根据eid判断公司是否存在
        Optional<EnterpriseInfo> enterpriseInfoOptional = enterpriseInfoRepository.findById(eid);
        if(!enterpriseInfoOptional.isPresent()){
            throw new JobFairException(ResultEnum.JOBFAIR_NOT_EXIST);
        }
        System.out.println("存在该公司");
        //判断该公司的Enable字段是否为true，若为false。则没有发布招聘会的资格
        EnterpriseInfo enterpriseInfo = enterpriseInfoOptional.get();
        if(!enterpriseInfo.isEnabled() || !jobFair.isEnabled()){
            throw new JobFairException(JobFairStatusEnum.DISABLE);
        }
        System.out.println(JobFairStatusEnum.ENABLE.getMsg());
        jobFairRepository.save(jobFair);
    }

    @Override
    public void job_fair_delete(Integer id) {
        jobFairRepository.deleteById(id);
    }
}
