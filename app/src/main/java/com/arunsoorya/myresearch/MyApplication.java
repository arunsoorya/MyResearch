package com.arunsoorya.myresearch;

import android.app.Application;

import com.arunsoorya.myresearch.dagger.DaggerDiComponent;
import com.arunsoorya.myresearch.dagger.DiComponent;

/**
 * Created by T10778 on 03/02/2016.
 */
public class MyApplication extends Application {
//    private DiComponent component;
private DiComponent objectGraph;
    @Override
    public void onCreate() {
        super.onCreate();
//        CrashLogger crashLogger = CrashLogger.getInstance(this);
//        crashLogger.initCrashLogger();
        
//        component = DaggerDiComponent.builder().build();
    }

    public DiComponent getComponent() {
        return objectGraph;
    }

    public void initComponent(){
        objectGraph = DaggerDiComponent.builder().build();
    }
}
