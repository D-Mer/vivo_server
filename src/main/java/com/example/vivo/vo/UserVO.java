package com.example.vivo.vo;

import com.example.vivo.po.UserPO;
import lombok.Data;

@Data
public class UserVO {
    private String email;
    private String password;
    private int major;
    private int secondMajor;
    private int minor;
    private double balance;
    private String hobbies;
    private int credit;
    private String posts;
    private String qq;
    private String wechat;
    private String tel;
    public UserVO(){}

    public UserVO(UserPO userPO){
        email = userPO.getEmail();
        password = userPO.getPassword();
    }

}
