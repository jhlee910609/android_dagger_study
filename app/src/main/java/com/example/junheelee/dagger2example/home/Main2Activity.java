package com.example.junheelee.dagger2example.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junheelee.dagger2example.R;
import com.example.junheelee.dagger2example.home.sharedPreferences.MySharedPreferences;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class Main2Activity extends BaseActivity {

    @Inject
    MySharedPreferences preferences;

    @Inject
    Retrofit client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ((MyApplication) getApplicationContext()).getComponent().inject(this);
        ((TextView) findViewById(R.id.tv)).setText(preferences.getName());

        if (client != null)
            Toast.makeText(getApplicationContext(), "client is not null!", Toast.LENGTH_LONG).show();
    }
}
