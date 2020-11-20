package com.example.ad8.compoent;

import android.app.Application;

import org.litepal.LitePal;

public class MyLitepalApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
