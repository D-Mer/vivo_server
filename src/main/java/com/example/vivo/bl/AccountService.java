package com.example.vivo.bl;

import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserVO;

public interface AccountService {

    ResponseVO login(String username, String password);

    ResponseVO insertUser(UserVO user);

    ResponseVO selectUserById(int id);

    ResponseVO selectUserByName(String name);
}
