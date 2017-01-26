package com.dpinciotti.daggersample.di.binder;

import com.dpinciotti.core.di.fragment.FragmentComponentBuilder;
import com.dpinciotti.core.di.fragment.FragmentKey;
import com.dpinciotti.daggersample.Fragment1;
import com.dpinciotti.daggersample.di.component.Fragment1Component;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

@Module(subcomponents = {Fragment1Component.class})
public abstract class Fragment1Binder {

    @Binds @IntoMap @FragmentKey(Fragment1.class)
    abstract FragmentComponentBuilder componentBuilder(Fragment1Component.Builder builder);
}
