package com.xmtx.jobfairComment.vo;

import lombok.Data;

@Data
public class CommentCreateVO {

    //当前评论的上一级内容的id，顶级评论parentId就是帖子的id，二级评论parentId就是对应的顶级评论的id
    private Integer jobId;

    //当前用户
    private Integer userId;

    private String username;

    private String content;
}
