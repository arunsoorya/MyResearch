package com.arunsoorya.myresearch.dagger;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by t10778 on 26/06/2016.
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    SharedPreferences getSharedPreference( Application mApplication){
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }


}
