package android.analytics.dataBase;

import android.analytics.Kernel.Instance;
import android.annotation.SuppressLint;
import android.provider.Settings;
import android.text.format.DateFormat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings({"unused", "UnusedReturnValue"})
@Entity(tableName = "person")
public class Schema {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Key")
    private String key;
    @ColumnInfo(name = "Data")
    private String data;
    @ColumnInfo(name = "Time")
    private String time;
    @ColumnInfo(name = "Date")
    private String date;
    @ColumnInfo(name = "Device ID")
    private String deviceID;

    public Schema(String key, String data) {
        this.key = key;
        this.data = data;
        setDate();
        setTime();
        setDeviceID();
    }

    private void setTime() {
        String time = (String) DateFormat.format("hh:mm:ss aaa", Calendar.getInstance().getTime());
        setTime(time);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceID() {
        return deviceID;
    }

    @SuppressLint("HardwareIds")
    public void setDeviceID() {
        setDeviceID(Settings.Secure.getString(Instance.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID));
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setDate(simpleDateFormat.format(date));
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
