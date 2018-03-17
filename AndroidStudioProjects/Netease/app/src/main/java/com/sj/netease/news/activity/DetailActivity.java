
package com.sj.netease.news.activity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sj.netease.R;
import com.sj.netease.news.bean.DetailWeb;
import com.sj.netease.news.bean.DetailWebImage;
import com.sj.netease.news.bean.WebDetail;
import com.sj.netease.news.bean.WebDetailImag;
import com.sj.netease.util.Constant;
import com.sj.netease.util.HttpRespon;
import com.sj.netease.util.HttpUtil;
import com.sj.netease.util.JsonUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;


/**
 * Created by sj on 2017/9/18.
 */


public class DetailActivity extends SwipeBackActivity {
    public static final String  DOCID="doc";
    String doc_id;
    WebView webView;
    TextView textViewRC;
    TextView send;
    EditText feeback;
    MyHandler mHandler;
    LinearLayout share_outer;
    String body;
    int replyCount;
    final int SUCCESS=0;
    Boolean hasFocus=false;
    SwipeBackLayout mSwipeBackLayout;
    ArrayList<DetailWebImage> webimg;
    @JavascriptInterface
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView= (WebView) findViewById(R.id.webView);
        textViewRC= (TextView) findViewById(R.id.replayCount);
        textViewRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(DetailActivity.this,FeedbackAcitvity.class);
                intent.putExtra(DOCID,doc_id);
                startActivity(intent);
            }
        });
        send= (TextView) findViewById(R.id.send);
        share_outer= (LinearLayout) findViewById(R.id.share_outer);
        feeback= (EditText) findViewById(R.id.feeback);
        final Drawable left=getResources().getDrawable(R.drawable.biz_pc_main_tie_icon);
        left.setBounds(0,0,30,30);
        feeback.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                hasFocus=focus;
                if(focus){
                    feeback.setCompoundDrawables(null,null,null,null);
                    feeback.setHint("");
                    share_outer.setVisibility(View.GONE);
                    send.setVisibility(View.VISIBLE);
                }else{
                    feeback.setCompoundDrawables(left,null,null,null);
                    feeback.setHint("写跟帖");
                    share_outer.setVisibility(View.VISIBLE);
                    send.setVisibility(View.GONE);
                }
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this,"demo");
        mHandler=new MyHandler(this);
        doc_id = getIntent().getStringExtra(DOCID);
        HttpUtil util = HttpUtil.getInstance();
        String url = Constant.GetDetailUrl(doc_id);
        util.getDate(url, new HttpRespon<String>(String.class) {
            @Override
            public void onError(String msg) {

            }

            @Override
            public void onSuccess(String json) {
                try {
                    JSONObject js=new JSONObject(json);
                    JSONObject needjs = js.optJSONObject(doc_id);
                    DetailWeb web = JsonUtil.parseJson(needjs.toString(), DetailWeb.class);
                    if(web!=null){
                        body = web.getBody();
                        webimg = (ArrayList<DetailWebImage>) web.getImg();
                        replyCount=web.getReplyCount();
                        for(int i=0;i<webimg.size();i++){
                            String src=webimg.get(i).getSrc();
                            String imgTag="<img src='"+src+"'onclick=\"show()\"/>";
                            String tag="<!--IMG#"+i+"-->";
                            body=body.replace(tag,imgTag);
                        }
                        String titleHTML="<p><span style='font-size:18px;'><strong>"+web.getTitle()+"</strong></span></p>";
                        titleHTML=titleHTML+"<p><span style='color:#666666;'>"+web.getSource()+"&nbsp&nbsp"+web.getPtime()+"</span></p>";
                        body=titleHTML+body;
                        body="<html><head><style>img{width:100%}</style><script type='text/javascript'>function show(){window.demo.javaShow()} </script> </head><body>"+body+"</body></html>";
                        mHandler.sendEmptyMessage(SUCCESS);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
        mSwipeBackLayout=getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    @Override
    public void onBackPressed() {
        if(hasFocus){
            webView.requestFocus();
        }else{
            finish();
        }
    }

    @JavascriptInterface
    public void javaShow(){
        Intent intent=new Intent();
        intent.setClass(this,DetailImgActivity.class);
        intent.putExtra(DetailImgActivity.IMGNAME,webimg);
        startActivity(intent);

}
    public void initWebView(){
        webView.loadDataWithBaseURL(null,body,"text/html","utf-8",null);
        textViewRC.setText(String.valueOf(replyCount));

    }
    static class MyHandler extends Handler{
       WeakReference<DetailActivity> activity;

        public MyHandler(DetailActivity dActivity) {
            this.activity = new WeakReference<DetailActivity>(dActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            DetailActivity detailActivity=activity.get();
            if(activity.get()==null){
                return;
            }
            detailActivity.initWebView();

        }
    }
}


