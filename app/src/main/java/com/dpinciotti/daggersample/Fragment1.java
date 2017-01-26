package com.dpinciotti.daggersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dpinciotti.core.di.fragment.FragmentComponentBuilderHost;
import com.dpinciotti.daggersample.di.component.Fragment1Component;
import com.dpinciotti.daggersample.di.RandomNumber;
import com.dpinciotti.daggersample.di.module.Fragment1Module;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

public class Fragment1 extends Fragment {

    @Inject @RandomNumber int randomNumber;

    @BindView(R.id.random_number) TextView randomNumberTextView;

    Fragment1Component component;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        injectDependencies();

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        randomNumberTextView.setText(String.format("Random number for this app session is %d", randomNumber));
    }

    private void injectDependencies() {
        component = ((FragmentComponentBuilderHost) getActivity())
            .getFragmentComponentBuilder(Fragment1.class, Fragment1Component.Builder.class)
            .fragmentModule(new Fragment1Module())
            .build();
        component.inject(this);
    }
}
