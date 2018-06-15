package com.example.quarterhour.ui.issue.contract;

import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface IssueJActivityContract {

    interface View extends BaseContract.BaseView{

        void publishJokeSuccess(BaseBean baseBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void publishJoke(String uid,String token,String content);

    }

}
