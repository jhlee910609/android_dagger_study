package com.example.junheelee.dagger2example.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junheelee.dagger2example.R;
import com.example.junheelee.dagger2example.home.sharedPreferences.MySharedPreferences;

import javax.inject.Inject;

import dagger.multibindings.IntoMap;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String name = ((EditText) findViewById(R.id.editText)).getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(view.getContext(), "plz, enter your name", Toast.LENGTH_LONG).show();
                    return;
                }
                preferences.putName(name);
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
        }
    }
}
