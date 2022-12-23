package android.analytics.dataBase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Schema schema);

    @Delete
    void delete(Schema schema);

    @Query("DELETE FROM `person`")
    void deleteAllScheme();

    @Query("SELECT * FROM `person`")
    List<Schema> getAllScheme();
}
