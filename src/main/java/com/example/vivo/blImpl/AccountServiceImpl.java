package com.example.vivo.blImpl;

import com.example.vivo.bl.AccountService;
import com.example.vivo.data.account.AccountMapper;
import com.example.vivo.po.UserPO;
import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public ResponseVO login(String username, String password) {
        System.out.println("用户名为："+ username +" 密码为："+password);
        ResponseVO response;
        UserPO userPO = accountMapper.selectUserByName(username);
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
    public ResponseVO insertUser(UserVO user) {
        UserPO userPO = new UserPO(user);
        userPO.setSignupDate(new Date());
        try{
            accountMapper.insertUser(userPO);
        }catch (Exception e){
            return ResponseVO.buildFailure("用户名已存在");
        }
        return ResponseVO.buildSuccess("注册成功");
    }

    @Override
    public ResponseVO selectUserById(int id) {
        UserPO userPO = accountMapper.selectUserById(id);
        return ResponseVO.buildSuccess(userPO);
    }

    @Override
    public ResponseVO selectUserByName(String username) {
        return null;
    }
}
