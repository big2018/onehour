package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetApiService {

    //首页轮播广告
    @GET("quarter/getAd")
    Observable<AdBean> getAd();

    @GET("quarter/getJokes?page=3")
    Observable<JokesBean> getJokes();

}
