package com.arunsoorya.myresearch.mvp;

import android.app.Fragment;
import android.os.Bundle;

import java.util.HashMap;

/**
 * Created by T10778 on 19/06/2016.
 */
public class StateMngFragment  extends Fragment{
    private HashMap<String, Object> mData = new HashMap<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Grants that the frag will be preserved
        setRetainInstance(true);
    }

    /**
     * Insert objects
     * @param key   reference TAG
     * @param obj   Object to save
     */
    public void put(String key, Object obj) {
        mData.put(key, obj);
    }

    /**
     * Insert obj using class name as TAG
     * @param object    obj to save
     */
    public void put(Object object) {
        put(object.getClass().getName(), object);
    }

    /**
     * Recover obj
     * @param key   reference TAG
     * @param <T>   Class
     * @return      Obj saved
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) mData.get(key);
    }
}
