package com.alia.testvk.screen.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

import com.alia.testvk.R;
import com.google.gson.Gson;
import com.vk.sdk.VKAccessToken;

/**
 * Created by Alyona on 10.11.2017.
 */

public class LoginController {
    FragmentActivity activity;
    public static final String KEY_STORED_TOKEN = "LoginController.KEY_STORED_TOKEN";
    private Gson gson;

    public LoginController(FragmentActivity activity){
       this.activity = activity;
    }
    private SharedPreferences getSharedPrefs() {
        return activity.getSharedPreferences(activity.getString(R.string.pref_user_data), Context.MODE_PRIVATE);
    }
    private Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
    public void persistToken(VKAccessToken token){
        getSharedPrefs().edit().putString(KEY_STORED_TOKEN, getGson().toJson(token)).commit();
    }
    public VKAccessToken getToken(){
        SharedPreferences prefs = getSharedPrefs();
        if (prefs.contains(KEY_STORED_TOKEN)) {
            return getGson().fromJson(prefs.getString(KEY_STORED_TOKEN, ""), VKAccessToken.class);
        }
        return null;
    }
}
