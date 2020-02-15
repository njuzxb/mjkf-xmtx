package com.xmtx.jobfair.service;

import com.xmtx.jobfair.dataObject.JobFair;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 22:14 2020/2/13
 * @ Description：招聘会服务
 * @ Modified By：
 * @Version: $
 */
public interface JobFairService {
    /*
     * 招聘会信息查看
     * */
    List<JobFair> job_fair_showAll();
    /*
     * 招聘会发布
     * */
    void job_fair_release(JobFair jobFair);
    /*
     * 招聘会信息修改
     * */
    void job_fair_update();
    /*
     * 招聘会信息删除
     * */
    void job_fair_delete(Integer id);

}
