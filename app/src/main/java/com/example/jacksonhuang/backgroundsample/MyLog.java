package com.example.jacksonhuang.backgroundsample;

import android.util.Log;

/**
 * Created by gameg on 2018/2/14.
 */

public class MyLog {
    public static final String appName = "MyApplication";
    public static boolean DEBUG = true;

    public static void d(String msg){
        String[] infos = getAutoJumpLogInfos();
        Log.d(appName, "[" + infos[0] + "] [ " + infos[1] + "]( " + infos[2] + " )  " + msg);
    }
    /**
     * 获取打印信息所在方法名，行号等信息
     * @return
     */
    private static String[] getAutoJumpLogInfos() {
        String[] infos = new String[] { "", "", "" };
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length < 5) {
            Log.e("MyLogger", "Stack is too shallow!!!");
            return infos;
        } else {
            infos[0] = elements[4].getClassName().substring(
                    elements[4].getClassName().lastIndexOf(".") + 1);
            infos[1] = elements[4].getMethodName() + "()";
            infos[2] = String.valueOf(elements[4].getLineNumber());
            return infos;
        }
    }
}
