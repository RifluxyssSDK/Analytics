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

/**
 * The type Schema.
 */
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

    /**
     * Instantiates a new Schema.
     *
     * @param key  the key
     * @param data the data
     */
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

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Sets device id.
     */
    @SuppressLint("HardwareIds")
    public void setDeviceID() {
        setDeviceID(Settings.Secure.getString(Instance.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID));
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     */
    public void setDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setDate(simpleDateFormat.format(date));
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Sets device id.
     *
     * @param deviceID the device id
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(String key) {
        this.key = key;
    }
}
