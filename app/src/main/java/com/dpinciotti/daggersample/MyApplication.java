package com.dpinciotti.daggersample;

import android.app.Activity;
import android.app.Application;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.activity.ActivityComponentBuilder;
import com.dpinciotti.core.di.activity.ActivityComponentBuilderHost;
import com.dpinciotti.daggersample.di.component.AppComponent;
import com.dpinciotti.daggersample.di.component.DaggerAppComponent;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import timber.log.Timber;

public class MyApplication extends Application implements ActivityComponentBuilderHost {

    AppComponent appComponent;

    @Inject Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> componentBuilders;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
    }

    @Override
    public <A extends Activity, B extends ActivityComponentBuilder<A, ? extends PlainComponent<A>>>
    B getActivityComponentBuilder(Class<A> activityKey, Class<B> builderType) {
        return builderType.cast(componentBuilders.get(activityKey).get());
    }
}