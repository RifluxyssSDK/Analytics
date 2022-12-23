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
    private String usedId;
    private String expiryDate;

    public Schema(String usedId) {
        this.usedId = usedId;
        setExpiryDate(Util.getDate(Instance.getLogExpireDayCount()));
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
