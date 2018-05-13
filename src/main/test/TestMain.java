
import com.bsb.util.TimeUtil;

import java.text.SimpleDateFormat;

public class TestMain {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(simpleDateFormat.format(date));

//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date);
        System.out.println(TimeUtil.transToTime(1));
//        System.out.println(new Date("2018/5/13 12:00:00"));
    }


}
