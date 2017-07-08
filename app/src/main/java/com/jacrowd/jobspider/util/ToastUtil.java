package com.jacrowd.jobspider.util;


import android.support.annotation.StringRes;
import android.widget.Toast;

import com.jacrowd.jobspider.App;

/**
 * 单例吐司 工具类
 * <p/>
 * author: Shawn
 * time  : 2016/6/25 10:02
 */
public class ToastUtil {
    private static Toast toast;

    /**
     * 强大的吐司，能够连续弹的长吐司
     *
     * @param text
     */
    public static void showLongToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(App.appContext, text, Toast.LENGTH_LONG);
        } else {
            toast.setText(text);// 如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }

    /**
     * 强大的吐司，能够连续弹的短吐司
     *
     * @param text
     */
    public static void showShortToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(App.appContext, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);// 如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }

    /**
     * 强大的吐司，能够连续弹的长吐司
     *
     * @param resID 字符串资源ID
     */
    public static void showLongToast(@StringRes int resID) {
        if (toast == null) {
            toast = Toast.makeText(App.appContext, resID, Toast.LENGTH_LONG);
        } else {
            toast.setText(resID);// 如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }

    /**
     * 强大的吐司，能够连续弹的短吐司
     *
     * @param resID 字符串资源ID
     */
    public static void showShortToast(@StringRes int resID) {
        if (toast == null) {
            toast = Toast.makeText(App.appContext, resID, Toast.LENGTH_SHORT);
        } else {
            toast.setText(resID);// 如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }
}
