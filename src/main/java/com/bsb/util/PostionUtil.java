package com.bsb.util;

public class PostionUtil {

    public static final String NATIONAL_POSITION = "国控点";

    public static final String BLUE_POSITION = "蓝居";

    public static final String AROUND_POSITION = "环科院";


    public static String transformPosition(String position) {
        String result = null;

        switch (position) {
            case NATIONAL_POSITION:
                result = "nationalaqi";
                break;
            case BLUE_POSITION:
                result = "blueaqi";
                break;
            case AROUND_POSITION:
                result = "aroundaqi";
                break;
        }

        return result;
    }
}
