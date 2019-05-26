package com.example.vivo.vo;

import com.example.vivo.po.PostPO;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class PostVO {

    /*
    该帖id
    */
    private int id;
    /*
     该帖拥有者email/id
    */
    private String email;
    /*
     * 帖子标题
     * */
    private String title;

    /*帖子问题描述*/
    private String description;

    /*订单接收者email*/
    private String orderTakerEmail;

    /*订单开始时间*/
    private Date startTime;

    /*订单结束时间*/
    private Date endTime;
    /*订单状态*/

    private int state;
    /*订单价格*/

    private Double price;
    /*帖子评论id列表（化为字符串）*/
    private int commentNum;
    private String commentIds;

    /*int标签tag*/
    private String tagId;
    /*int专业领域*/
    private int major;

    /*文件/图片url*/
    private List<String> urls = new ArrayList<>();

    public PostVO(PostPO post){
        this.commentNum=post.getCommentNum();
        this.commentIds=post.getCommentIds();
        this.description=post.getDescription();
        this.email=post.getEmail();
        this.endTime=post.getEndTime();
        this.startTime=post.getStartTime();
        this.major=post.getMajor();
        this.price=post.getPrice();
        this.state =post.getState();
        this.tagId =post.getTag();
        this.orderTakerEmail =post.getOrderTakerEmail();
        this.title=post.getTitle();
        this.urls = Arrays.asList(post.getUrls().split(","));
        this.id =post.getId();
    }

//    public PostVO(PostForm postForm){
//        this.description=postForm.getDescription();
//        this.email=postForm.getEmail();
//        this.startTime=new Date();
//        this.major=postForm.getMajor();
//        this.price=postForm.getPrice();
//        this.state=0;
//        this.tagId =postForm.getTagId();
//        this.title=postForm.getTitle();
//    }
}
