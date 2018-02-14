package com.example.gameg.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
    }
}
