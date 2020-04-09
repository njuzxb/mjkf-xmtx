package com.xmtx.jobfairComment.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JobFairCommentVO {

    //@JsonProperty("id")
    private Integer id;

    //@JsonProperty("jobid")
    private Integer jobId;

    //@JsonProperty("userid")
    private Integer userId;

    //@JsonProperty("username")
    private String username;

    //@JsonProperty("content")
    private String content;

    //@JsonProperty("pubtime")
    private Date pubtime;

    //@JsonProperty("state")
    private Integer state;

    //@JsonProperty("prove")
    private Integer prove;

    /**
     * 比JobFairSubComment多一个该顶级评论下所有二级评论的集合
     */
    //@JsonProperty("reply")
    private List<JobFairSubCommentVO> relys;

}
