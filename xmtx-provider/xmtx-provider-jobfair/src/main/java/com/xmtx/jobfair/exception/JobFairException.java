package com.xmtx.jobfair.exception;

import com.xmtx.jobfair.enums.JobFairStatusEnum;
import com.xmtx.jobfair.enums.ResultEnum;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 23:09 2020/2/13
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class JobFairException extends RuntimeException{
    private Integer code;

    public JobFairException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public JobFairException(Integer code,String msg){
        this.code = code;
    }
    public JobFairException(JobFairStatusEnum jobFairStatusEnum){
        super(jobFairStatusEnum.getMsg());
        this.code = jobFairStatusEnum.getCode();
    }
}
