package com.example.jacksonhuang.backgroundsample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

import static com.example.jacksonhuang.backgroundsample.Common.SLEEP_TIME;

/**
 * Created by gameg on 2018/2/14.
 */

public class ThreadActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        MyLog.d("" + this);
        final TextView tv = findViewById(R.id.text);
        MyLog.d(" tv = " + tv);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyLog.d("");
                final String result = Common.getResult(ThreadActivity.this);

                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        MyLog.d("" + ThreadActivity.this);
                        tv.setText(result);
                        MyLog.d(" tv = " + tv);
                    }
                });

            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
        MyLog.d("" + this);
    }
}
