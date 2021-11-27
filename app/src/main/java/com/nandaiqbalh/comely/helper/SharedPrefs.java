package com.nandaiqbalh.comely.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    String myPref = "MAIN_PREF";
    SharedPreferences sp;

    String login = "login";

    public SharedPrefs(Activity activity) {
        sp = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE);
    }

    public void setStatusLogin(boolean statusLogin) {
        sp.edit().putBoolean(login, statusLogin).apply();

    }

    public boolean getStatusLogin() {
        return sp.getBoolean(login, false);
    }
}
