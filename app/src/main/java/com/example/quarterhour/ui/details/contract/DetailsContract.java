package com.example.quarterhour.ui.details.contract;

import com.example.quarterhour.bean.UserInfoBean;
import com.example.quarterhour.bean.UserVideosBean;
import com.example.quarterhour.bean.WorkInfoBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface DetailsContract {

    interface View extends BaseContract.BaseView{

        void getWorkInfoSuccess(WorkInfoBean workInfoBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void getWorkInfo(String uid,String token);

    }

}
