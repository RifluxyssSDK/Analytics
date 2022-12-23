package com.rifluxyss.app.analyticstracking;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.TypeConverters;

import com.rifluxyss.app.analyticstracking.converters.DateTimeConverter;
import com.rifluxyss.app.analyticstracking.converters.NumberConverters;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

@Database(entities = {AnalyticsLog.class},version = 3, exportSchema = false)
@TypeConverters({DateTimeConverter.class, NumberConverters.class})
public abstract class AnalyticsDatabase extends MainDatabase {

    public static AnalyticsDatabase build(final Context context) {

        return Room.databaseBuilder(context, AnalyticsDatabase.class, "analytics-data.db").allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .fallbackToDestructiveMigrationOnDowngrade()
                .fallbackToDestructiveMigrationFrom(1,2,3,4).build();

    }
}
