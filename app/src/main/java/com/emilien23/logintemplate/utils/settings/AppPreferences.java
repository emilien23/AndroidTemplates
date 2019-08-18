package com.emilien23.logintemplate.utils.settings;


import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    public static final String APP_PREFERENCES = "appPreferences";

    public static final String APP_PREFERENCES_ACCESS_TOKEN = "accessToken";

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static void init(Context context){
        preferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }


    public static void clear(){
       editor.clear();
    }

    public static void putAccessToken(String token){
        editor.putString(APP_PREFERENCES_ACCESS_TOKEN, token).apply();
    }

    public static void getAccessToken(){
        preferences.getString(APP_PREFERENCES_ACCESS_TOKEN, null);
    }

}
