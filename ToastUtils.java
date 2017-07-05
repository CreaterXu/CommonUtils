package com.example.myplayer;

import android.content.Context;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Toast显示帮助类，主要是实现如果已经Toast在显示了，就不会重新new　Ｔｏａｓｔ
 *显示
 *
 * Created by Creater on 2017/7/5.
 */

public class ToastUtils {
    private static Toast mToast;

    /**
     * showLongToast：显示长时间的Toast，为3s
     * Create by CreaterXv at 2017/7/5
     *
     * @return void
     * @params [context, msg]
     */
    public static void showLongToast(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    /**
     * showShortToast：显示短时间的Toast，为2.5s
     * Create by CreaterXv at 2017/7/5
     *
     * @return void
     * @params [context, msg]
     */
    public static void showShortToast(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * showToast:显示任意时间的Toast，但是最终会显示duration+duration%3。3s为Toast.Long的时间
     * Create by CreaterXv at 2017/7/5
     *
     * @return void
     * @params [context, msg, duration]
     */
    public static void showToast(Context context, String msg, int duration) {
        if (mToast == null) {
            mToast=Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }
        final Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mToast.show();
            }
        },0,3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mToast.cancel();
                timer.cancel();
            }
        }, duration );
    }
}
