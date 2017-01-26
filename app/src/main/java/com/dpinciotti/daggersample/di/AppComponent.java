package com.dpinciotti.daggersample.di;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.scope.ApplicationScope;
import com.dpinciotti.daggersample.MyApplication;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppScopeActivityBinder.class})
public interface AppComponent extends PlainComponent<MyApplication> {

}