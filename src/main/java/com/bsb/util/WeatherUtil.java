package com.bsb.util;

import com.alibaba.fastjson.JSONObject;
import com.bsb.pojo.Weather;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class WeatherUtil {
    public static String excute(String cityName) {

        String url = "http://v.juhe.cn/weather/index?cityname=" + cityName + "&key=6a9df7df50ae1db69194a94159b622d4";
        System.out.println("url" + url);
        return NetUtil.get(url);
    }

    public static List<Weather> getWeatherByCity(String city) {
        String result = excute(city);
        System.out.println("请求过");
        System.out.println(result);
        if (result != null) {
            JSONObject obj = JSONObject.parseObject(result);
            /*获取返回状态码*/
            result = obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if (result != null && result.equals("200")) {

                List<Weather> weathers = new ArrayList<>();

//                包括所有的天气信息 今天和未来
                result = obj.getString("result");
                obj = JSONObject.parseObject(result);

//                选取key=future 未来天气值
                result = obj.getString("future");
                obj = JSONObject.parseObject(result);

//                遍历未来6天的天气情况 并取出值
                for (JSONObject.Entry entry : obj.entrySet()) {
                    Weather weather = new Weather();
//                    System.out.println(entry.getKey() + " " + entry.getValue());
                    JSONObject jsonObject = (JSONObject) entry.getValue();

                    try {
                        weather.setDay(new String(jsonObject.getString("date").getBytes("GBK"), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    weather.setTemperature(jsonObject.getString("temperature"));
                    weather.setWeather(jsonObject.getString("weather"));



                    weathers.add(weather);
                }

//                System.out.println("未来天气数量" + weathers.size());
//                for (Weather weather : weathers) {
//                    System.out.println(weather.getDay() + weather.getTemperature() + weather.getWeather());
//                }
                return weathers;

            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getWeatherByCity("北京"));
    }
}
