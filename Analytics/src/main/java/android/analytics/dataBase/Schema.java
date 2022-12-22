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

    public void setCreateDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setCreateDate(simpleDateFormat.format(date));
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
