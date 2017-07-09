package com.jacrowd.jobspider;

import android.app.Application;
import android.content.Context;

import com.jacrowd.jobspider.retroservice.JobRetrofit;

/**
 * author: Shawn
 * time  : 2017/7/8 19:34
 * desc  :
 */
public class App extends Application {
    public static Context appContext;
    public static JobRetrofit jobRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
        jobRetrofit = new JobRetrofit();
    }
}
