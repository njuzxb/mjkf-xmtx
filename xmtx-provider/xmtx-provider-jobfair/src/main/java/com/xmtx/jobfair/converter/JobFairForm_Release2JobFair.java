package com.xmtx.jobfair.converter;

import com.xmtx.jobfair.dataObject.JobFair;
import com.xmtx.jobfair.form.JobFairForm_Release;
import com.xmtx.jobfair.utils.KeyUtil;

import java.util.Date;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 13:10 2020/2/15
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class JobFairForm_Release2JobFair {
    public static JobFair convert(JobFairForm_Release form){
        JobFair jobFair = new JobFair();
        jobFair.setEid(form.getEid());
        jobFair.setAddress(form.getAddress());
        jobFair.setPromoter(form.getPromoter_name());
        jobFair.setTitle(form.getTitle());
        jobFair.setLabel(form.getLabel());
        jobFair.setContent(form.getContent());
        jobFair.setEnabled(1);
        jobFair.setMeetingTime(new Date());
        jobFair.setCommentNum(0);
        jobFair.setProveNum(0);
        //同步方法随机产生唯一ID
        jobFair.setId(KeyUtil.genUniqueKey());
        return jobFair;
    }
}
