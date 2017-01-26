package com.dpinciotti.daggersample;

import android.app.Activity;
import android.app.Application;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.activity.ActivityComponentBuilder;
import com.dpinciotti.core.di.activity.ActivityComponentBuilderHost;
import com.dpinciotti.daggersample.di.AppComponent;
import com.dpinciotti.daggersample.di.DaggerAppComponent;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class MyApplication extends Application implements ActivityComponentBuilderHost {

    AppComponent appComponent;

    @Inject Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> componentBuilders;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
    }

    @Override
    public <A extends Activity, B extends ActivityComponentBuilder<A, ? extends PlainComponent<A>>>
    B getActivityComponentBuilder(Class<A> activityKey, Class<B> builderType) {
        return builderType.cast(componentBuilders.get(activityKey).get());
    }
}