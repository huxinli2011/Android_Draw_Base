package com.draw.base.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/15.
 */
public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 直线路径
         */
        Paint paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        Path path = new Path();
        path.moveTo(10, 10); //设定起始点
        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
        path.lineTo(300, 100);//画第二条直线
        path.close();//闭环

        canvas.drawPath(path, paint);
        DrawTextUtil.drawText(canvas,"画直线，路径形成三角形 canvas.drawPath",10,150);

        /**
         * 弧线路径
         *
         * arcTo(rectF1,startAngle,sweepAngle)
         * arcTo(rectF1,startAngle,sweepAngle,forceMoveTo)
         * 这是一个画弧线的方法，弧线是从椭圆上截取的一部分
         * // rectf生成椭圆的矩形，startAngle：弧开始的角度，以X轴正方向为0度  sweepAngle:弧持续的角度   forceMoveTo:是否强制将弧的起始点作为绘制起始位置
         */
        Path path1=new Path();
        path1.moveTo(10,200);
        RectF rectF1=new RectF(100,200,200,300);
        path1.arcTo(rectF1,0,90,true);
        //path1.addArc(rectF1,0,90);  //第2种方式，addArc同上面一样
        canvas.drawPath(path1,paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(rectF1,paint);
        DrawTextUtil.drawText(canvas,"画弧线路径 path.arcTo(rectF1,startAngle,sweepAngle)  canvas.drawPath",10,350);


        /**
         * 矩形路径
         * //Path.Direction.CCW 是counter-clockwise的缩写，指创建逆时针方向的矩形路径
         * //Path.Direction.CW 是clockwise的缩写，指创建顺时针的矩形的路径
         * 1、为什么生成方向无论顺时针还是逆时针生成，仅仅是生成方向不同而已，路径的大小只与生成路径的矩形大小有关，与生成方向无关。
         */
        //先创建两个大小一样的路径
        //第一个逆向生成
        Path CCWRectpath = new Path();
        RectF rect1 = new RectF(50, 400, 240, 550);
        CCWRectpath.addRect(rect1, Path.Direction.CCW);

        //第二个顺向生成
        Path CWRectpath = new Path();
        RectF rect2 = new RectF(290, 400, 480, 550);
        CWRectpath.addRect(rect2, Path.Direction.CW);

        //先画出这两个路径
        paint.setColor(Color.RED);
        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);
        DrawTextUtil.drawText(canvas,"画矩形路径 path.addRect(rect1, Path.Direction.CCW)、Path.Direction.CW     canvas.drawPath",10,600);


        /**
         * 依据路径方向布局文字
         */
        //先创建两个大小一样的路径
        //第一个逆向生成
        Path CCWRectpathTxt = new Path();
        RectF rect3 =  new RectF(50, 650, 240, 800);
        CCWRectpathTxt.addRect(rect3, Path.Direction.CCW);

        //第二个顺向生成
        Path CWRectpathTxt = new Path();
        RectF rect4 =  new RectF(290, 650, 480, 800);
        CWRectpathTxt.addRect(rect4, Path.Direction.CW);

        //先画出这两个路径
        canvas.drawPath(CCWRectpathTxt, paint);
        canvas.drawPath(CWRectpathTxt, paint);

        //依据路径写出文字
        String text="苦心人天不负,有志者事竟成";
        paint.setColor(Color.GREEN);
        paint.setTextSize(35);
        canvas.drawTextOnPath(text, CCWRectpathTxt, 0, 18, paint);//逆时针生成
        canvas.drawTextOnPath(text, CWRectpathTxt, 0, 18, paint);//顺时针生成
        DrawTextUtil.drawText(canvas,"依据路径方向布局文字 path.addRect(rect1, Path.Direction.CCW)、Path.Direction.CW     canvas.drawTextOnPath",10,850);


        /**
         * 圆角矩形路径
         */
        paint.setColor(Color.RED);
        Path pathRound = new Path();
        RectF rect5 =  new RectF(50, 900, 240, 1050);
        pathRound.addRoundRect(rect5, 10, 15 , Path.Direction.CCW);

        RectF rect6 =  new RectF(290, 900, 480, 1050);
        float radii[] ={10,15,20,25,30,35,40,45};
        pathRound.addRoundRect(rect6, radii, Path.Direction.CCW);

        canvas.drawPath(pathRound, paint);
        DrawTextUtil.drawText(canvas,"圆角矩形路径 path.addRoundRect   canvas.drawPath",10,1100);

        /**
         * 圆形路径
         */
        Path pathCircle = new Path();
        pathCircle.addCircle(100, 1200, 50, Path.Direction.CCW);
        canvas.drawPath(pathCircle, paint);
        DrawTextUtil.drawText(canvas,"圆形路径 path.addCircle   canvas.drawPath",10,1300);


        /**
         * 椭圆路径
         */
        Path pathOval = new Path();
        RectF rect = new RectF(10, 1350, 200, 1400);
        pathOval.addOval(rect, Path.Direction.CCW);
        canvas.drawPath(pathOval, paint);
        DrawTextUtil.drawText(canvas,"椭圆路径 path.addOval   canvas.drawPath",10,1450);


        /**
         * 添加弧线路径
         */
        Path pathArc = new Path();
        RectF rectArc = new RectF(10, 1500, 100, 1550);
        pathArc.addArc(rectArc, 0, 100);
        canvas.drawPath(pathArc, paint);
        DrawTextUtil.drawText(canvas,"添加弧线路径 path.addArc   canvas.drawPath",10,1600);


        /**
         * 填充模式
         * FillType.WINDING：默认值，当两个图形相交时，取相交部分显示
         * FillType.EVEN_ODD：取path所在并不相交的区域
         * FillType.INVERSE_WINDING：取path的外部区域
         * FillType.INVERSE_EVEN_ODD：取path的外部和相交区域
         * inverse 取反的意思
         */
        Paint paint_aa = new Paint();
        paint_aa.setColor(Color.RED);
        paint_aa.setStyle(Paint.Style.FILL);

        Path pathaa=new Path();
        pathaa.addRect(600,1000,800,1200, Path.Direction.CW);
        pathaa.addCircle(800,1200,100, Path.Direction.CW);
        pathaa.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(pathaa,paint_aa);
        DrawTextUtil.drawText(canvas,"填充模式 path.setFillType(Path.FillType.EVEN_ODD)",500,1350);



        /**
         * 1.2.5 Path重置(注意使用真机,模拟器可能会并没有区别)
         *
         * rewind()会清除FillType及所有的直线，曲线，点的数据等，但是会保留数据结构，这样可以实现快速重用，提高一定的性能。
         * reset() 类似于新建一个路径对象，它的所有数据空间都会被被回收并重新分配，但不会清除FillType
         *
         * 总的来说rewind()不会清除内存，会清FillType  而reset()则会清除内存但不会清处FillType.
         */

        Paint paint_xx = new Paint();
        paint_xx.setColor(Color.RED);
        paint_xx.setStyle(Paint.Style.FILL);
        paint_xx.setStrokeWidth(5);

        Path path_xx = new Path();
        path_xx.setFillType(Path.FillType.INVERSE_WINDING);
        //path_xx.rewind();
        path_xx.reset();
        path_xx.addCircle(100, 1700, 50, Path.Direction.CW);
        canvas.drawPath(path_xx, paint_xx);
        DrawTextUtil.drawText(canvas,"Path重置 path.rewind和reset的用法",200,1700);

    }
}
