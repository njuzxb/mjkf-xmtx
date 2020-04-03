package com.xmtx.jobfair.controller;

import com.alibaba.fastjson.JSON;
import com.xmtx.common.DTO.TopNDTO;
import com.xmtx.history.client.HistoryClient;
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
import com.xmtx.jobfair.vo.JobFairInfoVO;
import com.xmtx.common.utils.ResultVOUtil;
import com.xmtx.common.VO.ResultVO;
import com.xmtx.redis.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
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
public class JobFairController {
    @Autowired
    JobFairService jobFairService;
    @Autowired
    EnterpriseInfoRepository enterpriseInfoRepository;
    @Autowired
    JobFairRepository jobFairRepository;
    @Autowired
    HistoryClient historyClient;
    @Autowired
    RedisClient redisClient;

    // 查询Top列表
    public void getTopNJobid(){
        // 1、从redis中取出zset（topN-jobid）;
        // 2、根据循环读取放入List中




    }

    // 根据id查询招聘信息
    @GetMapping("/findByJobid")
    public ResultVO findByJobid(@RequestParam("jobid") Integer jobid, @RequestParam("userid") Integer userid){

        long starTime = System.currentTimeMillis();
        // 查询缓存
//        boolean hasKey = redisClient.exists(jobid.toString());
//
//        if(hasKey){
//
//            // TODO 2、根据查询结果，成功则插入浏览记录（是否要用消息队列）
//            historyClient.saveBrowsingHistory(jobid, userid);
//            // 缓存存在则直接读取缓存
//            System.err.println("总耗时：  " + (System.currentTimeMillis() - starTime) + " 毫秒");
//            ResultVO resultVO = redisClient.retrieveStringValueByStringKey(jobid.toString());
//
//             return ResultVOUtil.success(JSON.parse(resultVO.getData().toString()));
//        }else {
            // 缓存不存在则读取数据库，然后添加缓存
            // 根据id查询招聘信息
            Optional<JobFair> jobFair = jobFairService.job_fair_findById(jobid);
            if(!jobFair.isPresent()){
                return ResultVOUtil.error("招聘信息已被删除");
            }
            // redisClient.saveNormalStringKeyValue(jobid.toString(), JSON.toJSONString(jobFair.get()), 60 * 24);
            // TODO 2、根据查询结果，成功则插入浏览记录（是否要用消息队列）
            historyClient.saveBrowsingHistory(jobid, userid);
            System.err.println("总耗时：  " + (System.currentTimeMillis() - starTime) + " 毫秒");
            return ResultVOUtil.success(jobFair.get());
        //}

    }

    //get方法获取所有招聘会列表
    @GetMapping("/list")
    public ResultVO<JobFairInfoVO> list(Integer pn){
        List<JobFair> list = jobFairService.job_fair_showAll(pn);
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
            // log.error("招聘会发布参数不正确,jobFairFormRelease={}",jobFairFormRelease);
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
            // log.error("招聘会发布参数不正确,jobFairFormUpdate={}",jobFairFormUpdate);
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
        // 删除缓存
       // redisClient.removeByKey(jobFair.getId().toString());
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
