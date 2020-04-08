package com.xmtx.jobfairComment.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)    //链式写法
@Entity
@Table(name = "job_fair_comment")
public class JobFairComment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键

    private Integer jobId;

    private Integer userId;

    private String username;

    private String content;

    private Date pubtime;

    private Integer state;

    private Integer prove;

}
