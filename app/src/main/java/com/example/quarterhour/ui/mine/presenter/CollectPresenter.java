package com.example.quarterhour.ui.mine.presenter;

import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.mine.contract.CollectContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CollectPresenter extends BasePresenter<CollectContract.View> implements CollectContract.Presenter {

    private NetApi netApi;

    @Inject
    public CollectPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getCollect(String uid, String token) {
        netApi.getCollect(uid, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CollectBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CollectBean collectBean) {
                        mView.showCollect(collectBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
