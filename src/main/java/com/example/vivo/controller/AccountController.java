package com.example.vivo.controller;

import com.example.vivo.bl.AccountService;
import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserForm;
import com.example.vivo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm user){
        return accountService.login(user);
    }

    @PostMapping("/register")
    public ResponseVO register(@RequestBody UserForm user){
        return accountService.insertUser(user);
    }

}
