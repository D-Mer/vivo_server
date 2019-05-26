package com.example.vivo.vo;

import com.example.vivo.po.UserPO;
import lombok.Data;

@Data
public class UserVO {
    private int id;
    private String username;
    private String password;

    public UserVO(){}

    public UserVO(UserPO userPO){
        id = userPO.getId();
        username = userPO.getUsername();
        password = userPO.getPassword();
    }

}
