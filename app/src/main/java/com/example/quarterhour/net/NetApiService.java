package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.bean.FollowUsersBean;
import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.bean.UserBean;
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

    @GET("quarter/getJokes?page=5")
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

    //登录
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> login(@Field("mobile") String mobile, @Field("password") String password);

    @FormUrlEncoded
    @POST("quarter/getHotVideos")
    Observable<VideosBean> getHotVideos(@Field("token") String token);

    @FormUrlEncoded
    @POST("quarter/getNearVideos")
    Observable<VideosBean> getNearVideos(@Field("token") String token);

    //获取关注用户列表
    @FormUrlEncoded
    @POST("quarter/getFollowUsers")
    Observable<FollowUsersBean> getFollowUsers(@Field("uid") String uid, @Field("token") String token);

    //获取收藏列表
    @FormUrlEncoded
    @POST("quarter/getFavorites")
    Observable<CollectBean> getCollect(@Field("uid") String uid, @Field("token") String token);

}
