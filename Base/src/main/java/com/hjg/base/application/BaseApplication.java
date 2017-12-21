package com.hjg.base.application;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * @author houjiguo
 * @title 基础Application
 * @date 2017/12/12  13:49
 * @Description
 */

public class BaseApplication extends MultiDexApplication {

    protected static BaseApplication mApp;

    public static BaseApplication getInstance() {
        return mApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

    }

    /**
     * 解决64方法数问题。
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
