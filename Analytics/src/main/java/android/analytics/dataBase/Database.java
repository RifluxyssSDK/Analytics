package android.analytics.dataBase;

import android.analytics.Kernel.Instance;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Schema.class},exportSchema = false, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database database;

    public static synchronized Database getInstance() {

        if (database == null) {
            database = Room.databaseBuilder(Instance.getInstance().getContext(), Database.class, "course_database").allowMainThreadQueries().build();
        }

        return database;
    }

    public abstract Dao dao();
}
