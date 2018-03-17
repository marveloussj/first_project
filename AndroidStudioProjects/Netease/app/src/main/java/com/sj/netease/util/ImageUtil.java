package com.sj.netease.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;

import static android.R.attr.bitmap;

/**
 * Created by sj on 2017/8/23.
 */

public class ImageUtil {
    public static boolean imgIsExist(String cache_name){
        Bitmap bitmap = getImgBitmap(cache_name);
        if(bitmap!=null){
                return true;
            }
        return false;

    }
    public static Bitmap getImgBitmap(String cache_name){
        File sd = Environment.getExternalStorageDirectory();
        File cacheFile = new File(sd, Constant.CACHE);
        File imgFile = new File(cacheFile, cache_name+".jpg");
        if(imgFile.exists()){
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            return bitmap;
        }
        return null;
        }

}
