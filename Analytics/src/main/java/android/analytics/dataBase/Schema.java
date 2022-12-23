package android.analytics.dataBase;

import android.analytics.Util;
import android.analytics.kernel.Instance;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public Schema(String key, String data) {
        this.key = key;
        this.data = data;
        setCreateTime(Util.getTime());
        setCreateDate(Util.getDate(0));
        setExpiryDate(Util.getDate(Instance.getLogExpireDayCount()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getData() {
        return data;
    }
}
