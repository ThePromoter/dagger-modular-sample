package com.dpinciotti.daggersample.di.binder;

import com.dpinciotti.core.ui.di.BaseActivityBinder;

import dagger.Module;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

@Module(includes = {
    BaseActivityBinder.class,
    MainActivityBinder.class
})
public abstract class ActivityBinders {}