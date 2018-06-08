package com.example.quarterhour.ui.video.contract;

import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface NearbyContract {

    interface View extends BaseContract.BaseView{

        void getNearVideosSuccess(VideosBean nearVideosBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void getNearVideos(String token);

    }

}
