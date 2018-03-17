package com.sj.netease.news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sj.netease.R;
import com.sj.netease.news.adapter.DetailImgAdapter;
import com.sj.netease.news.bean.DetailWebImage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sj on 2017/9/24.
 */

public class DetailImgActivity extends Activity  {
    public static final String IMGNAME="images";
    ViewPager viewpager;
    ArrayList<View> views;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_img);
        viewpager = findViewById(R.id.viewpager);
        views=new ArrayList<>();
           ArrayList<DetailWebImage> imgs = (ArrayList<DetailWebImage>) getIntent().getSerializableExtra(IMGNAME);
        if(imgs!=null){
            for(DetailWebImage detailWebImages:imgs){
                View view = View.inflate(this, R.layout.item_detail_img,null);
                views.add(view);
            }
        }
        DetailImgAdapter adapter=new DetailImgAdapter(imgs,this,views);
        viewpager.setAdapter(adapter);
    }
}
