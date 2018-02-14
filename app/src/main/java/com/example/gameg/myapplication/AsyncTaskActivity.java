package com.example.gameg.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

import static com.example.gameg.myapplication.Common.SLEEP_TIME;

/**
 * Created by gameg on 2018/2/14.
 */

public class AsyncTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        MyLog.d("" + this);
        final TextView tv = findViewById(R.id.text);
        MyLog.d(" tv = " + tv);

        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... voids) {
                MyLog.d("");
                try{
                    Thread.sleep(SLEEP_TIME);
                }catch (InterruptedException e){
                    // do nothing
                }
                return getString(R.string.calulate_finish);
            }

            @Override
            protected void onPostExecute(String s) {
                MyLog.d("" + AsyncTaskActivity.this);
                tv.setText(s);
                MyLog.d(" tv = " + tv);
            }
        }.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
        MyLog.d("" + this);
    }
}
