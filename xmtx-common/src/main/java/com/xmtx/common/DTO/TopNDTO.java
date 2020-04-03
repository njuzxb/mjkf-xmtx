package com.xmtx.common.DTO;


import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class TopNDTO implements Serializable {
    private static final long serialVersionUID = 294655766971777057L;

//    Integer getJobid();
//
//    Integer getBrowsingNum();


    public TopNDTO(BigInteger jobid, BigInteger browsingNum) {
        super();
        this.jobid = jobid;
        this.browsingNum = browsingNum;
    }

    BigInteger jobid;
    BigInteger browsingNum;


}
