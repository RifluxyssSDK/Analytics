package com.rifluxyss.app.analyticstracking.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.TypeConverters;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.R;
import com.rifluxyss.app.analyticstracking.converters.DateTimeConverter;
import com.rifluxyss.app.analyticstracking.converters.NumberConverters;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

/**
 * Initialize the Database of the AnalyticsDatabase
 * Initialize the TypeConverters of the DateTime && Number store the Database
 */
@Database(entities = {AnalyticsLog.class},version = 5, exportSchema = false)
@TypeConverters({DateTimeConverter.class, NumberConverters.class})
public abstract class AnalyticsDatabase extends MainDatabase {

    /**
     * Initialization of String variable of databaseName
     */
    protected static String databaseName =  AppManagerSingleton.getInstance().getContext().getString(R.string.str_database);

    /**
     * @param context of the Context class
     * @return the AnalyticsDatabase Class
     */
    @NonNull
    public static synchronized AnalyticsDatabase build(final Context context) {

        return Room.databaseBuilder(context, AnalyticsDatabase.class, databaseName).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }
}
