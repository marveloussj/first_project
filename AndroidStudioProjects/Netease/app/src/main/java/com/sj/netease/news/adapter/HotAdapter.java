package com.sj.netease.news.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sj.netease.R;
import com.sj.netease.splash.bean.HotDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sj on 2017/9/6.
 */

public  class HotAdapter extends BaseAdapter {
ArrayList<HotDetail> mHotDetail;
    LayoutInflater inflater;
    DisplayImageOptions options;

    public HotAdapter(ArrayList<HotDetail> mHotDetail, Context context) {
        this.mHotDetail = mHotDetail;
        inflater = LayoutInflater.from(context);
        options= new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public int getCount() {
        return mHotDetail.size();
    }

    @Override
    public Object getItem(int i) {
        return mHotDetail.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        HotDetail detail = mHotDetail.get(i);
        if(view==null){
            holder=new ViewHolder();
            view = inflater.inflate(R.layout.item_hot, null);
            holder.img= view.findViewById(R.id.img);
            holder.title= view.findViewById(R.id.title);
            holder.source=view.findViewById(R.id.source);
            holder.replyCount= view.findViewById(R.id.replyCount);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();

        }
        initView(holder,detail);
        return view;
    }
    public void initView(ViewHolder holder,HotDetail hotDetail){
        holder.title.setText(hotDetail.getTitle());
        holder.source.setText(hotDetail.getSource());
        holder.replyCount.setText(hotDetail.getReplyCount()+"跟帖");
        ImageLoader.getInstance().displayImage(hotDetail.getImg(),holder.img,options);
    }
public void addDate(List<HotDetail> add){
if(mHotDetail==null){
    mHotDetail=new ArrayList<>();
}else{
    mHotDetail.addAll(add);
    notifyDataSetChanged();
}

}
public HotDetail getDateByIndex(int index){
    HotDetail hotDetail = mHotDetail.get(index);
    return hotDetail;
}
     class ViewHolder{
        ImageView img;
        TextView title;
        TextView source;
        TextView replyCount;
    }
}
