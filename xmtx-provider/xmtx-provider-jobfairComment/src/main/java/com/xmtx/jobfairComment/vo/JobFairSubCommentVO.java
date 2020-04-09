package com.xmtx.jobfairComment.vo;

import lombok.Data;

import java.util.Date;

@Data
public class JobFairSubCommentVO {

    //@JsonProperty("id")
    private Integer id;

    //@JsonProperty("commentid")
    private Integer parentId;

    //@JsonProperty("replyuserid")
    private Integer relyUserId;

    //@JsonProperty("replyusername")
    private String replyUsername;

    //@JsonProperty("userid")
    private Integer userId;

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
