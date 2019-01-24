package com.draw.base.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/11.
 */
public class BasisView extends View {
    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 1.1.1 概述
         */
        //设置画笔基本属性
        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//设置填充样式
        paint.setStrokeWidth(50);//设置画笔宽度
        canvas.drawCircle(190, 200, 100, paint);//画圆

        DrawTextUtil.drawText(canvas,"Style.STROKE",100,200);

        Paint paint2=new Paint();
        paint2.setColor(Color.RED);  //设置画笔颜色
        paint2.setStyle(Paint.Style.FILL);//设置填充样式
        paint2.setStrokeWidth(50);//设置画笔宽度
        canvas.drawCircle(490, 200, 100, paint2);

        DrawTextUtil.drawText(canvas,"Style.FILL",400,200);

        Paint paint3=new Paint();
        paint3.setColor(Color.RED);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setStrokeWidth(50);
        canvas.drawCircle(790, 200, 100, paint3);

        DrawTextUtil.drawText(canvas,"Style.FILL_AND_STROKE",700,200);

        //填充样式
        // 1、Paint.Style.STROKE  仅描边
        // 2、Paint.Style.FILL 仅填充内部
        // 3、Paint.Style.FILL_AND_STROKE 填充内部和描边

        /**
         * 1.1.2.1 setColor
         */
        Paint paint5 = new Paint();
        paint5.setAntiAlias(true);//抗锯齿
        paint5.setColor(0xFFFF0000);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setStrokeWidth(50);
        canvas.drawCircle(190, 500, 150, paint5);

        paint5.setColor(0x7EFFFF00);
        canvas.drawCircle(190, 500, 100, paint5);
    }
}
