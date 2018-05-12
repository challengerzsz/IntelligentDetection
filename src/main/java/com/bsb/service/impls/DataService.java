package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.dao.DataMapper;
import com.bsb.pojo.Data;
import com.bsb.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        data.calculateStatus();
        return ServerResponse.createBySuccess("查询成功", data);
    }
}
