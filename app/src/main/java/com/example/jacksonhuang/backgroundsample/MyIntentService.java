package com.example.jacksonhuang.backgroundsample;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import static com.example.jacksonhuang.backgroundsample.Common.SLEEP_TIME;

/**
 * Created by gameg on 2018/2/16.
 */

public class MyIntentService extends IntentService{
    public static final String ACTION_GET_RESULT = "getResult";
    public static final String ACTION_RESULT = "result";


    public MyIntentService(){
        super("MyIntentService");
    }
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        MyLog.d("");
        if(intent == null || intent.getAction() == null){
            return;
        }

        if(intent.getAction().equals(ACTION_GET_RESULT)) {

            String result =  Common.getResult(this);
            Intent broadcastIntent = new Intent(ACTION_RESULT);
            broadcastIntent.putExtra("result", result);
            sendBroadcast(broadcastIntent);

        }
    }
}
