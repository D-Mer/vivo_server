package com.example.vivo.po;

import com.example.vivo.vo.PostForm;
import lombok.Data;

import java.util.Date;

@Data
public class PostPO {

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
    private String tag;
    /*int专业领域*/
    private int major;

    /*文件/图片url*/
    private String urls;

    public PostPO(){
    }

    public PostPO(PostForm postForm, String urls){
        this.email = postForm.getEmail();
        this.title = postForm.getTitle();
        this.description = postForm.getDescription();
        this.orderTakerEmail = postForm.getEmail();
        this.major = postForm.getMajor();
        this.tag = ""+postForm.getTagId();
        this.price = postForm.getPrice();
        this.urls = urls;
        this.startTime = new Date();
    }

}
