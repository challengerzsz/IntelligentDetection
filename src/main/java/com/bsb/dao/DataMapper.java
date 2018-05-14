package com.bsb.dao;

import com.bsb.pojo.AnalysisData;
import com.bsb.pojo.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {
    @Select("SELECT * FROM ${position} where timestamp = #{now}")
    Data getNowData(@Param("position") String position, @Param("now") String now);

    @Select("SELECT * FROM ${position} WHERE timestamp BETWEEN #{startTime} AND #{endTime}")
    List<Data> getDataBetweenTime(@Param("position") String position,
                                  @Param("startTime") String startTime,
                                  @Param("endTime") String endTime);

    @Select("SELECT ${target} FROM ${position} WHERE timestamp BETWEEN #{currentTime} AND #{endTime} ORDER BY timestamp ASC")
    List<Double> getDatas(@Param("position") String position,
                          @Param("target") String target,
                          @Param("currentTime") String currentTime,
                          @Param("endTime") String endTime);

    @Select("SELECT timestamp FROM nationalaqi WHERE timestamp BETWEEN #{currentTime} AND #{endTime} ORDER BY timestamp ASC")
    List<String> getTimes(@Param("currentTime") String currentTime, @Param("endTime") String endTime);

    @Select("SELECT * FROM ((SELECT ${target} AS nationaltarget FROM nationalaqi WHERE timestamp BETWEEN #{currentTime} AND #{endTime}) nationaldata, (SELECT ${target} AS positiontarget, timestamp FROM ${position} WHERE timestamp BETWEEN #{currentTime} AND #{endTime}) positiondata)")
    List<AnalysisData> getAnalysisDatas(@Param("position") String position,
                                        @Param("target") String target,
                                        @Param("currentTime") String currentTime,
                                        @Param("endTime") String endTime);
}
