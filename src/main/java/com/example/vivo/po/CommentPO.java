package com.example.vivo.po;

import com.example.vivo.vo.ReplyForm;
import lombok.Data;

import java.util.Date;

@Data
public class CommentPO {

    /**
     * 回复的id标识
     * */
    private int id;

    /**
     * 回复者的邮箱
     * */
    private String replierEmail;

    /**
     * 回复的帖子的id
     * */
    private int postId;

    /**
     * 被回复评论的id(不是楼中楼则为空)
     * */
    private int firstCommentId;

    /**
     * 被回复楼中楼id(不是回复楼中楼的则为空)
     * */
    private int secondCommentId;

    /**
     * 回复内容
     * */
    private String content;

    /**
     * 回复中的图片
     * */
    private String urls;

    /**
     * 回复时间
     * */
    private Date time;

    public CommentPO(){}

    public CommentPO(ReplyForm replyForm, String urls){
        this.postId = replyForm.getPostId();
        this.replierEmail = replyForm.getEmail();
        this.firstCommentId = replyForm.getFirstCommentId();
        this.secondCommentId = replyForm.getSecondCommentId();
        this.content = replyForm.getContent();
        this.urls = urls;
        this.time = new Date();
    }


}
