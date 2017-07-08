package com.jacrowd.jobspider.util;

import android.util.Log;

/**
 * 打印 Log 工具类
 * <p/>
 * author: Shawn
 * time  : 2016/6/25 10:02
 */
public class LogUtil {

    private static final String DEFAULT_TAG = "▉▉▉";
    /**
     * isDebug = false 时不打印 Log
     */
    private static boolean isDebug = true;

    public static void d(String tag) {
        if (isDebug) {
            Log.d(DEFAULT_TAG, tag);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void d(Object object, String msg) {
        if (isDebug) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void e(String tag) {
        if (isDebug) {
            Log.e(DEFAULT_TAG, tag);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void e(Object object, String msg) {
        if (isDebug) {
            Log.e(object.getClass().getSimpleName(), msg);
        }
    }

    public static void i(String tag) {
        if (isDebug) {
            Log.i(DEFAULT_TAG, tag);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void i(Object object, String msg) {
        if (isDebug) {
            Log.i(object.getClass().getSimpleName(), msg);
        }
    }
}
