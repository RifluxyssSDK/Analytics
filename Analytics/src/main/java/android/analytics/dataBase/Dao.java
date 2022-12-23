package android.analytics.dataBase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/**
 * The interface Dao.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
@androidx.room.Dao
public interface Dao {

    /**
     * Insert.
     *
     * @param schema the schema
     */
    @Insert
    void insert(Schema schema);

    /**
     * Delete.
     *
     * @param schema the schema
     */
    @Delete
    void delete(Schema schema);

    /**
     * Delete all scheme.
     */
    @Query("DELETE FROM `person`")
    void deleteAllScheme();

    /**
     * Gets all scheme.
     *
     * @return the all scheme
     */
    @Query("SELECT * FROM `person`")
    List<Schema> getAllScheme();
}
