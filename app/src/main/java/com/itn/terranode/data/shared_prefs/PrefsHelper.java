package com.itn.terranode.data.shared_prefs;

import android.content.SharedPreferences;

public class PrefsHelper {

    private final String TOKEN = "token";

    private SharedPreferences sharedPreferences;

    public PrefsHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setToken(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }

    public String getToken(){
        return sharedPreferences.getString(TOKEN, "");
    }
}
