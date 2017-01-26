package com.dpinciotti.daggersample.di.binder;

import dagger.Module;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

@Module(includes = {
    Fragment1Binder.class
})
public abstract class MainActivityFragmentBinders {}