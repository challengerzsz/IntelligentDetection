package com.bsb.dao;

import com.bsb.pojo.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {
    @Select("SELECT * FROM nationalaqi where timestamp = #{now}")
    Data getNowData(String now);

    @Select("SELECT * FROM ${position} WHERE timestamp BETWEEN #{startTime} AND #{endTime}")
    List<Data> getDataBetweenTime(@Param("position") String position,
                                  @Param("startTime") String startTime,
                                  @Param("endTime") String endTime);
}
