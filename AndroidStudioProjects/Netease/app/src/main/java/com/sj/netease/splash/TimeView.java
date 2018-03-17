package com.sj.netease.splash;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sj.netease.OnTimeClickListener;
import com.sj.netease.R;

/**
 * Created by sj on 2017/8/25.
 */

public class TimeView extends View {
    OnTimeClickListener mListener;
    TextPaint mTextPaint;
    String content="跳过";
    Paint circlep;
    Paint outP;
    RectF outR;
    int inner;
    int pading=5;
    int all;
    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeView);
        int outC = typedArray.getColor(R.styleable.TimeView_OutColor, Color.BLACK);
        int innerC = typedArray.getColor(R.styleable.TimeView_InnerColor, Color.BLACK);
        mTextPaint=new TextPaint();

        circlep=new Paint();
        outP=new Paint();
        //抗锯齿
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(20);
        mTextPaint.setColor(Color.WHITE);
        circlep.setFlags(Paint.ANTI_ALIAS_FLAG);
        circlep.setColor(innerC);
        outP.setFlags(Paint.ANTI_ALIAS_FLAG);
        outP.setColor(outC);
        outP.setStyle(Paint.Style.STROKE);
        outP.setStrokeWidth(pading);
        float width = mTextPaint.measureText(content);
        inner= (int) (width+2*pading);
        all=inner+2*pading;
        outR=new RectF(pading/2,pading/2,all-pading/2,all-pading/2);
        typedArray.recycle();
    }
    int degree;
    public void rotate(int total,int now){
        int space=360/total;
        degree=now*space;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(all,all);
    }
    public void setListener(OnTimeClickListener listener){
        mListener=listener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float y = canvas.getHeight() / 2;
        float descent = mTextPaint.descent();
        float ascent = mTextPaint.ascent();


        canvas.drawCircle(all/2,all/2,inner/2,circlep);
        canvas.drawText(content,2*pading,y-((descent+ascent)/2),mTextPaint);
        canvas.save();
        canvas.rotate(-90,all/2,all/2);
        canvas.drawArc(outR,0,degree,false,outP);

        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                setAlpha(0.3f);
                break;
            case MotionEvent.ACTION_UP:
                setAlpha(1.0f);
                if(mListener!=null){
                    mListener.onClickTime(this);
                }
                break;
        }
        return true;
    }
}
