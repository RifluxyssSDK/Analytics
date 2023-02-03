package com.rifluxyss.app.analyticstracking;

import android.content.Context;

import com.rifluxyss.app.analyticstracking.database.AnalyticsDatabase;


/**
 * The type Instance Context.
 * <p>
 * The class <code>Instance of Context</code> and its subclasses are a form of context.
 */
public class AppManagerSingleton {

    /**
     * Initialization of mAppManagerSingletonInstance
     */
    protected static AppManagerSingleton mAppManagerSingletonInstance;

    /**
     * Initialization of Context
     */
    protected Context context;

    /**
     * Initialization of AnalyticsDatabase
     */
    protected AnalyticsDatabase mAnalyticsDatabase;

    /**
     * @return AppManagerSingleton Object
     *
     * If class can be null initialization of object creation in this method
     * Synchronized of explicitly describes dependencies between different asynchronous operations in the Android graphics system.
     */
    public synchronized static AppManagerSingleton getInstance() {

        if (mAppManagerSingletonInstance == null) {

            mAppManagerSingletonInstance = new AppManagerSingleton();

        }

        return mAppManagerSingletonInstance;
    }


    /**
     * @param context of access of Parent Context
     *                This method uses creating context and analyticalDatabase class objects.
     */
    public void initialize(Context context) {
        this.context = context;
        mAnalyticsDatabase = AnalyticsDatabase.build(context);
    }


    /**
     * @return Context of the class
     */
    public Context getContext() {
        return context;
    }

    /**
     * @return Analytics Database on the class object
     */
    public AnalyticsDatabase localDatabase() {
        return getInstance().mAnalyticsDatabase;
    }

}
