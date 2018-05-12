package com.bsb.dao;

import com.bsb.pojo.Data;
import org.apache.ibatis.annotations.Select;

public interface DataMapper {
    @Select("SELECT * FROM nationalaqi where timestamp = #{now}")
    Data getNowData(String now);
}
