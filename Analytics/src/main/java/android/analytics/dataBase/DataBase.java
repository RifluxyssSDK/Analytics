package android.analytics.dataBase;

import android.analytics.Utils;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Model.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase dataBase;

    public static synchronized DataBase getInstance() {

        if (dataBase == null) {

            dataBase = Room.databaseBuilder(Utils.getUtils().getContext(), DataBase.class, "SCHEMA")
                    .allowMainThreadQueries().build();

        }

        return dataBase;
    }
}
