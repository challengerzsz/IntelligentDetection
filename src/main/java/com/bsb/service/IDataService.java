package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Data;

import java.util.List;

public interface IDataService {
    ServerResponse<Data> getNowData(String now);

    ServerResponse<List<Data>> getDataBetweenTime(String position, String startTime, String endTime);
}
