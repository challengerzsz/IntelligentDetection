
import com.bsb.util.MD5Util;
import com.bsb.util.TimeUtil;
import com.bsb.util.WeatherUtil;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;

public class TestMain {

    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(simpleDateFormat.format(date));

//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date);
//        System.out.println(TimeUtil.transToTime(1));
//        System.out.println(new Date("2018/5/13 12:00:00"));

//        System.out.println(MD5Util.MD5EncodeUtf8("GOVERNMENT_AUTHORIZATION_CODE"));
        System.out.println(URLEncoder.encode("北京"));
        System.out.println(URLEncoder.encode("北京"));

        WeatherUtil.getWeatherByCity("北京");
    }



}
