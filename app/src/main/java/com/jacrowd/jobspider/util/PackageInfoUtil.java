package com.jacrowd.jobspider.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * APK 包管理工具类
 * <p/>
 * author: Shawn
 * time  : 2016/7/15 10:55
 */
public class PackageInfoUtil {
    /**
     * 获取应用程序apk包的版本信息
     *
     * @param context 上下文
     * @return version
     */
    public static String getPackageVersion(Context context) {
        try {
            PackageInfo packInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "Parsing the version number failed";
        }
    }
}
