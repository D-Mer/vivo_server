package com.example.vivo.blImpl;

import com.example.vivo.bl.AccountService;
import com.example.vivo.data.account.AccountMapper;
import com.example.vivo.po.UserPO;
import com.example.vivo.vo.ResponseVO;
import com.example.vivo.vo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService, AccountServiceForBL {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public ResponseVO login(UserForm user) {
        String email = user.getEmail();
        String password = user.getPassword();
        ResponseVO response;
        UserPO userPO = accountMapper.selectUserByEmail(email);
        if (userPO == null){
            response = ResponseVO.buildFailure(null);
            response.setMessage("用户名不存在");
        }else if (!password.equals(userPO.getPassword())){
            response = ResponseVO.buildFailure(null);
            response.setMessage("用户名或密码错误");
        }else {
            response = ResponseVO.buildSuccess(null);
            response.setMessage("登录成功");
        }
        return response;
    }

    @Override
    public ResponseVO insertUser(UserForm user) {
        ResponseVO response;
        try{
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getVerificationCode());
            UserPO userPO = new UserPO(user);
            accountMapper.insertUser(userPO);
        }catch (Exception e){
            response = ResponseVO.buildFailure(null);
            response.setMessage("该邮箱已被注册");
            return response;
        }
        response = ResponseVO.buildFailure(null);
        response.setMessage("注册成功");
        return response;
    }

    @Override
    public boolean updateCredit(String email, int updateNum) {
        return accountMapper.updateCredit(email,updateNum);
    }
}
