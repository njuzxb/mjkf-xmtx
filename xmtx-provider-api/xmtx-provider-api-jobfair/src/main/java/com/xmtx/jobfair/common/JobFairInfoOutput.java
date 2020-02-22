package com.xmtx.jobfair.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 0:16 2020/2/19
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobFairInfoOutput implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer jobfairId;
    private String enterpriseName;
    private String jobfairAddress;
    private String jobfairTitle;
    private String jobfairLabel;
    private String jobfairContent;

}
