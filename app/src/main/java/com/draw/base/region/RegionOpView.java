package com.draw.base.region;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import com.draw.base.DrawTextUtil;

/**
 * Created by qijian on 16/10/31.
 */

public class RegionOpView extends View {
    private Paint paint;
    private Rect rect1,rect2;
    private Region region,region2;
    public RegionOpView(Context context) {
        super(context);
        init();
    }

    public RegionOpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegionOpView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        //构造两个矩形
        rect1 = new Rect(100,100,400,200);
        rect2 = new Rect(200,0,300,300);

        //构造一个画笔，画出矩形轮廓
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);


        //构造两个Region
        region = new Region(rect1);
        region2= new Region(rect2);

        //1、 取两个区域的交集
        region.op(region2, Region.Op.XOR);
        //region.op(react,region1,Region.Op.INTERSECT);
        //region.op(region1,region2, Region.Op.XOR);
        //intersect 取交集显示（显示中间区域）
        //difference 取补集显示（显示两边区域）
        //replace    替换显示（显示上面矩形整个区域）
        //reverse_difference 反转补集（显示上下两个区域）
        //union  并集（全部显示区域）
        //xor    异并集（除中间不显示，其它区域不显示）

        //2、region几个判断方法
        //region.isEmpty(); 判断该区域是否为空
        //region.isRect(); 判断该区域是否是一个矩阵
        //region.isComplex();//判断该区域是否是多个矩阵的组件

        //3、getBound 系列函数,这两个函数用于返回当前矩形所对应的Path对象
        //getBound系统函数用于返回一个Region的边界
        //public Rect getBounds()
        //public boolean getBounds(Rect r)
        //这两个函数用于返回能够包裹当前路径的最小矩形
        //public Path getBounddaryPath()
        //public boolean getBoundaryPath(Path path)

        //4、是否包含
        //Region中是否包某个点
        //public boolean contains(int x,int y)
        //如下这两个函数用于判断该区域是否包含某个矩形
        //public boolean quickContains(Rect r)
        //public boolean quickContains(int left,int top,int right,int bottom)

        //5、是否相交
        //判断该区域是否没有和指定矩形相交
        //public boolean quickReject(Rect r)
        //public boolean quickReject(int left,int top,int right,int bottom)
        //判断该区域是否没有和指定区域相交
        //public boolean quickReject(Region rgn)

        //6、平移变换
        //public void translate(int dx,int dy)
        //public void translate(int dx,int dy,Region dst)
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画出相交的矩形
        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);

        //画面相交的结果
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        drawRegion(canvas, region, paint);
        DrawTextUtil.drawText(canvas,"画两个region的交集 region.op(region2, Region.Op.INTERSECT)",400,100);
    }

    private void drawRegion(Canvas canvas,Region rgn,Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}
