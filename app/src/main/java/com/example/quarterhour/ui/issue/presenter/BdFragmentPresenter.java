package com.example.quarterhour.ui.issue.presenter;

import com.example.quarterhour.bean.BdVideoBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.issue.contract.BdFragmentContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class BdFragmentPresenter extends BasePresenter<BdFragmentContract.View> implements BdFragmentContract.Presenter {

    NetApi netApi;

    @Inject
    public BdFragmentPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getVideos() {
        netApi.getVideos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BdVideoBean, BdVideoBean>() {
                    @Override
                    public BdVideoBean apply(BdVideoBean bdVideoBean) throws Exception {
                        return bdVideoBean;
                    }
                }).subscribe(new Consumer<BdVideoBean>() {
            @Override
            public void accept(BdVideoBean bdVideoBean) throws Exception {
                if (mView != null)
                    mView.getVideosSuccess(bdVideoBean);
            }
        });
    }
}
