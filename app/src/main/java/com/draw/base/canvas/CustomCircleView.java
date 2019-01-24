package com.draw.base.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.draw.base.R;


/**
 * 圆形头像
 * Created by qijian on 16/11/4.
 */

public class CustomCircleView extends View {
    private Bitmap mBmp;
    private Paint mPaint;
    private Path mPath;

    public CustomCircleView(Context context) {
        super(context);
        init();

    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        Log.d("view","attrs");
    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        Log.d("view","defstyle");
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);//在使用clip系列函数时，要禁用硬件加速功能
        mBmp = BitmapFactory.decodeResource(getResources(),R.mipmap.avator);
        mPaint = new Paint();
        mPath = new Path();
        int width = mBmp.getWidth();
        int height = mBmp.getHeight();
        mPath.addCircle(width/2,height/2,width/2, Path.Direction.CCW);
    }

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.save();
    canvas.clipPath(mPath);//将画布裁剪成圆形
    canvas.drawBitmap(mBmp,0,0,mPaint);//将位图画上去
    canvas.restore();//在对画布进行变换或者裁剪以后需要用restore()将它们复原。
}
}
