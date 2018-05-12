package com.bsb.controller;


import com.bsb.common.ServerResponse;
import com.bsb.pojo.Data;
import com.bsb.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data/")
public class DataController {

    @Autowired
    private IDataService dataService;

    @RequestMapping(value = "get_now_data.do", method = RequestMethod.POST)
    public ServerResponse<Data> getNowData(String now) {
        ServerResponse<Data> response = dataService.getNowData(now);
        return response;
    }
}
