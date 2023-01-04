package com.rifluxyss.app.analyticstracking;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.rifluxyss.app.analyticstracking.converters.DateTimeConverter;
import com.rifluxyss.app.analyticstracking.converters.NumberConverters;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

@Database(entities = {AnalyticsLog.class},version = 5, exportSchema = false)
@TypeConverters({DateTimeConverter.class, NumberConverters.class})
public abstract class AnalyticsDatabase extends MainDatabase {

    public static synchronized AnalyticsDatabase build(final Context context) {

        Migration mMigration =new Migration(5,6) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `AnalyticsLog` (`HostId` TEXT NOT NULL, PRIMARY KEY(`key_id`))");
            }
        };

        return Room.databaseBuilder(context, AnalyticsDatabase.class, "analytics-data.db").allowMainThreadQueries()
                .fallbackToDestructiveMigration().addMigrations(mMigration).build();
    }
}
