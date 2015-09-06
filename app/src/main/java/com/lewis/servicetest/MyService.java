package com.lewis.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 自定义一个服务
 * Created by Administrator on 15-9-2.
 */
public class MyService extends Service {
    private final static String TAG = "MyService";
    //创建一个专门的Binder对象来对下载功能进行管理
    private DownloadBinder mBinder = new DownloadBinder();

    public class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d(TAG,"startDownload executed");
        }

        public int getProgress(){
            Log.d(TAG,"getProgress executed");
            return 0;
        }
    }

    /**
     * 活动与服务之间的联系
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * 创建服务的时候调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //创建一个前台服务
        Notification notification = new Notification(R.drawable.notification_template_icon_bg
                ,"Notification comes",System.currentTimeMillis());
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        notification.setLatestEventInfo(this,"This is title","This is content",pendingIntent);
        startForeground(1,notification);
        Log.d(TAG,"onCreate executed");
    }

    /**
     * 每次服务启动的时候调用
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁的时候调用
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy executed");
    }
}
