package com.dpinciotti.daggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dpinciotti.core.di.activity.ActivityComponentBuilderHost;
import com.dpinciotti.daggersample.di.MainActivityComponent;
import com.dpinciotti.daggersample.di.MainActivityModule;

public class MainActivity extends AppCompatActivity {

    MainActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = ((ActivityComponentBuilderHost) getApplication())
                .getActivityComponentBuilder(MainActivity.class, MainActivityComponent.Builder.class)
                .activityModule(new MainActivityModule())
                .build();
        component.inject(this);

        setContentView(R.layout.activity_main);
    }
}