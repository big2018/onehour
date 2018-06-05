package com.example.quarterhour.ui.recommend.contract;

import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface RecommendContract {
    interface View extends BaseContract.BaseView{
        void showAd(AdBean adBean);
        void showJokes(JokesBean jokesBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getAd();
        void getJokes();
    }
}
