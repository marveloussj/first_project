package com.sj.netease.splash.acitvity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sj.netease.R;
import com.sj.netease.splash.bean.Action;

import java.io.Serializable;

/**
 * Created by sj on 2017/8/24.
 */

public class WebViewActivity extends Activity {
    public static final String ACTION_NAME="action_name";
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = findViewById(R.id.webview);
        Action action = (Action) getIntent().getSerializableExtra(ACTION_NAME);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(action.getLink_url());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }


        });
    }
}
