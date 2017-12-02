package com.app.xag.mydb2apptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.xag.mydb2apptest.util.LogUtil;

/**
 * Created by aiguo on 2017/11/25.
 */

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("MyActivity", "【onCreate】" + getClass().getSimpleName());
        MyActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("MyActivity", "【onDestroy】" + getClass().getSimpleName());
        MyActivityCollector.removeActivity(this);
    }

}





