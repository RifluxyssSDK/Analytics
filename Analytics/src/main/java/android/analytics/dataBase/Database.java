package android.analytics.dataBase;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Schema.class},exportSchema = false, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract Dao dao();
    private static Database database;

    public static synchronized Database getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, Database.class, "Database").allowMainThreadQueries().build();
        }
        return database;
    }
}
