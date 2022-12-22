package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.util.function.Supplier;

@SuppressLint("NewApi")
public class Lazy<T> implements Supplier
{
    private final Supplier<T> supplier;
    private String tag;
    //May be used to identify this instance
    private volatile T value;

    private Lazy(@NonNull Supplier<T> supplier)
    {
        this.supplier = supplier;
    }

    public static <T> Lazy create(@NonNull Supplier<T> supplier)
    {
        return create(Utils.EMPTY, supplier);
    }

    public static <T> Lazy create(String tag, @NonNull Supplier<T> supplier) {

        Lazy<T> lazy = new Lazy<>(supplier);
        lazy.tag = tag;
        return lazy;
    }

    @Override
    public T get()
    {
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

    public String tag()
    {
        return tag;
    }
}
