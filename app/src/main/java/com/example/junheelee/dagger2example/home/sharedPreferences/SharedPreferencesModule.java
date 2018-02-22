package com.example.junheelee.dagger2example.home.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */
@Module
@MyApplicationScope
public class SharedPreferencesModule {

    private Context context;

    public SharedPreferencesModule(Context context) {
        this.context = context;
    }

    @Provides
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("PrefName",Context.MODE_PRIVATE);
    }
}
