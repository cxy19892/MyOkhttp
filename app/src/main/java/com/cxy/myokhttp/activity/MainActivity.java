package com.cxy.myokhttp.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxy.myokhttp.R;
import com.cxy.myokhttp.bean.LoginResultInfo;
import com.cxy.myokhttp.glide.GlideCircleTransform;
import com.cxy.myokhttp.glide.GlideSetting;
import com.cxy.myokhttp.glide.LoadImage;
import com.cxy.myokhttp.glide.LoadImageListener;
import com.cxy.myokhttp.utils.ApiParams;
import com.cxy.myokhttp.utils.OkManager;
import com.cxy.myokhttp.utils.UrlConfig;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_context_tv)
    TextView mainContextTv;
    @BindView(R.id.main_context_iv1)
    ImageView mainContextIv1;
    @BindView(R.id.main_context_iv2)
    ImageView mainContextIv2;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private final String TAG = OkManager.class.getSimpleName();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWeight() {
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                method_Login();
                return true;
            case R.id.action_2:

                return true;
            case R.id.action_3:

                return true;
            case R.id.action_4:

                return true;
            case R.id.action_5:

                return true;
            case R.id.action_6:

                return true;
            case R.id.action_7:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getData() {

    }

    private void method_Login() {
        ApiParams params = new ApiParams();
        params.with("userName", "13699013722");
        params.with("passWord", "123456");
        params.with("client", "doctor");
        params.with("version", "2.6.6");
        OkManager.getInstance().asyncJsonStringByURL(UrlConfig.URL_LOGIN, params, OkManager.Method.POST, this, new OkManager.OkJSstrCallBack() {
            @Override
            public void onResponse(String result) {
                mainContextTv.setText(result);
                Log.d(TAG, "onResponse1: "+result);
                LoginResultInfo loginInfo = null;
                try {
                    loginInfo = getGson().fromJson(result, LoginResultInfo.class);
                }catch (Exception E){
                    E.printStackTrace();
                }


                if (loginInfo != null) {
                    loadImage(loginInfo.getPhoto());
                    Log.d(TAG, "onResponse1: "+loginInfo.getStatus());
                }else{
                    Log.d(TAG, "onResponse1: loginInfo == null");
                }
            }

            @Override
            public void onError(String result) {

            }
        });
    }

    private void loadImage(String url){
        if(TextUtils.isEmpty(url)){
            return;
        }
        GlideSetting.Builder GlideBuilder = new GlideSetting.Builder();
        GlideBuilder.setAsGif(true);
        GlideBuilder.setSkipMemoryCache(false);
        GlideBuilder.setCropType(1);
        GlideBuilder.setTransformation(new GlideCircleTransform(this));
        LoadImage.LoadImage(/*UrlConfig.HOST_DOCTOR_URL + url*/"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864345397&di=c0495f022b662be3a591f5174ad916cf&imgtype=0&src=http%3A%2F%2Fs1.dwstatic.com%2Fgroup1%2FM00%2F68%2F9B%2F1febc518f98f323be20ad23fbe9f70a2.gif", mainContextIv1, new GlideSetting(GlideBuilder), new LoadImageListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "onSuccess: ");
            }

            @Override
            public void onError(Exception e, String url) {
                e.printStackTrace();
                Log.e(TAG, "onError: " + url);
            }
        });
    }


    @OnClick({R.id.fab})
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
