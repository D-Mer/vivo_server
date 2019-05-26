package com.example.vivo.vo;

import lombok.Data;

@Data
public class UserForm {
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
    private String verificationCode;
}
