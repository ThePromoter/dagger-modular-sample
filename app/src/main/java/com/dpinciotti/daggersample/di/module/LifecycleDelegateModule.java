package com.dpinciotti.daggersample.di.module;

import com.dpinciotti.core.di.activity.ActivityName;
import com.dpinciotti.core.di.scope.ActivityScope;
import com.dpinciotti.core.ui.base.activity.ActivityLifecycleDelegate;
import com.dpinciotti.daggersample.AlternateActivityLifecycleDelegate;

import dagger.Module;
import dagger.Provides;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

@Module
public class LifecycleDelegateModule {

    @Provides @ActivityScope
    public ActivityLifecycleDelegate provideActivityLifecycleDelegate(
        @ActivityName String activityName) {

        return new AlternateActivityLifecycleDelegate(activityName);
    }
}
