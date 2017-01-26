package com.dpinciotti.daggersample.di.component;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.fragment.FragmentComponentBuilder;
import com.dpinciotti.core.di.scope.FragmentScope;
import com.dpinciotti.daggersample.Fragment1;
import com.dpinciotti.daggersample.di.module.Fragment1Module;

import dagger.Subcomponent;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

@FragmentScope
@Subcomponent(modules = {
    Fragment1Module.class
})
public interface Fragment1Component extends PlainComponent<Fragment1> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<Fragment1, Fragment1Component> {
        Builder fragmentModule(Fragment1Module module);
    }
}
