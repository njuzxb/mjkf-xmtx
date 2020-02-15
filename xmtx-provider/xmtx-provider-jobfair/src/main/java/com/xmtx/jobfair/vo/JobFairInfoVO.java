package com.xmtx.jobfair.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:39 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class JobFairInfoVO {
    @JsonProperty("id")
    private Integer jobfairId;
    @JsonProperty("name")
    private String enterpriseName;
    @JsonProperty("address")
    private String jobfairAddress;
    @JsonProperty("title")
    private String jobfairTitle;
    @JsonProperty("label")
    private String jobfairLabel;
    @JsonProperty("content")
    private String jobfairContent;
}
