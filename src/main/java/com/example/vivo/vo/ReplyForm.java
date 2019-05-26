package com.example.vivo.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReplyForm {

    /**
     * 帖子id
     * */
    private int postId;

    /**
     * 被回复评论id(不是楼中楼则传空)
     */
    private int firstCommentId;

    /**
     * 被回复楼中楼id(不是回复楼中楼的则传空)
     */
    private int secondCommentId;

    /**
     * 回复者邮箱
     * */
    private String email;

    /**
     * 回复内容
     * */
    private String content;

    /**
     * 回复内容总的图片(楼中楼无图)
     */
    private List<MultipartFile> pictures;



}
