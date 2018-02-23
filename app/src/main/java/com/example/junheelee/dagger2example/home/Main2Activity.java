package com.example.junheelee.dagger2example.home;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junheelee.dagger2example.R;
import com.example.junheelee.dagger2example.home.data.User;
import com.example.junheelee.dagger2example.home.sharedPreferences.MySharedPreferences;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class Main2Activity extends BaseActivity {

    @Inject
    MySharedPreferences preferences;

    @Inject
    Retrofit client;

    @Inject
    User user;

    private final int DELAY_TIME = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ((MyApplication) getApplicationContext()).getComponent().inject(this);
        ((TextView) findViewById(R.id.tv)).setText(preferences.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (client != null && user != null) {
            Toast.makeText(getApplicationContext(), "name : " + user.getName() + ", age : " + user.getAge(), Toast.LENGTH_LONG).show();
            user.setAge(user.getAge() + 1);
            user.setName("junhee");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Main2Activity.this, Main4Activity.class));
            }
        }, DELAY_TIME);

    }
}
