package com.dpinciotti.daggersample.di.binder;

import com.dpinciotti.core.di.activity.ActivityComponentBuilder;
import com.dpinciotti.core.di.activity.ActivityKey;
import com.dpinciotti.daggersample.MainActivity;
import com.dpinciotti.daggersample.di.component.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class})
public abstract class MainActivityBinder {

    @Binds @IntoMap @ActivityKey(MainActivity.class)
    abstract ActivityComponentBuilder componentBuilder(MainActivityComponent.Builder builder);
}