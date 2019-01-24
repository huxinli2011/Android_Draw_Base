package com.draw.base.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/12.
 */
public class BasisCanvasView extends View {

    public BasisCanvasView(Context context) {
        super(context);
    }

    public BasisCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisCanvasView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 1.1.3.1 画布背景设置
         */
//        canvas.drawColor(0xFFFF00FF);
//        canvas.drawARGB(255,255,0,255)
        canvas.drawRGB(100, 255, 255);



        /**
         * 1.1.3.2 画直线
         */
        Paint paintLine=new Paint();
        paintLine.setColor(Color.RED);  //设置画笔颜色
        paintLine.setStyle(Paint.Style.FILL_AND_STROKE);
        paintLine.setStrokeWidth(5);//设置画笔宽度
        canvas.drawLine(50, 50, 200, 200, paintLine);
        DrawTextUtil.drawText(canvas,"画直线 canvas.drawLine",50,230);


        /**
         * 多条直线
         */
        Paint paintLines = new Paint();
        paintLines.setColor(Color.RED);
        paintLines.setStrokeWidth(5);

        float[] pts = {400, 50, 500, 200,     500, 50, 600, 200};//注意这里不是形成连接线，而是两个点形成一条线
        canvas.drawLines(pts, paintLines);
        //canvas.drawLines(pts, 2, 4, paintLines);  //offset:数组中索引为2的数字开始绘图，有4个数值参与绘图也就是点（500，200）和（500，50）
        DrawTextUtil.drawText(canvas,"画多条直线 canvas.drawLines",400,230);

        /**
         * 画点
         */
        Paint paintPoint = new Paint();
        paintPoint.setColor(Color.RED);
        paintPoint.setStrokeWidth(15);
        canvas.drawPoint(100, 280, paintPoint);
        DrawTextUtil.drawText(canvas,"画点 canvas.drawPoint",50,350);

        /**
         * 多点
         */
        Paint paintPoints = new Paint();
        paintPoints.setColor(Color.RED);
        paintPoints.setStrokeWidth(25);

        float[] points = {500, 280,  550, 280,  600, 280};
        canvas.drawPoints(points,  paintPoints);
        //canvas.drawPoints(points, 2, 4, paintPoints);
        DrawTextUtil.drawText(canvas,"画多点 canvas.drawPoints",400,350);


        /**
         * 矩形
         */
        Paint paintRect = new Paint();
        paintRect.setColor(Color.RED);
        paintRect.setStyle(Paint.Style.STROKE);
        paintRect.setStrokeWidth(15);
        //直接构造
        canvas.drawRect(50, 400, 150, 500, paintRect);
        DrawTextUtil.drawText(canvas,"画矩形-直接构造 canvas.drawRect",50,550);


        //使用RectF构造
        Paint paintRectf = new Paint();
        paintRectf.setColor(Color.RED);
        paintRectf.setStyle(Paint.Style.FILL);
        RectF rect1 = new RectF(500f, 400f, 600f, 500f);
        canvas.drawRect(rect1, paintRectf);
        DrawTextUtil.drawText(canvas,"画矩形-RectF构造 canvas.drawRect(rectf,paint)",450,550);


        /**
         * 圆角矩形
         */
        Paint paintRoundRect=new Paint();
        paintRoundRect.setColor(Color.RED);
        paintRoundRect.setStyle(Paint.Style.FILL);
        paintRoundRect.setStrokeWidth(15);

        RectF rect2 = new RectF(50, 600, 200, 700);
        canvas.drawRoundRect(rect2, 20, 20, paintRoundRect); //rx 为生成圆角的X轴半径，ry为生成圆角的Y轴半径
        DrawTextUtil.drawText(canvas,"画圆角矩形 canvas.drawRoundRect",50,750);

        /**
         * 圆
         */
        Paint paintCircle=new Paint();
        paintCircle.setColor(Color.RED);
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setStrokeWidth(15);
        canvas.drawCircle(100, 850, 50, paintCircle); //cx 圆心点的X轴坐标，cy 圆心点的Y轴坐标
        DrawTextUtil.drawText(canvas,"画圆 canvas.drawCircle",50,950);

        /**
         * 画椭圆
         */
        Paint paintOval = new Paint();
        paintOval.setColor(Color.RED);
        paintOval.setStyle(Paint.Style.STROKE);
        paintOval.setStrokeWidth(5);

        RectF rect = new RectF(50, 1000, 300, 1100);
        canvas.drawRect(rect, paintOval);

        paintOval.setColor(Color.GREEN);//更改画笔颜色
        canvas.drawOval(rect, paintOval);//同一个矩形画椭圆
        //canvas.drawOval(left, top, right, bottom, paint);
        DrawTextUtil.drawText(canvas,"画椭圆 canvas.drawOval",50,1150);


        /**
         * 画弧
         */
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        RectF rectArc1 = new RectF(10, 1200, 100, 1300);
        canvas.drawArc(rectArc1, 0, 90, true, paint);
        // startAngle:弧开始的角度，以X轴正方向为0度  sweepAngle:弧持续的角度  useCenter:是否有弧的两边，为true时表示带两边，为false时，只有一条弧

        RectF rectArc2 = new RectF(110, 1200, 200, 1300);
        canvas.drawArc(rectArc2, 0, 90, false, paint);

        paint.setStyle(Paint.Style.FILL);
        RectF rectArc3 = new RectF(200, 1200, 290, 1300);
        canvas.drawArc(rectArc3, 0, 90, true, paint);


        DrawTextUtil.drawText(canvas,"画弧 canvas.drawArc，前面是有弧的两边，后面这个没有弧的两边",50,1350);


    }
}
