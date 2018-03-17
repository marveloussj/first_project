package com.sj.netease.util;

import android.text.TextUtils;

/**
 * Created by sj on 2017/9/4.
 */

public abstract class HttpRespon <T> {
    Class<T> tClass;
    public HttpRespon (Class<T> t){
        tClass=t;
    }
    public abstract void onError(String msg);
    public abstract void onSuccess(T t);
    public void parse(String json){
        if(TextUtils.isEmpty(json)){
            onError("连接网络失败");
            return;
        }
        if(tClass==String.class){
            onSuccess((T) json);
            return;
        }
        T t = JsonUtil.parseJson(json, tClass);
        if(t!=null){
            onSuccess(t);
        }else{
            onError("json解析失败");
        }
    }
}
