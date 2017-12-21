package com.hjg.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hjg.base.utils.ACache;
import com.hjg.base.utils.ScreenUtils;
import com.hjg.base.utils.VabrateUtil;
import com.hjg.base.widget.swipLib.SwipeBackActivity;
import com.hjg.base.widget.swipLib.SwipeBackLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xiaofei.library.hermeseventbus.HermesEventBus;


/**
 * @author houjiguo
 * @title 可侧滑退出的基础activity类
 * @date 2017/12/12  13:42
 * @Description 基础activity类
 */

public abstract class BaseActivity extends SwipeBackActivity {
    protected ACache mCache;
    protected Activity activity;
    private SwipeBackLayout mSwipeBackLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        mCache = ACache.get(this);//file缓存工具类
        initSwipe();
        mSwipeBackLayout.setEnableGesture(isAllowSwipExit());/*设置是否支持侧滑返回*/
        if (isStateBarTransparent()) {//是否状态栏消失
            ScreenUtils.hideStatusBar(activity);
        }
        //注册eventbus
        HermesEventBus.getDefault().register(this);
    }

    /**
     * 初始化侧滑状态
     */
    protected void initSwipe() {
        mSwipeBackLayout = getSwipeBackLayout();
        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL,EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {

            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                VabrateUtil.vibrate(activity, 20);
            }

            @Override
            public void onScrollOverThreshold() {
                VabrateUtil.vibrate(activity, 20);
            }
        });
    }

    /**
     * 是否允许侧滑退出（一般情况下splash界面，引导界面和主界面都是不允许侧滑退出的。）
     */
    protected abstract boolean isAllowSwipExit();

    private long lastClickTime;

    @Override
    public void startActivity(Intent intent) {
        // 防止连续点击
        if (isFastDoubleClick()) {
            return;
        }
        super.startActivity(intent);
    }

    /**
     * eventBUs的接收参数的复写方法
     *
     * @param object
     */
    @Subscribe(threadMode = ThreadMode.MAIN)//在ui线程执行
    public void onEventMainThread(Object object) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HermesEventBus.getDefault().unregister(this);

    }


    /**
     * 判断事件出发时间间隔是否超过预定值
     */
    public boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    /**
     * 状态栏是否消失
     *
     * @return true 消失不占位置
     * false  显示不占位置，需要使用stateBarUtils来改变状态栏颜色
     */
    protected abstract boolean isStateBarTransparent();
}
