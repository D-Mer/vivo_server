package com.example.vivo.po;

import com.example.vivo.vo.UserVO;
import lombok.Data;

import java.util.Date;

@Data
public class UserPO {

    public static String DefaultAuthority = "member";

    private int id;
    private String username;
    private String password;
    private Date signupDate;
    private String authority = DefaultAuthority;

    public UserPO(){
    }

    public UserPO(UserVO userVO){
        id = userVO.getId();
        username = userVO.getUsername();
        password = userVO.getPassword();
    }

}
