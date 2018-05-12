import com.bsb.pojo.Data;
import com.bsb.util.TimeUtil;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {

    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date("2018/9/1 24:00:10");
//        System.out.println(simpleDateFormat.format(date));


        TimeUtil.checkTimeFormat("2018-1-1 12:00:55");
    }

}
