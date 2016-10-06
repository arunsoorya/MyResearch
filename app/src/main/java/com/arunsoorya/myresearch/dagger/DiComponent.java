package com.arunsoorya.myresearch.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by t10778 on 26/06/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface DiComponent {
    void inject(DaggerActivity daggerActivity);
}
