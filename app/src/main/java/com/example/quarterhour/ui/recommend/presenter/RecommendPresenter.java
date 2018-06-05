package com.example.quarterhour.ui.recommend.presenter;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.recommend.contract.RecommendContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecommendPresenter extends BasePresenter<RecommendContract.View> implements RecommendContract.Presenter{

    private NetApi netApi;

    @Inject
    public RecommendPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getAd() {
        netApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        if (mView!=null){
                            mView.showAd(adBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getJokes() {
        netApi.getJokes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokesBean jokesBean) {
                        if (mView!=null){
                            mView.showJokes(jokesBean);
                        }
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
