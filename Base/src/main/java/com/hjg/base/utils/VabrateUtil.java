package com.hjg.base.utils;

import android.content.Context;
import android.os.Vibrator;

/**
 * @author houjiguo
 * @title 震动
 * @date 2017/12/12  14:28
 * @Description
 */

public class VabrateUtil {

    /**
     * 震动
     *
     * @param duration 震动时间
     */
    public static void vibrate(Context context, long duration) {
        Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {
                0, duration
        };
        vibrator.vibrate(pattern, -1);
    }
}
