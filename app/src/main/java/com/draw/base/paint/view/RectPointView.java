package com.draw.base.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/13.
 */
public class RectPointView extends View {
    private int mX, mY;
    private Paint mPaint;
    private Rect mrect;

    public RectPointView(Context context) {
        super(context);
        init();
    }

    public RectPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectPointView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mrect = new Rect(100, 10, 500, 300);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mX = (int) event.getX();
        mY = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            mX = -1;
            mY = -1;
        }
        postInvalidate();    //invalidate和postInvalidate都是让屏幕重绘，区别是invalidate一定要在主线程中执行，否则会报错，postInvalidate可以在任一线程
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mrect.contains(mX, mY)) {//检测是否包含某个点
            mPaint.setColor(Color.RED);
        } else {
            mPaint.setColor(Color.BLUE);
        }
        canvas.drawRect(mrect, mPaint);

        DrawTextUtil.drawText(canvas,"点击矩形区域用Rect的contains检测点击的点",50,400);
    }
}
