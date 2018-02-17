package com.example.jacksonhuang.backgroundsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxJavaKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        MyLog.d("" + this)
        val tv = findViewById<TextView>(R.id.text)
        MyLog.d(" tv = " + tv)

        val disposable = Single.fromCallable { Common.getResult(this@RxJavaKotlinActivity) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { s ->
                    MyLog.d("" + this@RxJavaKotlinActivity)
                    tv.text = s
                    MyLog.d(" tv = " + tv)
                }
    }

    override fun onDestroy() {
        super.onDestroy()
        val refWatcher = MyApplication.getRefWatcher(this)
        refWatcher.watch(this)
        MyLog.d("" + this)
    }
}
