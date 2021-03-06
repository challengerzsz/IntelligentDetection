package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.AnalysisData;
import com.bsb.pojo.ComparedData;
import com.bsb.pojo.Data;

import java.util.List;

public interface IDataService {
    ServerResponse<Data> getNowData(String now);

    ServerResponse<List<AnalysisData>> getDataBetweenTime(String position, String target, String startTime, String endTime);

    ServerResponse<ComparedData> getComparedData(String position, int type, String target);

    ServerResponse<List<AnalysisData>> getAnalysisDatas(String position, int type, String target);
}
