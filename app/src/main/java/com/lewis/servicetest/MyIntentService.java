package com.lewis.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * IntentService管理线程
 * Created by Administrator on 15-9-6.
 */
public class MyIntentService extends IntentService{
    private final static String TAG = "MyIntentService";

    public MyIntentService(){
        super("MyIntentService");//调用父类的有参构造函数
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //打印当前线程的id
        Log.d(TAG,"Thread id is "+Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy executed");
    }
}
