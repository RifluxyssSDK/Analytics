package com.rifluxyss.app.analyticstracking;

import static android.content.Context.WIFI_SERVICE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressLint("NewApi")
public class Utils {

    public static String EMPTY = "";

    public static final long SECOND_SCALE = 1000;
    public static final long MINUTE_SCALE = 60 * SECOND_SCALE;
    public static final long HOUR_SCALE   = 60 * MINUTE_SCALE;
    public static final long DAY_SCALE    = 24 * HOUR_SCALE;


    public static LocalDateTime fromISODateTimeString(String value) {
        String valueDate = value != null ? value.trim() : EMPTY;
        return TextUtils.isEmpty(valueDate) ? LocalDateTime.MIN :  LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }


    public static String toISODateTimeString(LocalDateTime dateTime) {
        return dateTime == null ? EMPTY : dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String deviceModelCapitalized(String modelName) {
        return modelName.substring(0, 1).toUpperCase() + modelName.substring(1).toLowerCase();
    }

    public void create(Context mContext) throws IOException {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, HH:mm:ss a");
        AnalyticsData analyticsData = new AnalyticsData(LocalDateTime.now().format(sdf), LocalDateTime.now().getDayOfWeek().getValue());
        FileOutputStream fos = mContext.openFileOutput("jobSchedule.json", Context.MODE_PRIVATE);
        fos.write(new Gson().toJson(analyticsData).getBytes());
        fos.close();
    }

    public boolean isFilePresent(String fileName) {
        String path = new File(AppManager.getContext().getFilesDir().getAbsolutePath(),fileName).getAbsolutePath();
        File file = new File(path);
        return file.exists();
    }

    public boolean isDeleteFile(String fileName) {
        String path =  new File(AppManager.getContext().getFilesDir().getAbsolutePath(),fileName).getAbsolutePath();
        File file = new File(path);
        return file.delete();
    }

    public String getIPAddress() {

        WifiManager wifiMgr = (WifiManager)AppManager.getContext().getApplicationContext().getSystemService(WIFI_SERVICE);
        int ipAddress = wifiMgr.getConnectionInfo().getIpAddress();
        byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ipAddress).array();

        try {
           return InetAddress.getByAddress(buffer).getHostAddress();
        } catch (UnknownHostException ignore) {
        }

        return "";

    }

}
