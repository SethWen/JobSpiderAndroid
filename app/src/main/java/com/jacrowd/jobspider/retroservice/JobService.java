package com.jacrowd.jobspider.retroservice;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: Shawn
 * time  : 2017/7/9 12:01
 * desc  :
 */
public interface JobService {
    /**
     * 获取拉钩的数据
     *
     * @param type   1:Python; 2:Android
     * @param offset 页码偏移量
     */
    @GET("jobs/get_lagou")
//    Observable<String> getLagouJobs(@Query("type") String type, @Query("offset") int offset);
    Observable<LagouResponse> getLagouJobs(@Query("type") int type, @Query("offset") int offset);


    /**
     * 获取智联的数据
     *
     * @param type   1:Python; 2:Android
     * @param offset 页码偏移量
     */
    @GET("jobs/get_zhilian")
    Observable<ZhilianResponse> getZhilianJobs(@Query("type") int type, @Query("offset") int offset);
}
