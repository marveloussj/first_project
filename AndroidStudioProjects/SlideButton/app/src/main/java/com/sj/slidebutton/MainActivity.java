package com.sj.slidebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mtv;
    slidebutton mslide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtv = (TextView) findViewById(R.id.textView);
        mslide = (slidebutton) findViewById(R.id.slidebto);
        mslide.setOnSlideChangeListener(new OnSlideChangeListener() {
            @Override
            public void onSlideChange(boolean isopen) {
                if(isopen){
                    mtv.setText("开启更新");
                }else{
                    mtv.setText("关闭更新");
                }
            }
        });
    }
}
