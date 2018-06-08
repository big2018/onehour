package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.bean.UserInfoBean;
import com.example.quarterhour.bean.UserVideosBean;
import com.example.quarterhour.bean.WorkInfoBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetApiService {

    //首页轮播广告
    @GET("quarter/getAd")
    Observable<AdBean> getAd();

    @GET("quarter/getJokes?page=8")
    Observable<JokesBean> getJokes();

    @FormUrlEncoded
    @POST("quarter/getWorkInfo")
    Observable<WorkInfoBean> getWorkInfo(@Field("uid") String uid,
                                         @Field("token") String token);

    @FormUrlEncoded
    @POST("user/getUserInfo")
    Observable<UserInfoBean> getUserInfo(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("quarter/getUserVideos")
    Observable<UserVideosBean> getUserVideos(@Field("uid") String uid);

}
