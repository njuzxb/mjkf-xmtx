package com.xmtx.jobfair.controller;

import com.xmtx.jobfair.converter.JobFair2JobFairInfoVO;
import com.xmtx.jobfair.converter.JobFairForm_Release2JobFair;
import com.xmtx.jobfair.dataObject.EnterpriseInfo;
import com.xmtx.jobfair.dataObject.JobFair;
import com.xmtx.jobfair.enums.ResultEnum;
import com.xmtx.jobfair.exception.JobFairException;
import com.xmtx.jobfair.form.JobFairForm_Release;
import com.xmtx.jobfair.form.JobFairForm_Update;
import com.xmtx.jobfair.repository.EnterpriseInfoRepository;
import com.xmtx.jobfair.repository.JobFairRepository;
import com.xmtx.jobfair.service.JobFairService;
import com.xmtx.jobfair.utils.ResultVOUtil;
import com.xmtx.jobfair.vo.JobFairInfoVO;
import com.xmtx.jobfair.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 22:53 2020/2/13
 * @ Description：招聘会服务控制器
 * @ Modified By：
 * @Version: $
 */
@RestController
@RequestMapping("/jobfair")
@Slf4j
public class JobFairController {
    @Autowired
    JobFairService jobFairService;
    @Autowired
    EnterpriseInfoRepository enterpriseInfoRepository;
    @Autowired
    JobFairRepository jobFairRepository;
    //get方法获取所有招聘会列表
    @GetMapping("/list")
    public ResultVO<JobFairInfoVO> list(){
        List<JobFair> list = jobFairService.job_fair_showAll();
        List<JobFairInfoVO> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i ++){
            JobFair tmpJF = list.get(i);
            //得到构造数据中的公司名字
            Optional<EnterpriseInfo> tmpEIO = enterpriseInfoRepository.findById(tmpJF.getEid());
            EnterpriseInfo tmpEI = tmpEIO.get();
            String name = tmpEI.getEnterpriseName();
            //利用转换器构造完整数据，并存入结果列表中
            JobFairInfoVO tmpJFVO = JobFair2JobFairInfoVO.convert(tmpJF);
            tmpJFVO.setEnterpriseName(name);
            res.add(tmpJFVO);
        }
        return ResultVOUtil.success(res);
    }
    @PostMapping("/release")
    public ResultVO<Map<String,Integer>> release(@Valid JobFairForm_Release jobFairFormRelease, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("招聘会发布参数不正确,jobFairFormRelease={}",jobFairFormRelease);
            throw new JobFairException(ResultEnum.PARAM_ERROR);
        }
        //将form转换为jobfair,就能调用service中的发布功能啦
        JobFair jobFair = JobFairForm_Release2JobFair.convert(jobFairFormRelease);
        jobFairService.job_fair_release(jobFair);
        Map<String,Integer> map = new HashMap<>();
        map.put("JobFairId",jobFair.getId());
        return ResultVOUtil.success(map);
    }

    @PostMapping("/update")
    public ResultVO<JobFairInfoVO> update(@Valid JobFairForm_Update jobFairFormUpdate, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("招聘会发布参数不正确,jobFairFormUpdate={}",jobFairFormUpdate);
            throw new JobFairException(ResultEnum.PARAM_ERROR);
        }
        Optional<JobFair> jobFairOptional = jobFairRepository.findById(jobFairFormUpdate.getId());
        if(!jobFairOptional.isPresent()){
            throw new JobFairException(ResultEnum.PARAM_ERROR);
        }
        JobFair jobFair = jobFairOptional.get();
        jobFair.setMeetingTime(new Date());
        jobFair.setLabel(jobFairFormUpdate.getLabel());
        jobFair.setContent(jobFairFormUpdate.getContent());
        jobFair.setAddress(jobFairFormUpdate.getAddress());
        jobFair.setTitle(jobFairFormUpdate.getTitle());
        //根据企业ID，得到企业名字，返回数据
        Optional<EnterpriseInfo> tmpEIO = enterpriseInfoRepository.findById(jobFair.getEid());
        if(!tmpEIO.isPresent()){
            throw new JobFairException(ResultEnum.PARAM_ERROR);
        }
        jobFairService.job_fair_update(jobFair);
        JobFairInfoVO jobFairInfoVO = JobFair2JobFairInfoVO.convert(jobFair);
        jobFairInfoVO.setEnterpriseName(tmpEIO.get().getEnterpriseName());
        return ResultVOUtil.success(jobFairInfoVO);
    }

    @PostMapping("/delete")
    public ResultVO<String> delete(Integer id){
        jobFairService.job_fair_delete(id);
        return ResultVOUtil.success("删除成功");
    }
}
