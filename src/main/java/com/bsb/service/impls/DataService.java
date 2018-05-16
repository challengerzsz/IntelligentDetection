package com.bsb.service.impls;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.dao.DataMapper;
import com.bsb.pojo.AnalysisData;
import com.bsb.pojo.ComparedData;
import com.bsb.pojo.Data;
import com.bsb.service.IDataService;
import com.bsb.util.AnalysisUtil;
import com.bsb.util.PostionUtil;
import com.bsb.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements IDataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public ServerResponse<Data> getNowData(String position) {

//        对传入的position进行处理
        String resultPosition = PostionUtil.transformPosition(position);
        if (resultPosition == null) {
            return ServerResponse.createByErrorMsg("监测地点不存在");
        }
        System.out.println("transform position is "  +  resultPosition);

//        写死测试数据
        Data data = dataMapper.getNowData(resultPosition, "2017-06-06 12:00:00");
        if (data == null) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        data.calculateStatus();
        return ServerResponse.createBySuccess("查询成功", data);
    }

    /**
     * 根据所选观测点 以及所选查询数据返回时间间的数据
     * @param position
     * @param target
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public ServerResponse<List<AnalysisData>> getDataBetweenTime(String position, String target, String startTime, String endTime) {

        //        对传入的position进行处理
//        String resultPosition = PostionUtil.transformPosition(position);
//        if (resultPosition == null) {
//            return ServerResponse.createByErrorMsg("监测地点不存在");
//        }
//
//        List<Data> datas = dataMapper.getDataBetweenTime(resultPosition, startTime, endTime);
//
//        if (datas == null) {
//            return ServerResponse.createByErrorMsg("查询记录失败");
//        }
////        计算空气质量aqi
//        for (Data data : datas) {
//            data.calculateStatus();
//        }
//
//        return ServerResponse.createBySuccess("查询成功", datas);


        //        对传入的position进行处理
        String resultPosition = PostionUtil.transformPosition(position);
        if (resultPosition == null) {
            return ServerResponse.createByErrorMsg("监测地点不存在");
        }

        List<AnalysisData> analysisDatas = dataMapper.getAnalysisDatas(resultPosition, target, startTime, endTime);
        if (analysisDatas == null) {
            return ServerResponse.createByErrorMsg("查询失败，无数据存在");
        }

        List<AnalysisData> responseDatas = AnalysisUtil.analysisData(analysisDatas);

        return ServerResponse.createBySuccess("查询成功", responseDatas);


    }


    @Override
    public ServerResponse<ComparedData> getComparedData(String position, int type, String target) {

        //        对传入的position进行处理
        String resultPosition = PostionUtil.transformPosition(position);
        if (resultPosition == null) {
            return ServerResponse.createByErrorMsg("监测地点不存在");
        }

        String translatedTime = TimeUtil.transToTime(type);
        String[] times = translatedTime.split(",");
        String currentTime = times[0];
        String endTime = times[1];


//        取出指定监测站的时间段内数据
        List<Double> positionDatas = dataMapper.getDatas(resultPosition, target, currentTime, endTime);
//        取出国控点时间段数据
        List<Double> nationalDatas = dataMapper.getDatas(Const.NATIONAL_AQI, target, currentTime, endTime);
//        取出时间段内测量的时间点
        List<String> queryTimes = dataMapper.getTimes(currentTime, endTime);

        if (positionDatas == null || nationalDatas == null) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        ComparedData datas = new ComparedData();
        datas.setTarget(target);
        datas.setPositionData(positionDatas);
        datas.setNationalData(nationalDatas);
        datas.setTestTime(queryTimes);

        return ServerResponse.createBySuccess("查询成功", datas);
    }

    public ServerResponse<List<AnalysisData>> getAnalysisDatas(String position, int type, String target) {
        String translatedTime = TimeUtil.transToTime(type);
        String[] times = translatedTime.split(",");
        String currentTime = times[0];
        String endTime = times[1];

        //        对传入的position进行处理
        String resultPosition = PostionUtil.transformPosition(position);
        if (resultPosition == null) {
            return ServerResponse.createByErrorMsg("监测地点不存在");
        }

        List<AnalysisData> analysisDatas = dataMapper.getAnalysisDatas(resultPosition, target, currentTime, endTime);
        if (analysisDatas == null) {
            return ServerResponse.createByErrorMsg("查询失败，无数据存在");
        }

        List<AnalysisData> responseDatas = AnalysisUtil.analysisData(analysisDatas);

        return ServerResponse.createBySuccess("查询成功", responseDatas);
    }

}
