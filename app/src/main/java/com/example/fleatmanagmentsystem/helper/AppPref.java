package com.example.fleatmanagmentsystem.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fleatmanagmentsystem.di.MyApplication;
import com.google.gson.Gson;
/*import com.vsoftcorp.ecgc.di.MyApplication;*/

public class AppPref {

    private static AppPref singleTonInstance = null;

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private Context context;
    private static Gson gson;

    public static final String PREF_NAME = "app_prefs";
    private static final int PRIVATE_MODE = 0;
    private static final String KEY_AUTH_TOKEN = "auth_token";

    private static final String KEY_USER = "auth_token";

    public static AppPref getInstance() {
        if (singleTonInstance == null) {
            singleTonInstance = new AppPref(MyApplication.getInstance().getApplicationContext());
        }
        return singleTonInstance;
    }

    public AppPref(Context context) {
        super();
        this.context = context;
        gson = new Gson();
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void saveAuthToken(String authToken) {
        editor.putString(KEY_AUTH_TOKEN, authToken);
        editor.commit();
    }

    public String getAuthToken() {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public void saveUserData(String userModel) {
        editor.putString(KEY_USER, userModel);
        editor.commit();
    }

    public String getUserData() {
        return sharedPreferences.getString(KEY_USER, null);
    }
}
