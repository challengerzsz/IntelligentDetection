package com.bsb.util;

public class WeatherUtil {
    public static String excute(String cityName) {
        String url = "http://v.juhe.cn/weather/index?cityname=" + cityName + "&key=6a9df7df50ae1db69194a94159b622d4";
        return NetUtil.get(url);
    }

    public static String getWeatherByCity(String city) {
        String result = excute(city);
        return null;
    }
}
