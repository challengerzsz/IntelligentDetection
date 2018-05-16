package com.bsb.util;

import com.bsb.pojo.AnalysisData;

import java.util.ArrayList;
import java.util.List;

public class AnalysisUtil {

    public static List<AnalysisData> analysisData(List<AnalysisData> data) {
//        只需要20条记录
        long offset = data.size() / 20;

//        不够20条记录 offset = 1
        if (offset == 0) offset = 1;


        List<AnalysisData> resultDatas = new ArrayList<>();


        for (int i = 0; i < data.size(); i += offset) {
            System.out.println(i);
            resultDatas.add(data.get(i));
        }

        return resultDatas;
    }
}
