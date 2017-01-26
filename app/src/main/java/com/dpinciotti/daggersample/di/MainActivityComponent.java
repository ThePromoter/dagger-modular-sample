package com.dpinciotti.daggersample.di;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.activity.ActivityComponentBuilder;
import com.dpinciotti.core.di.scope.ActivityScope;
import com.dpinciotti.daggersample.MainActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules= {MainActivityModule.class})
public interface MainActivityComponent extends PlainComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivity, MainActivityComponent> {
        Builder activityModule(MainActivityModule module);
    }
}