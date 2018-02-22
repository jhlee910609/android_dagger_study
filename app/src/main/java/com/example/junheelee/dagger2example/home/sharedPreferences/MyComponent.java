package com.example.junheelee.dagger2example.home.sharedPreferences;

import com.example.junheelee.dagger2example.home.BaseActivity;
import com.example.junheelee.dagger2example.home.Main2Activity;
import com.example.junheelee.dagger2example.home.MainActivity;

import dagger.Component;
import dagger.Module;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */
@Component(modules = SharedPreferencesModule.class)
@MyApplicationScope
public interface MyComponent {

    void inject(MainActivity mainActivity);
    void inject(Main2Activity main2Activity);
    void inject(BaseActivity baseActivity);
}
