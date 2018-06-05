package com.example.quarterhour.ui.jokes.presenter;

import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.jokes.contract.JokesContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class JokesPresenter extends BasePresenter<JokesContract.View> implements JokesContract.Presneter {

    NetApi netApi;

    @Inject
    public JokesPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void getJokes() {
        netApi.getJokes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<JokesBean, JokesBean>() {
                    @Override
                    public JokesBean apply(JokesBean jokesBean) throws Exception {
                        return jokesBean;
                    }
                }).subscribe(new Consumer<JokesBean>() {
            @Override
            public void accept(JokesBean jokesBean) throws Exception {
                if (mView != null)
                    mView.getJokesSuccess(jokesBean);
            }
        });
    }
}
