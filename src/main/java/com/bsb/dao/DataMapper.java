package com.bsb.dao;

import com.bsb.pojo.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {
    @Select("SELECT * FROM ${position} where timestamp = #{now}")
    Data getNowData(@Param("position") String position, @Param("now") String now);

    @Select("SELECT * FROM ${position} WHERE timestamp BETWEEN #{startTime} AND #{endTime}")
    List<Data> getDataBetweenTime(@Param("position") String position,
                                  @Param("startTime") String startTime,
                                  @Param("endTime") String endTime);

    @Select("SELECT ${target} FROM ${position} WHERE timestamp between #{currentTime} and #{endTime} order by timestamp asc")
    List<Double> getDatas(@Param("position") String position,
                          @Param("target") String target,
                          @Param("currentTime") String currentTime,
                          @Param("endTime") String endTime);

    @Select("SELECT timestamp FROM nationalaqi WHERE timestamp between #{currentTime} and #{endTime} order by timestamp asc")
    List<String> getTimes(@Param("currentTime") String currentTime, @Param("endTime") String endTime);
}
