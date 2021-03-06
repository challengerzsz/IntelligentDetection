package com.bsb.controller;


import com.bsb.common.ServerResponse;
import com.bsb.pojo.AnalysisData;
import com.bsb.pojo.ComparedData;
import com.bsb.pojo.Data;
import com.bsb.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/data/")
public class DataController {

    @Autowired
    private IDataService dataService;

    @RequestMapping(value = "get_now_data.do", method = RequestMethod.POST)
    public ServerResponse<Data> getNowData(String position) {
        ServerResponse<Data> response = dataService.getNowData(position);
        return response;
    }

    @RequestMapping(value = "get_data_between_time.do", method =  RequestMethod.POST)
    public ServerResponse<List<AnalysisData>> getDataBetweenTime(String position, String target, String startTime, String endTime){

        ServerResponse<List<AnalysisData>> response = dataService.getDataBetweenTime(position, target, startTime, endTime);
        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("查询失败");
        }
        return response;

    }

    @RequestMapping(value = "get_compared_data.do", method = RequestMethod.POST)
    public ServerResponse<ComparedData> getComparedData(String position, int type, String target) {
        ServerResponse<ComparedData> response = dataService.getComparedData(position, type, target);

        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        return response;
    }

    @RequestMapping(value = "get_analysis_data.do", method = RequestMethod.POST)
    public ServerResponse<List<AnalysisData>> getAnalysisData(String position, int type, String target) {
        ServerResponse<List<AnalysisData>> response = dataService.getAnalysisDatas(position, type, target);

        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        return response;
    }
}
