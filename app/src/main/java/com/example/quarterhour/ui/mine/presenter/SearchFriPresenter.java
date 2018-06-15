package com.example.quarterhour.ui.mine.presenter;

import com.example.quarterhour.bean.SearchFriBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.mine.contract.SearchFriContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchFriPresenter extends BasePresenter<SearchFriContract.View> implements SearchFriContract.Presenter {

    private NetApi netApi;

    @Inject
    public SearchFriPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void searchFri(String keywords) {
        netApi.searchFri(keywords)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchFriBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchFriBean searchFriBean) {
                        mView.showFri(searchFriBean);
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
