package com.example.quarterhour.ui.jokes.contract;

import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface JokesContract {

    interface View extends BaseContract.BaseView{

        void getJokesSuccess(JokesBean jokesBean);

    }

    interface Presneter extends BaseContract.BasePresenter<View>{

        void getJokes();

    }

}
