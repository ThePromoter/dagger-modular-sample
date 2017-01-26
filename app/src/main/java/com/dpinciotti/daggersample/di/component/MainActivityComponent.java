package com.dpinciotti.daggersample.di.component;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.activity.ActivityComponentBuilder;
import com.dpinciotti.core.di.scope.ActivityScope;
import com.dpinciotti.daggersample.MainActivity;
import com.dpinciotti.daggersample.di.binder.MainActivityFragmentBinders;
import com.dpinciotti.daggersample.di.module.MainActivityModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules= {
    MainActivityModule.class,
    MainActivityFragmentBinders.class
})
public interface MainActivityComponent extends PlainComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivity, MainActivityComponent> {
        Builder activityModule(MainActivityModule module);
    }
}