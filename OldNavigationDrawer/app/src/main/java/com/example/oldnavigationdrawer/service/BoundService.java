package com.example.oldnavigationdrawer.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BoundService extends Service {

    private IBinder mBinder = new MyBinder();
    @Override
    public void onCreate() {
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "onBind", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "onUnBind", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    public class MyBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }
    public void show(){
        Toast.makeText(this, "show() method", Toast.LENGTH_SHORT).show();
    }

}