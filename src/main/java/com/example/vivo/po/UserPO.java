package com.example.vivo.po;

import com.example.vivo.vo.UserForm;
import com.example.vivo.vo.UserVO;
import lombok.Data;

import java.util.Date;

@Data
public class UserPO {
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

    public UserPO(){
    }

    public UserPO(UserVO userVO){
        email = userVO.getEmail();
        password = userVO.getPassword();
    }

    public UserPO(UserForm userForm){
        email = userForm.getEmail();
        password = userForm.getPassword();
    }

}
