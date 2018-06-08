package com.example.quarterhour.ui.video.presenter;

import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.video.contract.NearbyContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NearbyPresenter extends BasePresenter<NearbyContract.View> implements NearbyContract.Presenter {

    NetApi netApi;

    @Inject
    public NearbyPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getNearVideos(String token) {
        netApi.getNearVideos(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<VideosBean, VideosBean>() {
                    @Override
                    public VideosBean apply(VideosBean nearVideosBean) throws Exception {
                        return nearVideosBean;
                    }
                }).subscribe(new Consumer<VideosBean>() {
            @Override
            public void accept(VideosBean nearVideosBean) throws Exception {
                if (mView != null)
                    mView.getNearVideosSuccess(nearVideosBean);
            }
        });
    }
}
