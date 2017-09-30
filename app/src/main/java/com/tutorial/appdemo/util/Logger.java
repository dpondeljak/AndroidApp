package com.tutorial.appdemo.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by dpondeljak on 28.09.2017..
 */

public class Logger {

    public static void m(String message) {
        Log.d("[APP_DEMO]: ", "" + message);
    }

    public static void t(Context context, String message) {
        Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
    }

    public static void T(Context context, String message) {
        Toast.makeText(context, message + "", Toast.LENGTH_LONG).show();
    }
}
