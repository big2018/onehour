package com.example.quarterhour.ui.mine.contract;

import com.example.quarterhour.bean.SearchFriBean;
import com.example.quarterhour.ui.base.BaseContract;

public interface SearchFriContract {

    interface View extends BaseContract.BaseView{
        void showFri(SearchFriBean searchFriBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void searchFri(String keywords);
    }

}
