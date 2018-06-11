package com.example.quarterhour.ui.mine.contract;

import com.example.quarterhour.bean.FollowUsersBean;
import com.example.quarterhour.ui.base.BaseContract;

import java.util.List;

public interface FollowContract {
    interface View extends BaseContract.BaseView{
        void showFollowUsers(List<FollowUsersBean.DataBean> dataBeans);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getFollowUsers(String uid,String token);
    }
}
