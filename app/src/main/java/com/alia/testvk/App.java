package com.alia.testvk;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Alyona on 09.11.2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
