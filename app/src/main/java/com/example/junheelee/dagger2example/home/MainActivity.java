package com.example.junheelee.dagger2example.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.junheelee.dagger2example.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;

import org.reactivestreams.Subscription;

import java.sql.Time;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private EditText editText;
    private Disposable editTextSub;
    private final int DELAY_TIME = 300;
    private Button btn;
    private Disposable mDisposable;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        mDisposable = RxTextView.textChangeEvents(editText)
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter(s -> !TextUtils.isEmpty(s.text().toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<TextViewTextChangeEvent>() {
                    @Override
                    public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                        Log.d(TAG, "onNext: " + textViewTextChangeEvent.text().toString());
                        btn.setText(textViewTextChangeEvent.text().toString());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        String balls[] = {"1", "3", "5"};
        io.reactivex.Observable<String> src = io.reactivex.Observable.fromArray(balls)
                .flatMap(b -> io.reactivex.Observable.just(b + "<>"));

        src.subscribe(s -> Log.e(TAG, s));



    }

    private String addA() {
        a = a++;
        return a + "";
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String name = editText.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(view.getContext(), "plz, enter your name", Toast.LENGTH_LONG).show();
                    return;
                }
                preferences.putName(name);
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        editTextSub.dispose();
        if (mDisposable.isDisposed())
            mDisposable.dispose();
    }
}
