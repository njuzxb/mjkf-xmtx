package com.xmtx.jobfair.service;

import com.xmtx.jobfair.dataObject.JobFair;

import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 22:14 2020/2/13
 * @ Description：招聘会服务
 * @ Modified By：
 * @Version: $
 */
public interface JobFairService {


    /*
    * 根据id查找招聘信息
    * */
    Optional<JobFair> job_fair_findById(Integer id);


    /*
     * 招聘会列表信息查看
     * */
    List<JobFair> job_fair_showAll(Integer pn);

    /*
     * 招聘会发布
     * */
    void job_fair_release(JobFair jobFair);
    /*
     * 招聘会信息修改
     * */
    void job_fair_update(JobFair jobFair);
    /*
     * 招聘会信息删除
     * */
    void job_fair_delete(Integer id);

}
