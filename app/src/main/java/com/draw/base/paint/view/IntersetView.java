package com.draw.base.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/15.
 */
public class IntersetView extends View {
    public IntersetView(Context context) {
        super(context);
    }

    public IntersetView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IntersetView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(50, 255, 255);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        /**
         * 静态方法判断是否相关
         */
        Rect rect_1 = new Rect(10, 10, 200, 200);
        Rect rect_2 = new Rect(190, 10, 250, 200);
        Rect rect_3 = new Rect(10, 210, 200, 300);
        //分别画出三个矩形
        paint.setColor(Color.RED);
        canvas.drawRect(rect_1,paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect_2,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(rect_3,paint);

        //判断是否相交
        Boolean interset1_2 = Rect.intersects(rect_1,rect_2);
        Boolean interset1_3 = Rect.intersects(rect_1,rect_3);

        Log.d("qijian","rect_1&rect_2:"+interset1_2+"  rect_1&rect_3:"+interset1_3);

        DrawTextUtil.drawText(canvas,"判断是否相交 Rect.intersects(rect_1,rect_2) =rect_1&rect_2:"+interset1_2+"  rect_1&rect_3:"+interset1_3,50,350);


        /**
         * 成员方法判断是否与某矩形相交
         */
        Rect rect_4 = new Rect(10, 400, 200, 600);
        paint.setColor(Color.RED);
        canvas.drawRect(rect_4,paint);
        Boolean result_1 = rect_4.intersects(10, 300, 200, 500);
        printResult(result_1, rect_4);
        DrawTextUtil.drawText(canvas,"成员方法判断是否与某矩形相交 rect_4.intersects(10, 300, 200, 500) ="+result_1,50,650);

        Boolean result_2 = rect_4.intersect(210, 10, 250, 200);
        printResult(result_2, rect_4);

        Boolean result_3 = rect_4.intersect(190, 10, 250, 200);
        printResult(result_3, rect_4);

        /**
         * 合并两个矩形
         */
        Rect rect_5 = new Rect(10, 710, 20, 720);
        Rect rect_6 = new Rect(100, 800, 110, 810);

        //分别画出源矩形rect_1\rect_2
        paint.setColor(Color.RED);
        canvas.drawRect(rect_5, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect_6, paint);

        //画出union之后的结果rect_1
        paint.setColor(Color.YELLOW);
        rect_5.union(rect_6);
        canvas.drawRect(rect_5, paint);
        DrawTextUtil.drawText(canvas,"合并红和绿两个矩形生成黄色矩形 rect_5.union(rect_6)",50,850);

        /**
         * 合并矩形某个点
         */
        Rect rect_7 = new Rect(10, 900, 100, 950);
        rect_7.union(100, 1000);// = [10,900],[100,1000]
        canvas.drawRect(rect_7,paint);
        DrawTextUtil.drawText(canvas,"合并矩形某个点 rect_7.union(100, 950)",50,1050);

        printResult(rect_7);

        rect_7 = new Rect();
        rect_7.union(100, 100);// = [0,0],[100,100]
        printResult(rect_7);

    }

    private void printResult(Boolean result, Rect rect) {
        Log.d("qijian", rect.toShortString() + "  result:" + result);
    }

    private void printResult(Rect rect) {
        Log.d("qijian", rect.toShortString());
    }
}
