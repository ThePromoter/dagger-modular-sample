package com.dpinciotti.daggersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.dpinciotti.core.di.PlainComponent;
import com.dpinciotti.core.di.activity.ActivityComponentBuilderHost;
import com.dpinciotti.core.di.fragment.FragmentComponentBuilder;
import com.dpinciotti.core.di.fragment.FragmentComponentBuilderHost;
import com.dpinciotti.core.ui.base.activity.BaseActivity;
import com.dpinciotti.daggersample.di.component.MainActivityComponent;
import com.dpinciotti.daggersample.di.module.MainActivityModule;
import com.dpinciotti.daggersample.di.RandomNumber;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements FragmentComponentBuilderHost {

    MainActivityComponent component;

    @Inject @RandomNumber int randomNumber;
    @Inject Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> fragmentComponentBuilderMap;

    @BindView(R.id.random_number) TextView randomNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumberTextView.setText(String.format("Random number for this app session is %d", randomNumber));
    }

    @Override protected void injectDependencies() {
        component = ((ActivityComponentBuilderHost) getApplication())
            .getActivityComponentBuilder(MainActivity.class, MainActivityComponent.Builder.class)
            .activityModule(new MainActivityModule(this))
            .build();
        component.inject(this);
    }

    @Override
    public <A extends Fragment, B extends FragmentComponentBuilder<A, ? extends PlainComponent<A>>>
    B getFragmentComponentBuilder(Class<A> fragmentKey, Class<B> builderType) {
        return builderType.cast(fragmentComponentBuilderMap.get(fragmentKey).get());
    }
}