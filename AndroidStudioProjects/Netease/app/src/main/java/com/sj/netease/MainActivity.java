package com.sj.netease;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.sj.netease.news.fragment.NewsFragment;
import com.sj.netease.news.fragment.ReadingFragment;
import com.sj.netease.news.fragment.TopicFragment;
import com.sj.netease.news.fragment.VedioFragment;
import com.sj.netease.splash.TimeView;
import com.sj.netease.util.FragmentTabHost;

public class MainActivity extends AppCompatActivity {
    long lastTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost = (FragmentTabHost)findViewById(R.id.tab_host);
        tabHost.setup(this,getSupportFragmentManager(),R.id.content);
        String[] array = getResources().getStringArray(R.array.tab_title);
        int[] imgs=new int[]{R.drawable.news_selector,R.drawable.reading_selector,R.drawable.topic_selector,R.drawable.video_selector,R.drawable.mine_selector};
        Class[] classes=new Class[]{NewsFragment.class,ReadingFragment.class, TopicFragment.class, VedioFragment.class,TopicFragment.class};
        for(int i=0;i<array.length;i++){
            TabHost.TabSpec tmp = tabHost.newTabSpec(""+i);
            tmp.setIndicator(getEveryView(this,array,imgs,i));
            tabHost.addTab(tmp, classes[i],null);
        }

    }

  public View getEveryView(Context context,String[] title,int[] imgs,int index){
      LayoutInflater inflater = LayoutInflater.from(context);
      View view = inflater.inflate(R.layout.item_title, null);
      ImageView img = (ImageView) view.findViewById(R.id.img);
      TextView tv = (TextView) view.findViewById(R.id.tv);
      img.setImageResource(imgs[index]);
      tv.setText(title[index]);
      return view;

  }

    @Override
    public void onBackPressed() {
        long now=System.currentTimeMillis();
        if(now-lastTime<2000){
            finish();
        }else{
            Toast.makeText(this, "再按一次退出网易新闻", Toast.LENGTH_SHORT).show();
        }
        lastTime=now;
    }
}