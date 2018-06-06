package com.example.quarterhour.ui.details.presenter;

import com.example.quarterhour.bean.UserInfoBean;
import com.example.quarterhour.bean.UserVideosBean;
import com.example.quarterhour.bean.WorkInfoBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.details.contract.DetailsContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter extends BasePresenter<DetailsContract.View> implements DetailsContract.Presenter {

    NetApi netApi;

    @Inject
    public DetailsPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getWorkInfo(String uid,String token) {
        netApi.getWorkInfo(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<WorkInfoBean, WorkInfoBean>() {
                    @Override
                    public WorkInfoBean apply(WorkInfoBean workInfoBean) throws Exception {
                        return workInfoBean;
                    }
                }).subscribe(new Consumer<WorkInfoBean>() {
            @Override
            public void accept(WorkInfoBean workInfoBean) throws Exception {
                if (mView != null)
                    mView.getWorkInfoSuccess(workInfoBean);
            }
        });
    }

}
