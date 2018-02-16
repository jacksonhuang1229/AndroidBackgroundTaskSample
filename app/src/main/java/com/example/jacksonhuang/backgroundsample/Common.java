package com.example.jacksonhuang.backgroundsample;

import android.content.Context;

/**
 * Created by gameg on 2018/2/14.
 */

public class Common {
    public static final int SLEEP_TIME = 2000 ;  // ms

    public static String getResult(Context context){
        MyLog.d("");
        try{
            Thread.sleep(SLEEP_TIME);
        }catch (InterruptedException e){
            // do nothing
        }
        return context.getString(R.string.calulate_finish);
    }
}
