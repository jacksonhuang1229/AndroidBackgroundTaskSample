package com.example.jacksonhuang.backgroundsample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gameg on 2018/2/14.
 */

public class Common {
    public static final int SLEEP_TIME = 2000 ;  // ms

    public static String getResult(Context context){
        MyLog.d(" getResult start");
        try{
            int sleep_time = getSleepTime(context);
            Thread.sleep(sleep_time*1000);
        }catch (InterruptedException e){
            // do nothing
        }
        MyLog.d(" getResult finish");
        return context.getString(R.string.calulate_finish);
    }

    public static int getSleepTime(Context context){
        SharedPreferences preferences = context.getSharedPreferences("pref" , Context.MODE_PRIVATE);
        return preferences.getInt("sleep_time" , 3);
    }
    public static void setSleepTime(Context context, int sleep_time){
        SharedPreferences preferences = context.getSharedPreferences("pref" , Context.MODE_PRIVATE);
        preferences.edit().putInt("sleep_time" , sleep_time).apply();
    }
}
