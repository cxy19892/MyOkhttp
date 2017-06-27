package com.cxy.myokhttp.sys;

import android.app.Application;

import com.google.gson.Gson;

/**
 * Created by hasee on 2017/6/19.
 */
public class MyApplication extends Application {

    private static MyApplication instance = null;
    private Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        gson = new Gson();
    }
    public static MyApplication getInstance() {
        return instance;
    }

    public Gson getGson(){
        return gson;
    }

}
