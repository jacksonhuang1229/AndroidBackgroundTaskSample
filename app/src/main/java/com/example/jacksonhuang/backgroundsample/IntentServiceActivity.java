package com.example.jacksonhuang.backgroundsample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by gameg on 2018/2/14.
 */

public class IntentServiceActivity extends Activity {

    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        MyLog.d("" + this);

        tv = findViewById(R.id.text);
        MyLog.d(" tv = " + tv);

        Intent newIntent = new Intent(MyIntentService.ACTION_GET_RESULT);
        newIntent.setClass(this, MyIntentService.class);
        startService(newIntent);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.example.jacksonhuang.backgroundsample.MyIntentService.ACTION_RESULT);
        registerReceiver(myBroadcastReceiver, intentFilter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
        MyLog.d("" + this);
    }
    private MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    class MyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent == null || intent.getAction() == null){
                return;
            }

            switch (intent.getAction()){
                case com.example.jacksonhuang.backgroundsample.MyIntentService.ACTION_RESULT:{
                    MyLog.d("" + IntentServiceActivity.this);
                    tv.setText(intent.getStringExtra("result"));
                    MyLog.d(" tv = " + tv);
                }
            }
        }
    }


}
