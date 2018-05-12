package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Data;

public interface IDataService {
    ServerResponse<Data> getNowData(String now);
}
