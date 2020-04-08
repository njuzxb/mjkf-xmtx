package com.xmtx.jobfairComment.VO;

import lombok.Getter;

@Getter
public class CommentCreateVO {

    //当前评论的上一级内容的id，顶级评论parentId就是帖子的id，二级评论parentId就是对应的顶级评论的id
    private Integer parentId;
    //当前用户
    private Integer userId;
    private String content;

    //用于区分/comment接口收到的是顶级评论还是二级评论
    private Integer type;
}
