package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.bean.UserInfoBean;
import com.example.quarterhour.bean.UserVideosBean;
import com.example.quarterhour.bean.WorkInfoBean;

import io.reactivex.Observable;

public class NetApi {

    private NetApiService netApiService;
    private static NetApi netApi;

    private NetApi(NetApiService netApiService) {
        this.netApiService = netApiService;
    }

    public static NetApi getNetApi(NetApiService netApiService){
        if (netApi==null){
            netApi=new NetApi(netApiService);
        }
        return netApi;
    }

    public Observable<AdBean> getAd(){
        return netApiService.getAd();
    }

    public Observable<JokesBean> getJokes(){
        return netApiService.getJokes();
    }

    public Observable<WorkInfoBean> getWorkInfo(String uid,String token){
        return netApiService.getWorkInfo(uid,token);
    }

    public Observable<UserInfoBean> getUserInfo(String uid){
        return netApiService.getUserInfo(uid);
    }

    public Observable<UserVideosBean> getUserVideos(String uid){
        return netApiService.getUserVideos(uid);
    }

    public Observable<VideosBean> getHotVideos(String token){
        return netApiService.getHotVideos(token);
    }

    public Observable<VideosBean> getNearVideos(String token){
        return netApiService.getNearVideos(token);
    }


}
