package com.tutorial.appdemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by dpondeljak on 29.09.2017..
 */

/**
 * SessionManager Class - služi za kontrolu sessiona unutar aplikacija
 * ujedno drži status logiranog korisnika
 */
public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "DemoAplikacija";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setPrijava(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);

        // commit changes
        editor.commit();

        Logger.m("Login sesija korisnika je promjenjena!");
    }

    public boolean isPrijavljen() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }
}
