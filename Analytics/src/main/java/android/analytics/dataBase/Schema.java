package android.analytics.dataBase;

import android.analytics.Util;
import android.analytics.kernel.Instance;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@SuppressWarnings({"unused", "UnusedReturnValue", "HardwareIds"})
@Entity(tableName = "person")
public class Schema {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "UserId")
    private String usedId;

    @ColumnInfo(name = "HostId")
    private String hostId;

    @ColumnInfo(name = "RouteNbr")
    private Double routeNbr;

    @ColumnInfo(name = "Logger")
    private String logger;

    @ColumnInfo(name = "EventNbr")
    private String eventNbr;

    @ColumnInfo(name = "AddtlDesc")
    private String addtlDesc;

    @ColumnInfo(name = "AddtlNbr")
    private String addtlNbr;

    @ColumnInfo(name = "DeviceID")
    private String deviceId = Settings.Secure.getString(Instance.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    @ColumnInfo(name = "Log ExpiryDate")
    private String expiryDate = Util.getDate(Instance.getLogExpireDayCount());


    public Schema(String usedId, String hostId, Double routeNbr, String logger, String eventNbr, String addtlDesc, String addtlNbr) {
        this.usedId = usedId;
        this.hostId = hostId;
        this.routeNbr = routeNbr;
        this.logger = logger;
        this.eventNbr = eventNbr;
        this.addtlDesc = addtlDesc;
        this.addtlNbr = addtlNbr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsedId() {
        return usedId;
    }

    public void setUsedId(String usedId) {
        this.usedId = usedId;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public Double getRouteNbr() {
        return routeNbr;
    }

    public void setRouteNbr(Double routeNbr) {
        this.routeNbr = routeNbr;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getEventNbr() {
        return eventNbr;
    }

    public void setEventNbr(String eventNbr) {
        this.eventNbr = eventNbr;
    }

    public String getAddtlDesc() {
        return addtlDesc;
    }

    public void setAddtlDesc(String addtlDesc) {
        this.addtlDesc = addtlDesc;
    }

    public String getAddtlNbr() {
        return addtlNbr;
    }

    public void setAddtlNbr(String addtlNbr) {
        this.addtlNbr = addtlNbr;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
