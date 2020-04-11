package com.xmtx.jobfairComment.vo;

import lombok.Data;

@Data
public class SubCommentCreateVO {
    //当前评论的上一级内容的id，顶级评论parentId就是帖子的id，二级评论parentId就是对应的顶级评论的id
    private Integer commentid;

    //当前用户
    private Integer userid;

    private String username;

    private Integer replyuserid;

    private String replyusername;

    private String content;
}
