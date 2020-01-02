package com.itn.terranode.di.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefsModule {

    private final String PREF_NAME = "prefs";

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    PrefsHelper providePrefsHelper(SharedPreferences sharedPreferences){
        return new PrefsHelper(sharedPreferences);
    }
}
