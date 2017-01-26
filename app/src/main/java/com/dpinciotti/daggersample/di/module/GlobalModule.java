package com.dpinciotti.daggersample.di.module;

import com.dpinciotti.core.di.scope.ApplicationScope;
import com.dpinciotti.daggersample.di.RandomNumber;

import java.security.SecureRandom;

import dagger.Module;
import dagger.Provides;

/**
 * @author dpinciotti
 * @createdDate 1/26/17
 */

@Module
public class GlobalModule {

    @Provides @ApplicationScope @RandomNumber
    static int randomNumber() {
        return new SecureRandom().nextInt(10);
    }
}
