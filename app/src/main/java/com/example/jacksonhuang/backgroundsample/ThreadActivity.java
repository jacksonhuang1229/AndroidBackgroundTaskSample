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
                try{
                    Thread.sleep(SLEEP_TIME);
                }catch (InterruptedException e){
                    // do nothing
                }

                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        MyLog.d("" + ThreadActivity.this);
                        tv.setText(R.string.calulate_finish);
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
