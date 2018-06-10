package com.example.quarterhour.ui.login.contract;

import com.example.quarterhour.bean.UserBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface LoginContrct {

    interface View extends BaseContract.BaseView{
        void loginSuccess(UserBean userBean);
        String getMobile();
        String getPassword();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void login();
    }

}
