package com.dpinciotti.daggersample.di;

import com.dpinciotti.core.di.activity.ActivityComponentBuilder;
import com.dpinciotti.core.di.activity.ActivityKey;
import com.dpinciotti.daggersample.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class})
abstract class AppScopeActivityBinder {

    @Binds @IntoMap @ActivityKey(MainActivity.class)
    abstract ActivityComponentBuilder componentBuilder(MainActivityComponent.Builder impl);
}