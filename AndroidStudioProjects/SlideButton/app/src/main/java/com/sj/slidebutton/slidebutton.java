package com.sj.slidebutton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sj on 2017/8/17.
 */

public class slidebutton extends View {
    Bitmap mslidebmp;
    Bitmap mbagbmp;
    Paint mpaint;
    public slidebutton(Context context) {
        super(context);
    }

    public slidebutton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mslidebmp = BitmapFactory.decodeResource(getResources(), R.drawable.slide_button);
        mbagbmp = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        mpaint = new Paint();
        mpaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthmode =MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightmode =MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        switch (widthmode){
            case MeasureSpec.AT_MOST:
                widthsize=mbagbmp.getWidth();
            break;
            case MeasureSpec.EXACTLY:
                break;
        }
        switch (heightmode){
            case MeasureSpec.AT_MOST:
                heightsize=mbagbmp.getHeight();
                break;
            case MeasureSpec.EXACTLY:
                break;
        }
            setMeasuredDimension(widthsize,heightsize);
    }
    float mleft;
    float mStratY;
    float mStratX;
    boolean isopen =false;
    OnSlideChangeListener mOnSlideChangeListener;
    public void setOnSlideChangeListener(OnSlideChangeListener listener){
        mOnSlideChangeListener=listener;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mbagbmp,0,0,mpaint);
    if(mleft<0){
        mleft=0;
    }
    if(mleft>mbagbmp.getWidth()-mslidebmp.getWidth()){
        mleft=mbagbmp.getWidth()-mslidebmp.getWidth();
    }
    if(mleft==0){
            if(isopen){
                if(mOnSlideChangeListener!=null){
                    mOnSlideChangeListener.onSlideChange(!isopen);
                }

            }
       isopen=false;
        }
        if(mleft==mbagbmp.getWidth()-mslidebmp.getWidth()){
            if(!isopen){
                if(mOnSlideChangeListener!=null){
                    mOnSlideChangeListener.onSlideChange(!isopen);
                }
            }
            isopen=true;
        }
        canvas.drawBitmap(mslidebmp,mleft,0,mpaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                mStratX = event.getX();
                mStratY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float newX = event.getX();
                float newY = event.getY();

                float dx = newX - mStratX;
                mleft+=dx;


                mStratX=newX;
                mStratY=newY;
                break;
            case MotionEvent.ACTION_UP:
                int bgwidth = mbagbmp.getWidth()/2;
                float btwidth = mleft + mslidebmp.getWidth() / 2;
                if(bgwidth>btwidth){
                    mleft=0;
                }else{
                    mleft=mleft=mbagbmp.getWidth()-mslidebmp.getWidth();
                }
                break;
        }
        invalidate();
        return true;
    }
}
