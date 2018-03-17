package com.sj.netease.news.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sj.netease.R;
import com.sj.netease.news.bean.DetailWebImage;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by sj on 2017/9/24.
 */

public class DetailImgAdapter extends PagerAdapter {
    ArrayList<DetailWebImage> images;
    Context context;
    ArrayList<View> views;
    DisplayImageOptions options;

    public DetailImgAdapter(ArrayList<DetailWebImage> images, Context context,ArrayList<View> views) {
        this.images = images;
        this.context = context;
        this.views=views;
        options= new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        PhotoView photoview = view.findViewById(R.id.photoview);
        DetailWebImage detailWebImage = images.get(position);
        ImageLoader.getInstance().displayImage(detailWebImage.getSrc(),photoview,options);
        container.addView(view);
        return view ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
