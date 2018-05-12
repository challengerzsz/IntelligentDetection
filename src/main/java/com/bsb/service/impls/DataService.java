package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.dao.DataMapper;
import com.bsb.pojo.Data;
import com.bsb.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements IDataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public ServerResponse<Data> getNowData(String now) {
        Data data = dataMapper.getNowData(now);
        if (data == null) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        //从数据库中获取出来的数据进行分析
        data.calculateStatus();
        return ServerResponse.createBySuccess("查询成功", data);
    }

    @Override
    public ServerResponse<List<Data>> getDataBetweenTime(String position, String startTime, String endTime) {


        System.out.println("service" + position + " " + startTime + " " + endTime);
        List<Data> datas = dataMapper.getDataBetweenTime(position, startTime, endTime);
        if (datas == null) {
            return ServerResponse.createByErrorMsg("查询记录失败");
        }

        for (Data data : datas) {
            data.calculateStatus();
        }

        return ServerResponse.createBySuccess("查询成功", datas);
    }
}
