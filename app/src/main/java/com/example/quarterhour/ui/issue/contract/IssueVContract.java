package com.example.quarterhour.ui.issue.contract;

import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.ui.base.BaseContract;

import java.io.File;

public interface IssueVContract {

    interface View extends BaseContract.BaseView{

        void publishVideoSuccess(BaseBean s);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void publishVideo(String uid, String videofile,String imgfile,String latitude,String longitude,String token,String source,String appVersion);

    }

}
