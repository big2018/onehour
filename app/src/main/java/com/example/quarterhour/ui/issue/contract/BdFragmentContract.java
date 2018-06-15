package com.example.quarterhour.ui.issue.contract;

import com.example.quarterhour.bean.BdVideoBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface BdFragmentContract {

    interface View extends BaseContract.BaseView{

        void getVideosSuccess(BdVideoBean bdVideoBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void getVideos();

    }

}
