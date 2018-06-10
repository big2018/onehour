package com.example.quarterhour.ui.login.presenter;

import android.text.TextUtils;

import com.example.quarterhour.bean.UserBean;
import com.example.quarterhour.net.NetApi;
import com.example.quarterhour.ui.base.BasePresenter;
import com.example.quarterhour.ui.login.contract.LoginContrct;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContrct.View> implements LoginContrct.Presenter{

    private NetApi netApi;

    @Inject
    public LoginPresenter(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public void login() {
        String mobile = mView.getMobile();
        String password = mView.getPassword();
        if (!TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(password)){
            netApi.login(mobile,password)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<UserBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(UserBean userBean) {
                            mView.loginSuccess(userBean);
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
}
