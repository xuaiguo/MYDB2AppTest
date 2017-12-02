package com.app.xag.mydb2apptest;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;


/**
 * Created by aiguo on 2017/11/25.
 */

public class MyApplication  extends Application {

    private static Context context;

    @Override
    public  void onCreate(){
        super.onCreate();
        context = getApplicationContext();
        FlowManager.init(new FlowConfig.Builder(this).build());
//      FlowManager.init(this);//这句也可以初始化
    }

    public static Context getContext(){
        return  context;
    }
}

