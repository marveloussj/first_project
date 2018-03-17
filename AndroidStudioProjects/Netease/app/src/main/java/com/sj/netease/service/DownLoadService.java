package com.sj.netease.service;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.sj.netease.splash.bean.Ads;
import com.sj.netease.splash.bean.AdsDetail;
import com.sj.netease.util.Constant;
import com.sj.netease.util.ImageUtil;
import com.sj.netease.util.Md5Helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by sj on 2017/8/22.
 */

public class DownLoadService extends IntentService {
    public static final String ADS_DATA="ads";
    public DownLoadService(){
        super("DownLoadService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Ads ads = (Ads) intent.getSerializableExtra(ADS_DATA);
        List<AdsDetail> adsDetails = ads.getAds();
        for (AdsDetail adsDetail:adsDetails) {
            List<String> imgs = adsDetail.getRes_url();
            if(imgs!=null){
                String img_url = imgs.get(0);
                if(!TextUtils.isEmpty(img_url)){
                    String cache_name = Md5Helper.toMD5(img_url);
                    if(!ImageUtil.imgIsExist(cache_name)){
                        downLoadImage(img_url,cache_name);

                    }

                }
            }

        }
    }
    public void downLoadImage(String img_url,String cache_name){
        try {
            URL url=new URL(img_url);
            URLConnection urlConnection = url.openConnection();
            Bitmap bitmap = BitmapFactory.decodeStream(urlConnection.getInputStream());

            saveToSD(bitmap,cache_name);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveToSD(Bitmap bitmap,String cache_name){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File sd = Environment.getExternalStorageDirectory();
            File cacheFile = new File(sd, Constant.CACHE);
            if(!cacheFile.exists()){
                cacheFile.mkdirs();
            }
            File imgFile = new File(cacheFile, cache_name+".jpg");
            if(imgFile.exists()){
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(imgFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG,50,fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Log.i("sj","done");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
   }

