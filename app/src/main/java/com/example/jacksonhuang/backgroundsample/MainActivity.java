package com.example.jacksonhuang.backgroundsample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button threadButton = findViewById(R.id.btn_thread);
        threadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , ThreadActivity.class));
            }
        });

        Button asynctaskButton = findViewById(R.id.btn_asynctask);
        asynctaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , AsyncTaskActivity.class));
            }
        });

        findViewById(R.id.btn_intentservice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , IntentServiceActivity.class));
            }
        });

        findViewById(R.id.btn_rxjava).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , RxJavaActivity.class));
            }
        });
        findViewById(R.id.btn_rxjava_kotlin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , RxJavaKotlinActivity.class));
            }
        });
        findViewById(R.id.btn_kotlin_coroutines).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , KotlinCoroutinesActivity.class));
            }
        });

        // edit sleep time
        final EditText editText = findViewById(R.id.edit_sleep);
        int sleep_time = Common.getSleepTime(this);
        editText.setText(String.valueOf(sleep_time));

        // set sleep time
        findViewById(R.id.btn_set_sleep_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sleep_time = Integer.valueOf(editText.getText().toString());
                Common.setSleepTime(getBaseContext(), sleep_time);
                Toast.makeText(getBaseContext() , getString(R.string.set_sleep_time), Toast.LENGTH_LONG).show();
            }
        });
    }
}
