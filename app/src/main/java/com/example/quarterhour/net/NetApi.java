package com.example.quarterhour.net;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;

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
}
