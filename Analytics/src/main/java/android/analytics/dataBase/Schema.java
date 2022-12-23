package android.analytics.dataBase;

import android.analytics.Util;
import android.analytics.kernel.Instance;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * The type Schema.
 */
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


    /**
     * Instantiates a new Schema.
     *
     * @param usedId    the used id
     * @param hostId    the host id
     * @param routeNbr  the route nbr
     * @param logger    the logger
     * @param eventNbr  the event nbr
     * @param addtlDesc the addtl desc
     * @param addtlNbr  the addtl nbr
     */
    public Schema(String usedId, String hostId, Double routeNbr, String logger, String eventNbr, String addtlDesc, String addtlNbr) {
        this.usedId = usedId;
        this.hostId = hostId;
        this.routeNbr = routeNbr;
        this.logger = logger;
        this.eventNbr = eventNbr;
        this.addtlDesc = addtlDesc;
        this.addtlNbr = addtlNbr;
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
     * Gets used id.
     *
     * @return the used id
     */
    public String getUsedId() {
        return usedId;
    }

    /**
     * Sets used id.
     *
     * @param usedId the used id
     */
    public void setUsedId(String usedId) {
        this.usedId = usedId;
    }

    /**
     * Gets host id.
     *
     * @return the host id
     */
    public String getHostId() {
        return hostId;
    }

    /**
     * Sets host id.
     *
     * @param hostId the host id
     */
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    /**
     * Gets route nbr.
     *
     * @return the route nbr
     */
    public Double getRouteNbr() {
        return routeNbr;
    }

    /**
     * Sets route nbr.
     *
     * @param routeNbr the route nbr
     */
    public void setRouteNbr(Double routeNbr) {
        this.routeNbr = routeNbr;
    }

    /**
     * Gets logger.
     *
     * @return the logger
     */
    public String getLogger() {
        return logger;
    }

    /**
     * Sets logger.
     *
     * @param logger the logger
     */
    public void setLogger(String logger) {
        this.logger = logger;
    }

    /**
     * Gets event nbr.
     *
     * @return the event nbr
     */
    public String getEventNbr() {
        return eventNbr;
    }

    /**
     * Sets event nbr.
     *
     * @param eventNbr the event nbr
     */
    public void setEventNbr(String eventNbr) {
        this.eventNbr = eventNbr;
    }

    /**
     * Gets addtl desc.
     *
     * @return the addtl desc
     */
    public String getAddtlDesc() {
        return addtlDesc;
    }

    /**
     * Sets addtl desc.
     *
     * @param addtlDesc the addtl desc
     */
    public void setAddtlDesc(String addtlDesc) {
        this.addtlDesc = addtlDesc;
    }

    /**
     * Gets addtl nbr.
     *
     * @return the addtl nbr
     */
    public String getAddtlNbr() {
        return addtlNbr;
    }

    /**
     * Sets addtl nbr.
     *
     * @param addtlNbr the addtl nbr
     */
    public void setAddtlNbr(String addtlNbr) {
        this.addtlNbr = addtlNbr;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     *
     * @param deviceId the device id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets expiry date.
     *
     * @return the expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets expiry date.
     *
     * @param expiryDate the expiry date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
