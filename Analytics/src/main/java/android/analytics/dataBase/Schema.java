package android.analytics.dataBase;

import android.analytics.Kernel.Instance;
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
    private final String key;
    @ColumnInfo(name = "Create Date")
    private String createDate;
    @ColumnInfo(name = "Expiry Date")
    private String expiryDate;
    @ColumnInfo(name = "Create Time")
    private String createTime;
    @ColumnInfo(name = "Data")
    private final String data;

    /**
     * Instantiates a new Schema.
     *
     * @param key  the key
     * @param data the data
     */
    public Schema(String key, String data) {
        this.key = key;
        this.data = data;
        setCreateTime();
        setCreateDate();
        setExpiryDate();
    }

    private void setCreateTime() {
        setCreateTime((String) DateFormat.format("hh:mm aaa",Calendar.getInstance().getTime()));
    }

    private void setExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, Instance.getInstance().getLogExpireDayCount());
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setExpiryDate(simpleDateFormat.format(date));
    }

    /**
     * Sets create date.
     */
    public void setCreateDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setCreateDate(simpleDateFormat.format(date));
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
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets create date.
     *
     * @param createDate the create date
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    /**
     * Gets create time.
     *
     * @return the create time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets create time.
     *
     * @param createTime the create time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }
}
