package com.rifluxyss.app.analyticstracking.common;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.util.function.Supplier;

@SuppressLint("NewApi")
public class Lazy<T> implements Supplier
{
    private final Supplier<T> supplier;
    //May be used to identify this instance
    private volatile T value;

    private Lazy(@NonNull Supplier<T> supplier)
    {
        this.supplier = supplier;
    }

    public static <T> Lazy create(@NonNull Supplier<T> supplier) {
        return created(supplier);
    }

    public static <T> Lazy created(@NonNull Supplier<T> supplier) {
        return new Lazy<>(supplier);
    }

    @Override
    public T get() {

        //make sure it is thread safe with double-checked locking
        T localRef = value;
        if (localRef == null)
        {
            synchronized (this)
            {
                localRef = value;
                if (localRef == null)
                {
                    localRef = value = supplier.get();
                }
            }
        }
        return localRef;
    }

}
