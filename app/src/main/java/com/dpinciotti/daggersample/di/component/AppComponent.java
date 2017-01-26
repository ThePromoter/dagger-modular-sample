package com.dpinciotti.daggersample.di.component;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.scope.ApplicationScope;
import com.dpinciotti.daggersample.MyApplication;
import com.dpinciotti.daggersample.di.binder.ActivityBinders;
import com.dpinciotti.daggersample.di.module.GlobalModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {
    ActivityBinders.class,
    GlobalModule.class
})
public interface AppComponent extends PlainComponent<MyApplication> {

}