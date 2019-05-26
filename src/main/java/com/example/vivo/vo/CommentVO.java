package com.example.vivo.vo;

import com.example.vivo.po.CommentPO;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class CommentVO {

    /**
     * 回复的id标识
     * */
    private int id;

    /**
     * 回复的帖子的id
     * */
    private int postId;

    /**
     * 回复者的邮箱
     * */
    private String replierEmail;

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
    private List<String> urls;

    public CommentVO(){}

    public CommentVO(CommentPO commentPO){
        this.id = commentPO.getId();
        this.postId = commentPO.getPostId();
        this.replierEmail = commentPO.getReplierEmail();
        this.firstCommentId = commentPO.getFirstCommentId();
        this.secondCommentId = commentPO.getSecondCommentId();
        this.content = commentPO.getContent();
        this.urls = Arrays.asList(commentPO.getUrls().split(","));
    }
}
