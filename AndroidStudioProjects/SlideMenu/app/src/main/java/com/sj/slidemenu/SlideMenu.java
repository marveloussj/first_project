package com.sj.slidemenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sj on 2017/8/18.
 */

public class SlideMenu extends ViewGroup {
    public SlideMenu(Context context) {
        super(context);
    }

    public SlideMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    View mcontentview;
    View mmenuview;
    int mleft=0;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
         mcontentview = getChildAt(0);
         mmenuview=getChildAt(1);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        if(mleft<0){
            mleft=0;
        }
        if(mleft>mmenuview.getMeasuredWidth()){
           mleft=mmenuview.getMeasuredWidth();
        }

        mcontentview.layout(mleft,0,mleft+mcontentview.getMeasuredWidth(),mcontentview.getMeasuredHeight());
        mmenuview.layout(mleft-mmenuview.getMeasuredWidth(),0,mleft,mmenuview.getMeasuredHeight());
    }
    float mStartX;
    float mStartY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mStartX = event.getX();
                mStartY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float newX = event.getX();
                float newY = event.getY();
                float dx = newX - mStartX;
                mleft += dx;
                mStartX = newX;
                mStartY = newY ;
                break;
            case MotionEvent.ACTION_UP:
                if(mleft>mmenuview.getMeasuredWidth()/2){
                    mleft=mmenuview.getMeasuredWidth();
                }else{
                mleft=0;
            }
                break;
        }
requestLayout();
    return true;


    }
}
