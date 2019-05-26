package com.example.vivo.po;

import lombok.Data;

import java.util.Date;

@Data
public class PostPO {

    /*
    该帖id
    */
    private int postId;
    /*
     该帖拥有者email/postId
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

    private int status;
    /*订单价格*/

    private Double price;
    /*帖子评论id列表（化为字符串）*/
    private int commentNum;
    private String commentIds;

    /*int标签tag*/
    private int tag;
    /*int专业领域*/
    private int major;

    /*文件/图片url*/
    private String urls;
}
