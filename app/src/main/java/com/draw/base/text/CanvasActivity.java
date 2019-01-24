package com.draw.base.text;

import android.app.Activity;
import android.os.Bundle;

import com.draw.base.R;

/**
 * Created by qijian on 16/10/18.
 */
public class CanvasActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_setting_activity);
    }
}
