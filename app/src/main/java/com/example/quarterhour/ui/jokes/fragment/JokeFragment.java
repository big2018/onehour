package com.example.quarterhour.ui.jokes.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.base.BaseFragment;
import com.example.quarterhour.ui.jokes.adapter.DzAdapter;
import com.example.quarterhour.ui.jokes.contract.JokesContract;
import com.example.quarterhour.ui.jokes.presenter.JokesPresenter;


import java.util.List;

public class JokeFragment extends BaseFragment<JokesPresenter> implements JokesContract.View {

    private RecyclerView recyclerView;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_jokes;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_dz);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), RecyclerView.VERTICAL));

        mPresenter.getJokes();
    }

    @Override
    public void getJokesSuccess(JokesBean jokesBean) {
        List<JokesBean.DataBean> list = jokesBean.getData();
        DzAdapter adapter = new DzAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

    }
}
