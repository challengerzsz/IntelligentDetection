package com.bsb.dao;

import com.bsb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT COUNT(1) FROM user_table WHERE phone = #{phone}")
    int checkPhone(String phone);

    @Select("SELECT * FROM user_table WHERE phone = #{phone} AND password = #{password}")
    User login(@Param("phone") String phone, @Param("password") String password);

    @Insert("INSERT INTO user_table VALUES (null, #{realName}, #{phone}, #{password}, #{type}, now(), now())")
    int insertUser(@Param("realName") String realName,
                   @Param("phone") String phone,
                   @Param("password") String password,
                   @Param("type") int type);

    @Select("SELECT position FROM position_table WHERE phone = #{phone}")
    List<String> getOwnPosition(String phone);
}
