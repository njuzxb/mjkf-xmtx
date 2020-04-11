package com.xmtx.jobfairComment.vo;

import lombok.Data;

import java.util.Date;

@Data
public class JobFairSubCommentVO {

    //@JsonProperty("id")
    private Integer id;

    //@JsonProperty("commentid")
    private Integer commentid;

    //@JsonProperty("replyuserid")
    private Integer replyuserid;

    //@JsonProperty("replyusername")
    private String replyusername;

    //@JsonProperty("userid")
    private Integer userid;

    //@JsonProperty("username")
    private Integer username;

    //@JsonProperty("content")
    private String content;

    //@JsonProperty("pubtime")
    private Date pubtime;

    //@JsonProperty("state")
    private Integer state;

    //@JsonProperty("prove")
    private Integer prove;
}
