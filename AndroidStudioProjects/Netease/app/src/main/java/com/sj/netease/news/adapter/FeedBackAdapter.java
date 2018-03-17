package com.sj.netease.news.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.sj.netease.R;
import com.sj.netease.news.bean.FeedBack;
import com.sj.netease.news.bean.FeedBacks;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by sj on 2017/10/4.
 */

public class FeedBackAdapter extends BaseAdapter {
    int type_title = 0;
    int type_content = 1;
    ArrayList<FeedBacks> date;
    LayoutInflater mInflater;
    DisplayImageOptions mOptions;
    public FeedBackAdapter(ArrayList<FeedBacks> date, Context context) {
        this.date = date;
        this.mInflater = LayoutInflater.from(context);
        mOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.biz_tie_user_avater_default)
                .showImageForEmptyUri(R.drawable.biz_tie_user_avater_default)
                .showImageOnFail(R.drawable.biz_tie_user_avater_default)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(500))
                .build();
    }

    @Override
    public int getCount() {
        return date.size();
    }

    @Override
    public Object getItem(int i) {
        return date.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        int type=getItemViewType(position);
        if(type==type_title){
            TitleViewHolder titleViewHolder;
            if(view==null){
                titleViewHolder=new TitleViewHolder();
                view = mInflater.inflate(R.layout.item_feed_title, null);
                titleViewHolder.titile = view.findViewById(R.id.title);
                view.setTag(titleViewHolder);
            }else{
                titleViewHolder= (TitleViewHolder) view.getTag();
            }
        }else {
            ContentViewHolder contentViewHolder;
            if(view==null){
                contentViewHolder=new ContentViewHolder();
                view = mInflater.inflate(R.layout.item_feedback, null);
                contentViewHolder.icon = view.findViewById(R.id.profile_image);
                contentViewHolder.name = view.findViewById(R.id.net_name);
                contentViewHolder.from = view.findViewById(R.id.net_from);
                contentViewHolder.content = view.findViewById(R.id.content);
                contentViewHolder.vote =  view.findViewById(R.id.like);
                view.setTag(contentViewHolder);
            }else{
                contentViewHolder= (ContentViewHolder) view.getTag();
            }

            initHoder(contentViewHolder,date.get(position));
        }
        return view;
    }


    public void initHoder(ContentViewHolder holder,FeedBacks backs ) {
        FeedBack back = backs.getLastPosition();
        holder.name.setText(back.getN());
        holder.from.setText(back.getF());
        holder.content.setText(back.getB());
        holder.vote.setText(back.getV());
        ImageLoader.getInstance().displayImage(back.getTimg(),holder.icon);

    }
    @Override
    public int getItemViewType(int position) {
        FeedBacks feedBacks=date.get(position);
        if(feedBacks.isTitle()){
            return type_title;
        }else {
            return type_content;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
    class TitleViewHolder{
        TextView titile;
    }
    class ContentViewHolder{
        CircleImageView icon;
        TextView name;
        TextView from;
        TextView time;
        TextView content;
        TextView vote;
    }
}
