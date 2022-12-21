package android.analytics.dataBase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Schema schema);

    @Update
    void update(Schema schema);

    @Delete
    void delete(Schema schema);

    @Query("DELETE FROM `person`")
    void deleteAllScheme();

    @Query("SELECT * FROM `person`")
    List<Schema> getAllScheme();
}
