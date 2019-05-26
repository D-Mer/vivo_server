package com.example.vivo.vo;

import com.example.vivo.po.PostPO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostsVO {

    /*
    该帖id
    */
    private int postId;
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
    private String orderTaker;

    /*订单开始时间*/
    private Date startTime;

    /*订单结束时间*/
    private Date endTime;
    /*订单状态*/

    private String status;
    /*订单价格*/

    private Double price;
    /*帖子评论id列表（化为字符串）*/
    private String commentIds;

    /*int标签tag*/
    private int tag;
    /*int专业领域*/
    private int major;

    /*文件/图片url*/
    private String url;

    public PostsVO(PostPO post){
        this.commentIds=post.getCommentIds();
        this.description=post.getDescription();
        this.email=post.getEmail();
        this.endTime=post.getEndTime();
        this.startTime=post.getStartTime();
        this.major=post.getMajor();
        this.price=this.getPrice();
        this.status=post.getStatus();
        this.tag=post.getTag();
        this.orderTaker=post.getOrderTaker();
        this.title=post.getTitle();
        this.url=post.getUrl();
        this.postId=post.getPostId();
    }
}
