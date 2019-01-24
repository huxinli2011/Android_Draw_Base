package com.draw.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.draw.base.canvas.CircleOperationActivity;
import com.draw.base.canvas.ClipRgnActivity;
import com.draw.base.canvas.CustomCircleActivity;
import com.draw.base.canvas.CustomViewActivity;
import com.draw.base.paint.activity.PathView_1_2_Activity;
import com.draw.base.paint.activity.RectPontView_1_1_4_Activity;
import com.draw.base.paint.activity.SpiderActivity;
import com.draw.base.paint.activity.Summarize_1_1_1_Activity;
import com.draw.base.paint.activity.Summarize_1_1_3_Activity;
import com.draw.base.paint.activity.intersect_1_1_4_Activity;
import com.draw.base.region.RegionConstructActivity;
import com.draw.base.region.RegionOpActivity;
import com.draw.base.text.CanvasActivity;
import com.draw.base.text.PaintSettingActivity;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.summarize_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,Summarize_1_1_1_Activity.class));
            }
        });

        findViewById(R.id.canvas_basis_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,Summarize_1_1_3_Activity.class));
            }
        });
        findViewById(R.id.rect_point_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,RectPontView_1_1_4_Activity.class));
            }
        });

        findViewById(R.id.intersect_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,intersect_1_1_4_Activity.class));
            }
        });

        findViewById(R.id.path_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,PathView_1_2_Activity.class));
            }
        });
        findViewById(R.id.spider_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,SpiderActivity.class));
            }
        });
//////
        findViewById(R.id.paint_setting_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,PaintSettingActivity.class));
            }
        });

        findViewById(R.id.canvas_setting_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CanvasActivity.class));
            }
        });
//////
        findViewById(R.id.region_construct_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,RegionConstructActivity.class));
            }
        });
        findViewById(R.id.region_op_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,RegionOpActivity.class));
            }
        });
//////
        findViewById(R.id.canvas_operation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CircleOperationActivity.class));
            }
        });


        findViewById(R.id.canvas_circle_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CustomCircleActivity.class));
            }
        });

        findViewById(R.id.clip_rgn_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ClipRgnActivity.class));
            }
        });

        findViewById(R.id.custom_view_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CustomViewActivity.class));
            }
        });
    }
}
