package com.sj.netease.util;

import android.text.TextUtils;

import com.google.gson.Gson;

/**
 * Created by sj on 2017/8/22.
 */

public class JsonUtil {
    private static Gson mgson;
        public static <T> T parseJson(String json,Class<T> tClass){
            if(mgson==null){
                mgson=new Gson();
            }
            if(TextUtils.isEmpty(json)){
                return null;
            }
            return mgson.fromJson(json,tClass);
        }


}
