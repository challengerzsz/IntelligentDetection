package com.bsb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String transToTime(int type) {
//        long currentTime = System.currentTimeMillis();
        long endTime = 0;
        long currentTime = new Date("2017/06/06 00:00:00").getTime();

//        转换系统当前时间为String
//        String currentTimeStr = simpleDateFormat.format(new Date(currentTime));
        switch (type) {
            case 0:
                endTime = currentTime + 24L * 60 * 60 * 1000;
                break;
            case 1:
                endTime = currentTime + 7L * 24 * 60 * 60 * 1000;
                break;
            case 2:
                endTime = currentTime + 30L * 24 * 60 * 60 * 1000;
                break;
        }

        String endTimeStr = simpleDateFormat.format(new Date(endTime));

//        System.out.println(currentTime + " " + endTime);

//        System.out.println(new Date(currentTime) + " " + new Date(endTime));

//        return currentTimeStr + "," + endTimeStr;
        return "2017-06-06 00:00:00" + "," + endTimeStr;
    }
}
