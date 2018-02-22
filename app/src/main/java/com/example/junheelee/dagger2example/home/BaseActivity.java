package com.example.junheelee.dagger2example.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.junheelee.dagger2example.R;
import com.example.junheelee.dagger2example.home.sharedPreferences.MySharedPreferences;
import com.example.junheelee.dagger2example.home.sharedPreferences.SharedPreferencesModule;

import javax.inject.Inject;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */

public class BaseActivity extends AppCompatActivity {

    @Inject
    protected MySharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplicationContext()).getComponent().inject(this);
    }
}
