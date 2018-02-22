package com.example.junheelee.dagger2example.home;

import android.app.Application;

import com.example.junheelee.dagger2example.home.sharedPreferences.ApiModule;
import com.example.junheelee.dagger2example.home.sharedPreferences.DaggerMyComponent;
import com.example.junheelee.dagger2example.home.sharedPreferences.MyComponent;
import com.example.junheelee.dagger2example.home.sharedPreferences.SharedPreferencesModule;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */

public class MyApplication extends Application {

    private MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyComponent
                .builder()
                .sharedPreferencesModule(new SharedPreferencesModule(getApplicationContext()))
                .apiModule(new ApiModule())
                .build();
    }

    public MyComponent getComponent() {
        return component;
    }
}
