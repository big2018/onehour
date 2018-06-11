package com.example.quarterhour.ui.mine.presenter;

import android.annotation.SuppressLint;

import com.example.quarterhour.bean.FollowUsersBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.login.contract.LoginContrct;
import com.example.quarterhour.ui.mine.contract.FollowContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class FollowPresenter extends BasePresenter<FollowContract.View> implements FollowContract.Presenter{

    private NetApi netApi;

    @Inject
    public FollowPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getFollowUsers(String uid, String token) {
        netApi.getFollowUsers(uid, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<FollowUsersBean, List<FollowUsersBean.DataBean>>() {
                    @Override
                    public List<FollowUsersBean.DataBean> apply(FollowUsersBean followUsersBean) throws Exception {
                        return followUsersBean.getData();
                    }
                }).subscribe(new Observer<List<FollowUsersBean.DataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<FollowUsersBean.DataBean> dataBeans) {
                mView.showFollowUsers(dataBeans);
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
