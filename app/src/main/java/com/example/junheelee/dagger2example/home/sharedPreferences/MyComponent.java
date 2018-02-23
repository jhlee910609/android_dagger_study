package com.example.junheelee.dagger2example.home.sharedPreferences;

import com.example.junheelee.dagger2example.home.BaseActivity;
import com.example.junheelee.dagger2example.home.Main2Activity;
import com.example.junheelee.dagger2example.home.Main4Activity;
import com.example.junheelee.dagger2example.home.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */
@Singleton
@Component(modules = {ApiModule.class, SharedPreferencesModule.class})
public interface MyComponent {

    void inject(MainActivity mainActivity);
    void inject(Main2Activity main2Activity);
    void inject(BaseActivity baseActivity);
    void inject(Main4Activity main4Activity);
}
