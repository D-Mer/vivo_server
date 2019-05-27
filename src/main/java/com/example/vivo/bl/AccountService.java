package com.example.vivo.bl;

import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserForm;
import com.example.vivo.vo.UserVO;

public interface AccountService {

    ResponseVO login(UserForm user);

    ResponseVO insertUser(UserForm user);
}
