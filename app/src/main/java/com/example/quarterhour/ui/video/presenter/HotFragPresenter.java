package com.example.quarterhour.ui.video.presenter;

import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.video.contract.HotFragContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HotFragPresenter extends BasePresenter<HotFragContract.View> implements HotFragContract.Presenter {

    NetApi netApi;

    @Inject
    public HotFragPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getHotVideos(String token) {
        netApi.getHotVideos(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<VideosBean, VideosBean>() {
                    @Override
                    public VideosBean apply(VideosBean hotVideosBean) throws Exception {
                        return hotVideosBean;
                    }
                }).subscribe(new Consumer<VideosBean>() {
            @Override
            public void accept(VideosBean hotVideosBean) throws Exception {
                if (mView != null)
                    mView.getHotVideosSuccess(hotVideosBean);
            }
        });
    }
}
