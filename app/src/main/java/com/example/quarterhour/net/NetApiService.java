package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.bean.BdVideoBean;
import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.bean.FollowUsersBean;
import com.example.quarterhour.bean.SearchFriBean;
import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.bean.UserBean;
import com.example.quarterhour.bean.UserInfoBean;
import com.example.quarterhour.bean.UserVideosBean;
import com.example.quarterhour.bean.WorkInfoBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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

    @FormUrlEncoded
    @POST("quarter/searchFriends")
    Observable<SearchFriBean> searchFri(@Field("keywords") String keywords);


    @FormUrlEncoded
    @POST("quarter/publishJoke")
    Observable<BaseBean> publishJoke(@Field("uid") String uid, @Field("token") String token, @Field("content") String content);

    @Multipart
    @POST("quarter/publishVideo")
    Observable<BaseBean> publishVideo(@Part("uid") RequestBody uid,
                                      @Part MultipartBody.Part videofile,
                                      @Part MultipartBody.Part imgfile,
                                      @Part("latitude") RequestBody latitude,
                                      @Part("longitude") RequestBody longitude,
                                      @Part("token") RequestBody token,
                                      @Part("source") RequestBody source,
                                      @Part("appVersion") RequestBody appVersion);


    @GET("quarter/getVideos")
    Observable<BdVideoBean> getVideos();


}
