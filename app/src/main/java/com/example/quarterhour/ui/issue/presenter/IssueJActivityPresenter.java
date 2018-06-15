package com.example.quarterhour.ui.issue.presenter;

import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.issue.contract.IssueJActivityContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class IssueJActivityPresenter extends BasePresenter<IssueJActivityContract.View> implements IssueJActivityContract.Presenter {

    NetApi netApi;

    @Inject
    public IssueJActivityPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void publishJoke(String uid, String token, String content) {
        netApi.publishJokes(uid, token, content)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseBean, BaseBean>() {
                    @Override
                    public BaseBean apply(BaseBean baseBean) throws Exception {
                        return baseBean;
                    }
                }).subscribe(new Consumer<BaseBean>() {
            @Override
            public void accept(BaseBean baseBean) throws Exception {
                if (mView != null)
                    mView.publishJokeSuccess(baseBean);
            }
        });
    }
}
