package com.example.quarterhour.ui.mine.contract;

import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface CollectContract {

    interface View extends BaseContract.BaseView{
        void showCollect(CollectBean collectBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getCollect(String uid,String token);
    }

}
