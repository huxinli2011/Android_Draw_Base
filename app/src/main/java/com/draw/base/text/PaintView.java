package com.draw.base.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/17.
 */
public class PaintView extends View {
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         *  1.3.1.1 填充样式的区别
         */
        setStyle(canvas);

        /**
         * 1.3.1.o2 setTextAlign
         */
        setAlign(canvas);

        /**
         * 1.3.1.3_1 设置字体样式_常规设置
         */
        setTextStyle(canvas);

        /**
         * 1.3.1.3_2 设置字体样式_字体倾斜度设置
         */
        setTextSkewX(canvas);

        /**
         * 1.3.1.4 水平拉伸
         */
        setTextScaleX(canvas);

    }

    /**
     * 1.3.1.1 填充样式的区别
     * @param canvas
     */
    private void setStyle(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth (5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(100);//设置文字大小

        //绘图样式，设置为填充
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText("床前明月光", 10,100, paint);
        DrawTextUtil.drawText(canvas,"设置文字的填充样式  canvas.drawText Style.STROKE、Style.FILL、Style.FILL_AND_STROKE",10,150);
    }

    /**
     *1.3.1.2 setTextAlign
     * @param canvas
     */
    private void setAlign(Canvas canvas){

        Paint paint=new Paint();
        paint.setColor(Color.RED);

        paint.setStrokeWidth (5);
        paint.setAntiAlias(true);
        paint.setTextSize(80);
        paint.setTextAlign(Paint.Align.LEFT);
        //Paint.Align.LEFT  居左绘制，即通过drawText()函数指定的起始点最左侧，文字从起始点位置开始绘制。
        //Paint.Align.RIGHT 居右绘制，即通过drawText()函数指定的起始点在文字右侧位置。
        //Paint.Align.CENTER居中绘制，即通过drawText()函数指定的起始点在文字中间位置。

        canvas.drawText("床前明月光", 400,250, paint);
        DrawTextUtil.drawText(canvas,"设置字体样式_起始点的相对位置  paint.setTextAlign(Paint.Align.LEFT)  canvas.drawText",10,300);
    }

    /**
     * 1.3.1.3_1 设置字体样式_常规设置
     * @param canvas
     */
    private void setTextStyle(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("床前明月光", 10,380, paint);

        paint.setFakeBoldText(true);//设置是否为粗体文字
        paint.setUnderlineText(true);//设置下划线
        paint.setStrikeThruText(true);//设置带有删除线效果
        canvas.drawText("床前明月光", 500,380, paint);
        DrawTextUtil.drawText(canvas,"设置字体样式_常规设置 setFakeBold，Underline，StrikeThru   canvas.drawText",10,420);
    }

    /**
     * 1.3.1.3_2 设置字体样式_字体倾斜度设置
     * @param canvas
     */
    private void setTextSkewX(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        //正常样式
        //canvas.drawText("床前明月光", 10,100, paint);

        //向右倾斜
        paint.setTextSkewX(-0.25f);
        canvas.drawText("床前明月光", 10,500, paint);

        //向左倾斜
        paint.setTextSkewX(0.25f);
        //canvas.drawText("床前明月光", 10,300, paint);
        DrawTextUtil.drawText(canvas,"设置字体样式_字体倾斜度设置 setTextSkewX  canvas.drawText",10,550);
    }

    /**
     * 1.3.1.4 水平拉伸
     * @param canvas
     */
    private void setTextScaleX(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        //正常样式
        //canvas.drawText("床前明月光", 10,900, paint);
        //拉伸两倍
        paint.setTextScaleX(2);
        canvas.drawText("床前明月光", 10,650, paint);
        DrawTextUtil.drawText(canvas,"设置字体样式_水平拉伸 setTextScaleX  canvas.drawText",10,700);
    }
}
