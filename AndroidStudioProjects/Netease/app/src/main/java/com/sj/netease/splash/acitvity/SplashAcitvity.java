package com.sj.netease.splash.acitvity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.sj.netease.MainActivity;
import com.sj.netease.OnTimeClickListener;
import com.sj.netease.R;
import com.sj.netease.service.DownLoadService;
import com.sj.netease.splash.TimeView;
import com.sj.netease.splash.bean.Action;
import com.sj.netease.splash.bean.Ads;
import com.sj.netease.splash.bean.AdsDetail;
import com.sj.netease.util.Constant;
import com.sj.netease.util.HttpRespon;
import com.sj.netease.util.HttpUtil;
import com.sj.netease.util.ImageUtil;
import com.sj.netease.util.JsonUtil;
import com.sj.netease.util.Md5Helper;
import com.sj.netease.util.SharePreferenceUtil;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.RunnableFuture;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sj on 2017/8/21.
 */

public class SplashAcitvity extends Activity {
    ImageView advs;
    static final String JSON_CACHE="ads_json";
    static final String JSON_CACHE_TIME_OUT="ads_json_time_out";
    static final String JSON_CACHE_LAST="ads_json_last";
    static final String IMG_INDEX="img_index";
    Handler mhandler;
    TimeView mTimeview;

    int total;
    int length=2*1000;
    int space=250;
    int now =0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.acitvity_splash);
        advs = findViewById(R.id.advs);
        mhandler=new MyHandler(this);
        mTimeview = (TimeView) findViewById(R.id.timeView);
        mTimeview.setVisibility(View.GONE);
        mTimeview.setListener(new OnTimeClickListener() {
            @Override
            public void onClickTime(View view) {
                gotomain();
                mhandler.removeCallbacks(refresh);
            }
        });

        total=length/space;
        mhandler.post(refresh);
        getAds();
        imgShow();
    }

    Runnable refresh= new Runnable() {
        @Override
        public void run() {
            Message msg = mhandler.obtainMessage();
            msg.arg1=now;
            mhandler.sendMessage(msg);
            mhandler.postDelayed(this,space);
            now++;
        }
    };

    Runnable noimg=new Runnable() {

        @Override
        public void run() {
            gotomain();
        }
    };
    public void gotomain(){
        Intent intent=new Intent();
        intent.setClass(SplashAcitvity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void imgShow(){
        String json = SharePreferenceUtil.getString(SplashAcitvity.this, JSON_CACHE);
        if(!TextUtils.isEmpty(json)){
            mTimeview.setVisibility(View.VISIBLE);
            int index = SharePreferenceUtil.getInt(SplashAcitvity.this, IMG_INDEX);

            final Ads ads = JsonUtil.parseJson(json, Ads.class);
            int size=ads.getAds().size();
            if(ads==null){
                return;
            }
            final List<AdsDetail> adsDetils = ads.getAds();
            if(adsDetils!=null&& adsDetils.size()>0){
                final AdsDetail detil = adsDetils.get(index%size);
                List<String> res_url = detil.getRes_url();
                if(res_url!=null&& !TextUtils.isEmpty(res_url.get(0))){
                    String url = res_url.get(0);
                    String img_name = Md5Helper.toMD5(url);
                    Bitmap bitmap = ImageUtil.getImgBitmap(img_name);
                    if (bitmap!=null){
                        advs.setImageBitmap(bitmap);
                        index++;
                        SharePreferenceUtil.saveInt(SplashAcitvity.this,IMG_INDEX,index);
                        advs.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View view) {
                                Action action = detil.getAction_params();
                                if(action!=null&&!TextUtils.isEmpty(action.getLink_url())){
                                    Intent intent=new Intent();
                                    intent.setClass(SplashAcitvity.this,WebViewActivity.class);
                                    intent.putExtra(WebViewActivity.ACTION_NAME,action);
                                    startActivity(intent);
                                    finish();
                                    mhandler.removeCallbacks(refresh);
                                }

                            }
                        });
                    }
                }
            }
        }else{
            mhandler.postDelayed(noimg,3000);
            mhandler.removeCallbacks(refresh);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mhandler.removeCallbacks(refresh);
    }

    public void getAds(){
        String json = SharePreferenceUtil.getString(SplashAcitvity.this, JSON_CACHE);
        if(TextUtils.isEmpty(json)){
            httpRequest();

        }else{
            int outtime = SharePreferenceUtil.getInt(SplashAcitvity.this, JSON_CACHE_TIME_OUT);
            Long last = SharePreferenceUtil.getLong(SplashAcitvity.this, JSON_CACHE_LAST);
            long now = System.currentTimeMillis();
            if((now-last)>outtime*60*1000){
                httpRequest();
            }
        }
    }
    public void httpRequest(){
        HttpUtil util = HttpUtil.getInstance();
        util.getDate(Constant.SPLASH_URL, new HttpRespon<String>(String.class) {
            @Override
            public void onError(String msg) {
            Log.i("sj",msg);
        }

            @Override
            public void onSuccess(String json) {
              Ads ads = JsonUtil.parseJson(json, Ads.class);
                    if(null!=ads){
                        SharePreferenceUtil.saveString(SplashAcitvity.this,JSON_CACHE,json);
                        SharePreferenceUtil.saveInt(SplashAcitvity.this,JSON_CACHE_TIME_OUT,ads.getNext_req());
                        SharePreferenceUtil.saveLong(SplashAcitvity.this,JSON_CACHE_LAST,System.currentTimeMillis());
                        Intent intent=new Intent();
                        intent.setClass(SplashAcitvity.this,com.sj.netease.service.DownLoadService.class);
                        intent.putExtra(DownLoadService.ADS_DATA,ads);
                        startService(intent);
                    }
                }
            });
            }
//    public void httpRequest(){
//         final OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(Constant.SPLASH_URL)
//                    .build();
//            client.newCall(request).enqueue(new Callback() {
//                @Override public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override public void onResponse(Call call, Response response) throws IOException {
//                    if (!response.isSuccessful()) {
//                        return;
//                    }
//                    String data=response.body().string();
//                    Ads ads = JsonUtil.parseJson(data, Ads.class);
//                    if(null!=ads){
//                        SharePreferenceUtil.saveString(SplashAcitvity.this,JSON_CACHE,data);
//                        SharePreferenceUtil.saveInt(SplashAcitvity.this,JSON_CACHE_TIME_OUT,ads.getNext_req());
//                        SharePreferenceUtil.saveLong(SplashAcitvity.this,JSON_CACHE_LAST,System.currentTimeMillis());
//                        Intent intent=new Intent();
//                        intent.setClass(SplashAcitvity.this,com.sj.netease.service.DownLoadService.class);
//                        intent.putExtra(DownLoadService.ADS_DATA,ads);
//                        startService(intent);
//                    }
//                }
//            });
//
//    }
    static class MyHandler extends Handler{

        WeakReference<SplashAcitvity> activity;
        public MyHandler(SplashAcitvity act){
            activity=new WeakReference<SplashAcitvity>(act);
        }
            @Override
            public void handleMessage(Message msg) {
                SplashAcitvity act = activity.get();
                if(act==null){
                    return;
                }
                switch (msg.what){
                case 0:
                    int now=msg.arg1;
                    if(now<=act.total){
                        act.mTimeview.rotate(act.total,now);
                    }else{
                        act.mhandler.removeCallbacks(act.refresh);
                        act.gotomain();
                    }
                    break;
            }
        }

    }
}
