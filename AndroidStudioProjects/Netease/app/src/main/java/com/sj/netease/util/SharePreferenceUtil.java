package com.sj.netease.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sj on 2017/8/23.
 */

public class SharePreferenceUtil {
    public static final String XML_FILE_NAME="cache";
    public static void saveString(Context context,String title,String contant){
        SharedPreferences sharedPreferences = context.getSharedPreferences(XML_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(title,contant);
        edit.apply();
    }
    public static String getString(Context context,String title){
        String contant;
        SharedPreferences sharedPreferences = context.getSharedPreferences(XML_FILE_NAME, Context.MODE_PRIVATE);
        contant = sharedPreferences.getString(title, "");
        return  contant;
    }
    public static void saveInt(Context context,String title,int contant){
        SharedPreferences sharedPreferences = context.getSharedPreferences(XML_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(title,contant);
        edit.apply();
    }
    public static int getInt(Context context,String title){
        int contant;
        SharedPreferences sharedPreferences = context.getSharedPreferences(XML_FILE_NAME, Context.MODE_PRIVATE);
        contant = sharedPreferences.getInt(title,0);
        return  contant;
    }
    public static void saveLong(Context context,String title,Long contant){
        SharedPreferences sharedPreferences = context.getSharedPreferences(XML_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(title,contant);
        edit.apply();
    }
    public static Long getLong(Context context,String title){
        Long contant;
        SharedPreferences sharedPreferences = context.getSharedPreferences(XML_FILE_NAME, Context.MODE_PRIVATE);
        contant = sharedPreferences.getLong(title,0);
        return  contant;
    }


}
