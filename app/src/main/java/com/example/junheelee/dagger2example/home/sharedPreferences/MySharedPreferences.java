package com.example.junheelee.dagger2example.home.sharedPreferences;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */

public class MySharedPreferences {

    private SharedPreferences mSharedPreferences;

    @Inject
    public MySharedPreferences(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, int data) {
        mSharedPreferences.edit().putInt(key, data).apply();
    }

    public void putName(String name) {
        mSharedPreferences.edit().putString("name", name).apply();
    }

    public String getName() {
        return mSharedPreferences.getString("name", "").toString();
    }

    public int getData(String key) {
        return mSharedPreferences.getInt(key, 0);
    }
}
