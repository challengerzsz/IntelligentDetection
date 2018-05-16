package com.bsb.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class NetUtil {

    public static String get(String url) {
        return post(url, null);
    }

    public static String post(String url, Map param) {
        HttpURLConnection connection = null;
        try {
            URL u = new URL(url);
            connection = (HttpURLConnection) u.openConnection();
            StringBuffer stringBuffer = null;

            if (param != null) {
                stringBuffer = new StringBuffer();

                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestMethod("POST");

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));

                Iterator iterator = param.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    stringBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }

                writer.write(stringBuffer.deleteCharAt(stringBuffer.toString().length() - 1).toString());

                writer.close();
                stringBuffer = null;
            }

            connection.connect();
            stringBuffer = new StringBuffer();

            int resultCode = connection.getResponseCode();


            BufferedReader reader = null;

            if (resultCode == 200) {

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String str = null;
                stringBuffer = new StringBuffer();

                while ((str = reader.readLine()) != null) {
                    stringBuffer.append(str).append(System.getProperty("line.separator"));
                }

                reader.close();
                if (stringBuffer.toString().length() == 0) {
                    return null;
                }

                return stringBuffer.toString().substring(0, stringBuffer.toString().length() - System.getProperty("line.separator").length());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
