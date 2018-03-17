package com.sj.netease.util;

import android.content.Intent;

import com.sj.netease.service.DownLoadService;
import com.sj.netease.splash.acitvity.SplashAcitvity;
import com.sj.netease.splash.bean.Ads;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sj on 2017/9/4.
 */

public class HttpUtil {
    static OkHttpClient client;
    static HttpUtil util;
    private HttpUtil(){
        client = new OkHttpClient();
    }
    public static HttpUtil getInstance(){
        if(util==null){
            synchronized (HttpUtil.class){
                if(util==null){
                    util=new HttpUtil();
                }
            }
        }
        return  util;
    }

    public void getDate(String url, final HttpRespon respon){
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                respon.onError("连接服务器失败");
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    respon.onError("连接服务器失败");
                    return;
                }
                String data=response.body().string();
                respon.parse(data);
            }
        });
    }
}
