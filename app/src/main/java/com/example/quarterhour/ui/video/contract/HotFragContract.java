package com.example.quarterhour.ui.video.contract;

import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface HotFragContract {

    interface View extends BaseContract.BaseView{

        void getHotVideosSuccess(VideosBean hotVideosBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void getHotVideos(String token);

    }

}
