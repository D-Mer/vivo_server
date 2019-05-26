package com.example.vivo.blImpl;

import com.example.vivo.bl.AccountService;
import com.example.vivo.data.account.AccountMapper;
import com.example.vivo.po.UserPO;
import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserForm;
import com.example.vivo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public ResponseVO login(UserForm user) {
        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println("用户名为："+ email +" 密码为："+password+"\n请求登录");
        ResponseVO response;
        UserPO userPO = accountMapper.selectUserByEmail(email);
        if (userPO == null){
            response = ResponseVO.buildFailure(false);
            response.setMessage("用户名不存在");
        }else if (!password.equals(userPO.getPassword())){
            response = ResponseVO.buildFailure(false);
            response.setMessage("用户名或密码错误");
        }else {
            response = ResponseVO.buildSuccess(true);
            response.setMessage("登录成功");
        }
        return response;
    }

    @Override
    public ResponseVO insertUser(UserForm user) {
//        userPO.setSignupDate(new Date());
//        if (!user.getVerificationCode().equals("123")){
//            return ResponseVO.buildFailure("验证码错误");
//        }
        try{
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getVerificationCode());
            UserPO userPO = new UserPO(user);
            accountMapper.insertUser(userPO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("该邮箱已被注册");
        }
        return ResponseVO.buildSuccess("注册成功");
    }

    @Override
    public ResponseVO selectUserByEmail(String email) {
        return null;
    }
}
