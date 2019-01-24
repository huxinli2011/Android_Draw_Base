package com.draw.base.region;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/20.
 */
public class RegionConstructView extends View {
    public RegionConstructView(Context context) {
        super(context);
    }

    public RegionConstructView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RegionConstructView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //直接构造
        drawRectRegion(canvas);
        //间接构造
        drawPathRegion(canvas);
        //枚举区域
        regionIterator(canvas);



        //1.4.3区域相交
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        Region region = new Region(10, 1000, 200, 100+990);
        region.union(new Rect(10, 1000, 50, 300+990));
        drawRegion(canvas, region, paint);
        DrawTextUtil.drawText(canvas,"Region-区域相交——region.union",50,1400);

    }

    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }

    /**
     * 1.4.1.1 直接构造
     * public Region(Region region) //复制一个Region的范围
     * public Region(Reac t)        //创建一个矩形区域
     * public Region(int left,int top,int right,int bottom) //创建一个矩形区域
     *
     * @param canvas
     */
    private void drawRectRegion(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        canvas.drawRect(new Rect(50, 50, 200, 100), paint);

        Region region = new Region(new Rect(50, 50, 200, 100));
        drawRegion(canvas, region, paint);
        DrawTextUtil.drawText(canvas,"Region-直接构造 new Region(new Rect(50, 50, 200, 100))",50,150);
    }

    /**
     * 1.4.1.2 间接构造
     * 间接构造是通过 public Region()的空构造方法与set系列方法相结合来实现的。
     *
     * setEmpty() :置空，将原来的一个区域变量变成空变量，再利用其它set方法重新构造区域
     * set(Region region) :利用新的区域替换原来的区域
     * set(Rect r):利用矩形区域替换原来的区域
     * set(int left,int top,int right,int bottom) 替换原来区域
     * setPath(Path path,Region clip) 根据路径的区域与某区域的交集构造出新的区域
     *
     * @param canvas
     */
    private void drawPathRegion(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rect = new RectF(50, 200, 200, 650);
        ovalPath.addOval(rect, Path.Direction.CCW);
        //SetPath时,传入一个比椭圆区域小的矩形区域,让其取交集
        Region rgn = new Region();
        rgn.setPath(ovalPath, new Region(50, 200, 200, 350));
        //画出路径
        drawRegion(canvas, rgn, paint);
        DrawTextUtil.drawText(canvas,"Region-间接构造(达到截取椭圆的区域) new Region() regn.setPath",50,450);
    }

    /**
     * 1.4.2 枚举区域——RegionIterator类
     * 在绘制Region对象时，其实就是先将其转换成矩形集，然后在利用画笔将每个矩形画出来而已
     */
    private void regionIterator(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rect = new RectF(50, 500, 200, 950);
        ovalPath.addOval(rect, Path.Direction.CCW);

        //构造椭圆Region
        Region rgn = new Region();
        rgn.setPath(ovalPath, new Region(50, 500, 200, 950));
        drawRegion(canvas, rgn, paint);
        DrawTextUtil.drawText(canvas,"Region-枚举区域——RegionIterator类",50,1000);
    }
}
