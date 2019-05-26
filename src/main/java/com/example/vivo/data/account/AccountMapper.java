package com.example.vivo.data.account;

import com.example.vivo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    boolean insertUser(UserPO user);

    UserPO selectUserByEmail(@Param("email") String email);

    boolean updateCredit(String email, double updateNum);

}
