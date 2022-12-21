package android.analytics.dataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Schema {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Date")
    private String date;
    @ColumnInfo(name = "Device ID")
    private String deviceID;

    public Schema(String date, String deviceID) {
        this.date = date;
        this.deviceID = deviceID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
}
