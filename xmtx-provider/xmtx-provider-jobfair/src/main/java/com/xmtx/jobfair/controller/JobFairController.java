package com.xmtx.jobfair.controller;

import com.xmtx.jobfair.converter.JobFair2JobFairInfoVO;
import com.xmtx.jobfair.converter.JobFairForm2JobFair;
import com.xmtx.jobfair.dataObject.EnterpriseInfo;
import com.xmtx.jobfair.dataObject.JobFair;
import com.xmtx.jobfair.enums.ResultEnum;
import com.xmtx.jobfair.exception.JobFairException;
import com.xmtx.jobfair.form.JobFairForm;
import com.xmtx.jobfair.repository.EnterpriseInfoRepository;
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

import javax.naming.Binding;
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
    public ResultVO<Map<String,Integer>> release(@Valid JobFairForm jobfairForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("招聘会发布参数不正确,jobfair={}",jobfairForm);
            throw new JobFairException(ResultEnum.PARAM_ERROR);
        }
        //将form转换为jobfair,就能调用service中的发布功能啦
        JobFair jobFair = JobFairForm2JobFair.convert(jobfairForm);
        jobFairService.job_fair_release(jobFair);
        Map<String,Integer> map = new HashMap<>();
        map.put("JobFairId",jobFair.getId());
        return ResultVOUtil.success(map);
    }

    @PostMapping("/delete")
    public ResultVO<String> delete(Integer id){
        jobFairService.job_fair_delete(id);
        return ResultVOUtil.success("删除成功");
    }
}
