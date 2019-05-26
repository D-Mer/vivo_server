package com.example.vivo.controller;

import com.example.vivo.bl.AccountService;
import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public ResponseVO login(@RequestParam("username") String username, @RequestParam("password") String password){
        return accountService.login(username, password);
//        try {
//            ResponseVO response;
//            if (username.equals("asdasd") && password.equals("zxczxc")){
//                response = ResponseVO.buildSuccess(true);
//                response.setMessage("登录成功:"+username);
//                return response;
//            }else {
//                response = ResponseVO.buildFailure(false);
//                response.setMessage("登录失败：账号名或密码错误");
//                return response;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseVO.buildFailure("unknown Exception happened");
//        }
    }

    @PostMapping("/signup")
    public ResponseVO signup(@RequestBody UserVO user){
        return accountService.insertUser(user);
//        try {
//            ResponseVO response;
//            if (!user.getUsername().equals("asdasd")){
//                response = ResponseVO.buildSuccess(true);
//                response.setMessage("注册成功，账号名为"+user.getUsername());
//                return response;
//            }else {
//                response = ResponseVO.buildFailure(false);
//                response.setMessage("注册失败，账号名"+user.getUsername()+"已存在");
//                return response;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseVO.buildFailure("unknown Exception happened");
//        }
    }

}
