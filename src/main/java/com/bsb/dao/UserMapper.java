package com.bsb.dao;

import com.bsb.pojo.Data;
import com.bsb.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT COUNT(1) FROM user_table WHERE phone = #{phone}")
    int checkPhone(String phone);

    @Select("SELECT * FROM user_table WHERE phone = #{phone} AND password = #{password}")
    User login(@Param("phone") String phone, @Param("password") String password);
}
