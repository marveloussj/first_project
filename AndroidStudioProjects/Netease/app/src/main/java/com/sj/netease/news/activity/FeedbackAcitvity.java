package com.sj.netease.news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.JsonObject;
import com.sj.netease.R;
import com.sj.netease.news.adapter.FeedBackAdapter;
import com.sj.netease.news.bean.FeedBack;
import com.sj.netease.news.bean.FeedBacks;
import com.sj.netease.util.Constant;
import com.sj.netease.util.HttpRespon;
import com.sj.netease.util.HttpUtil;
import com.sj.netease.util.JsonUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by sj on 2017/10/1.
 */

public class FeedbackAcitvity extends Activity{
    ListView mlistView;
    ArrayList<FeedBacks> feedBackses;
    InnerHandler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler=new InnerHandler(this);
        setContentView(R.layout.activity_feedback);
        mlistView = findViewById(R.id.listView);
        feedBackses =new ArrayList<>();
        String docid = getIntent().getStringExtra(DetailActivity.DOCID);
        String url= Constant.GetFeedBackUrl(docid);
        HttpUtil.getInstance().getDate(url,new HttpRespon<String>(String.class) {
            @Override
            public void onError(String msg) {

            }

            @Override
            public void onSuccess(String string) {
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    JSONArray jsonArray = jsonObject.optJSONArray("hotPosts");
                    FeedBacks title = new FeedBacks();
                    title.setTitle(true);
                    title.setTitleS("热门跟帖");
                    feedBackses.add(title);
                    for(int i=0;i<jsonArray.length();i++){
                        FeedBacks feedBs=new FeedBacks();
                        JSONObject tmp = jsonArray.optJSONObject(i);
                        Iterator<String> keys = tmp.keys();
                        while (keys.hasNext()){
                            String next = keys.next();
                            JSONObject everyJson = tmp.optJSONObject(next);
                            FeedBack feedBack = JsonUtil.parseJson(everyJson.toString(), FeedBack.class);
                            feedBack.setIndex(Integer.valueOf(next));
                            feedBs.add(feedBack);
                        }
                        feedBs.sort();
                        feedBackses.add(feedBs);
                    }
                    mHandler.sendEmptyMessage(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void init() {
        FeedBackAdapter adapter = new FeedBackAdapter(feedBackses, this);
        mlistView.setAdapter(adapter);

    }

    static  class InnerHandler extends android.os.Handler{
        WeakReference<FeedbackAcitvity> activity;

        public InnerHandler(FeedbackAcitvity activity) {
            this.activity = new  WeakReference<FeedbackAcitvity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            FeedbackAcitvity act=activity.get();
            if (act==null){
                return;
            }else{
                act.init();
            }

        }
    }

}
