package com.draw.base.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/18.
 */
public class CanvasView extends View {
    private Context mContext;
    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 1.3.2.1 普通绘制
         */
        drawSubText(canvas);

        /**
         * 1.3.2.2 逐个指定文字位置
         */
        drawPosText(canvas);

        /**
         * 1.3.2.3 沿路径绘制
         */
        drawPathText(canvas);

        defaultTypeface(canvas);

        defaultFromStyle(canvas);

        /**
         * 1.3.3.2 自字义字体
         */
        drawCustomFont(canvas);

    }

    /**
     * 1.3.2.1 普通绘制
     *
     * @param canvas
     */
    private void drawSubText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);

        canvas.drawText("床前明月光", 2, 4, 10, 100, paint);
        DrawTextUtil.drawText(canvas,"普通绘制-指定截取字符串 canvas.drawText(xx,start,end)",10,150);
    }

    /**
     * 1.3.2.2 逐个指定文字位置
     */
    private void drawPosText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);

        float[] pos = new float[]{80, 200,
                80, 300,
                80, 400,
                80, 500};
        canvas.drawPosText("床前明月", pos, paint);
        DrawTextUtil.drawText(canvas,"普通绘制-逐个指定文字位置 canvas.drawPosText(xx,pos[])",10,550);
    }

    /**
     * 1.3.2.3 沿路径绘制
     * @param canvas
     */
    private void drawPathText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setTextSize(45);
        paint.setStyle(Paint.Style.STROKE);

        //先创建两个相同的圆形路径，并先画出两个路径原图
        Path circlePath = new Path();
        circlePath.addCircle(220, 800, 150, Path.Direction.CCW);//逆向绘制
        canvas.drawPath(circlePath, paint);//绘制出路径原形

        Path circlePath2 = new Path();
        circlePath2.addCircle(600, 800, 150, Path.Direction.CCW);
        canvas.drawPath(circlePath2, paint);//绘制出路径原形

        String string = "床前明月光,疑是地上霜";
        paint.setColor(Color.GREEN);
        //hoffset、voffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, paint);
        //第二个路径，改变hoffset、voffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, paint);  //hOffset:与路径起始点的水平偏移量，vOffset:与路径中心的垂直偏移量。
        DrawTextUtil.drawText(canvas,"绘制文字-沿路径绘制 canvas.drawTextOnPath(xx,path,hOffset,vOffset)-设置偏移量",10,1000);
    }

    /**
     * 1.3.3 使用android自带的字体样式
     * //Typeface类中默认有三种自带的样式：Typeface.SANS_SERIF、Typeface.MONOSPACE、Typeface.SERIF 这几种样式支持中文不太好
     * @param canvas
     */
    private void defaultTypeface(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        paint.setTypeface(Typeface.SERIF);
        canvas.drawText("床前明月光",10,1150, paint);
        DrawTextUtil.drawText(canvas,"绘制文字-使用android自带的字体样式 paint.setTypeface(Typeface.SERIF)  canvas.drawText()",10,1200);
    }


    /**
     * 1.3.3 设置字体样式
     * Typeface.NORMAL  正常字体
     * Typeface.BOLD    粗体
     * Typeface.ITALIC  斜体
     * Typeface.BOLD_ITALIC 粗斜体
     * @param canvas
     */
    private void defaultFromStyle(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);

        Typeface typeface=Typeface.defaultFromStyle(Typeface.BOLD_ITALIC);
        paint.setTypeface(typeface);

        canvas.drawText("床前明月光",10,1300, paint);
        DrawTextUtil.drawText(canvas,"绘制文字-设置字体样式 paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC))  canvas.drawText()",10,1350);
    }

    /**
     * 1.3.3.2 自字义字体
     * @param canvas
     */
    private void drawCustomFont(Canvas canvas){
        //自定义字体，，，迷你简罗卜
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(60);

        AssetManager mgr= mContext.getAssets();//得到AssetManager
        //根据路径得到Typeface
        Typeface typeface=Typeface.createFromAsset(mgr, "fonts/jian_luobo.ttf");
        paint.setTypeface(typeface);

        canvas.drawText("床前明月光,疑是地上霜",10,1450, paint);
        DrawTextUtil.drawText(canvas,"绘制文字-自字义字体 paint.setTypeface  canvas.drawText()",10,1500);
    }
}
