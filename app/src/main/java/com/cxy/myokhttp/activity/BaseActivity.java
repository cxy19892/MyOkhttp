package com.cxy.myokhttp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cxy.myokhttp.sys.AppManager;
import com.cxy.myokhttp.sys.MyApplication;
import com.google.gson.Gson;

import butterknife.ButterKnife;

/**
 * Created by hasee on 2017/6/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            AppManager.getAppManager().addActivity(this);
            initWeight();
        } else {
            throw new NullPointerException("you must import activity layout id!");
        }
    }

    public Gson getGson() {
        if (gson == null) {
            gson = MyApplication.getInstance().getGson();
            if (gson == null) {
                gson = new Gson();
            }
        }
        return gson;
    }

    public abstract int getLayoutId();

    public abstract void initWeight();
}
