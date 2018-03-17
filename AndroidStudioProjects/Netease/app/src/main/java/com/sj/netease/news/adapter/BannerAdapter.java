package com.sj.netease.news.adapter;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sj.netease.R;
import com.sj.netease.splash.bean.Banner;

import java.util.ArrayList;

/**
 * Created by sj on 2017/9/9.
 */

public class BannerAdapter extends PagerAdapter {

    ArrayList<View> view;
    ArrayList<Banner> banners;
    DisplayImageOptions options;
    int size;
    public BannerAdapter(ArrayList<View> view,ArrayList<Banner> banners) {
        this.view = view;
        this.banners=banners;
        size=view.size();
        options=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition=position%size;
        View tmp = view.get(realPosition);
        ImageView img=tmp.findViewById(R.id.image);
        Banner banner = banners.get(realPosition);
        ImageLoader.getInstance().displayImage(banner.getImgsrc(),img,options);
        container.addView(tmp);
        return tmp;
                
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
