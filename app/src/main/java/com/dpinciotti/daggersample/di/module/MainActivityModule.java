package com.dpinciotti.daggersample.di.module;

import android.app.Activity;

import com.dpinciotti.core.di.activity.ActivityBaseModule;

import dagger.Module;

@Module(includes = {LifecycleDelegateModule.class})
public class MainActivityModule extends ActivityBaseModule {

    public MainActivityModule(Activity activity) {
        super(activity);
    }
}