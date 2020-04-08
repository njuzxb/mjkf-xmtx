package com.xmtx.jobfairComment.dataobject;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "job_fair_subcomment")
public class JobFairSubComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键

    private Integer parentId; //父级评论id

    private Integer replyUserId;//被评论的用户

    private String replyUsername;

    private Integer userId;//发起评论的用户

    private String username;

    private String content;

    private Date pubtime;

    private Integer state;

    private Integer prove;
}