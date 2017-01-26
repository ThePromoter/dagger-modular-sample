package com.dpinciotti.daggersample;

import android.os.Bundle;

import com.dpinciotti.core.ui.base.activity.ActivityLifecycleLogger;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

public class AlternateActivityLifecycleDelegate extends ActivityLifecycleLogger {

    public AlternateActivityLifecycleDelegate(String className) {
        super(className);
    }

    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        // Analytics go here!
    }
}
