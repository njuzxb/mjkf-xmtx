package com.xmtx.jobfair.converter;

import com.xmtx.jobfair.dataObject.JobFair;
import com.xmtx.jobfair.vo.JobFairInfoVO;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 12:16 2020/2/15
 * @ Description：构造数据转换器
 * @ Modified By：
 * @Version: $
 */
public class JobFair2JobFairInfoVO {
    public static JobFairInfoVO convert(JobFair jobFair){
        JobFairInfoVO tmpJFVO = new JobFairInfoVO();
        tmpJFVO.setJobfairId(jobFair.getId());
        tmpJFVO.setJobfairAddress(jobFair.getAddress());
        tmpJFVO.setJobfairTitle(jobFair.getTitle());
        tmpJFVO.setJobfairLabel(jobFair.getLabel());
        tmpJFVO.setComment_num(jobFair.getCommentNum());
        tmpJFVO.setProve_num(jobFair.getProveNum());
        return tmpJFVO;
    }
}
