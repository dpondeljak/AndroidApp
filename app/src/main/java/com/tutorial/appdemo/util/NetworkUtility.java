package com.tutorial.appdemo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtility {

    public static final String WIFI_STATE = "WIFI";
    public static final String MOBILE_STATE = "MOBILE";
    public static final String NONE_STATE = "NONE";

    public static boolean isConnected(Context context) {
        ConnectivityManager connManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo activeNetworkInfo = connManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            return true;
        }
        return false;
    }

    public static String getNetworkStatus(Context context) {
        ConnectivityManager connManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo activeNetworkInfo = connManager.getActiveNetworkInfo();

        if(activeNetworkInfo != null){
            if(activeNetworkInfo.getType() == connManager.TYPE_WIFI) {
                return WIFI_STATE;
            } else if (activeNetworkInfo.getType() == connManager.TYPE_MOBILE) {
                return MOBILE_STATE;
            }
        }

        return NONE_STATE;
    }
}
