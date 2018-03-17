package com.sj.netease.splash.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import okhttp3.OkHttpClient;


/**
 * Created by sj on 2017/8/21.
 */

public class SplashActivity extends Activity {
    ImageView advs;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setContentView(R.la);
        GetAds();
    }
    public void GetAds(){
        final OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://www.qq.com")
                    .build();
        //开启一个异步请求
              client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                    }
                    Log.i("sj",response.body().string());

                }
            });

    }
}
