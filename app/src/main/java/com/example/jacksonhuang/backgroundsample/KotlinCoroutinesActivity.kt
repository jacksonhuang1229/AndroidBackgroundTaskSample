package com.example.jacksonhuang.backgroundsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class KotlinCoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        MyLog.d("" + this)
        val tv = findViewById<TextView>(R.id.text)
        MyLog.d(" tv = " + tv)

        val job = launch {
            var result = Common.getResult(this@KotlinCoroutinesActivity);

            launch (UI){
                tv.text = result;
                MyLog.d("" + this@KotlinCoroutinesActivity)
                MyLog.d(" tv = " + tv)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val refWatcher = MyApplication.getRefWatcher(this)
        refWatcher.watch(this)
        MyLog.d("" + this)
    }
}