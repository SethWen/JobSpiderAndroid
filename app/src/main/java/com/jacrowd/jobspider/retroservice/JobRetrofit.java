package com.jacrowd.jobspider.retroservice;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: Shawn
 * time  : 2017/7/9 12:09
 * desc  :
 */
public class JobRetrofit {
    public static String LAGOU_HOST = "http://www.lagou.com/";
    private JobService jobService;

    public JobRetrofit() {

        String baseUrl = "http://23.106.146.99:8000/";

        // 初始化 Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        jobService = retrofit.create(JobService.class);
    }

    public JobService getJobService() {
        return jobService;
    }
}
