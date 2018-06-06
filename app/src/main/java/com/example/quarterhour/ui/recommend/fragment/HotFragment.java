package com.example.quarterhour.ui.recommend.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;

import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.ui.base.BaseFragment;
import com.example.quarterhour.ui.recommend.adapter.Rv_jokeAdapter;
import com.example.quarterhour.ui.recommend.contract.RecommendContract;
import com.example.quarterhour.ui.recommend.presenter.RecommendPresenter;
import com.example.quarterhour.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {
    private View view;
    private Banner my_banner;
    private RecyclerView rv_hot;

    @Override
    public int getContentLayout() {
        return R.layout.frag_hot;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        my_banner = (Banner) view.findViewById(R.id.my_banner);
        rv_hot = (RecyclerView) view.findViewById(R.id.rv_hot);
        my_banner.setImageLoader(new GlideImageLoader());
        mPresenter.getAd();
        mPresenter.getJokes();
        rv_hot.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    public void showAd(AdBean adBean) {
        List<AdBean.DataBean> data = adBean.getData();
        List<String> list_string = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            list_string.add(data.get(i).getIcon());
        }
        my_banner.setImages(list_string);
        my_banner.start();
    }

    @Override
    public void showJokes(JokesBean jokesBean) {
        List<JokesBean.DataBean> data = jokesBean.getData();
        Rv_jokeAdapter rv_jokeAdapter = new Rv_jokeAdapter(data, getActivity());
        rv_hot.setAdapter(rv_jokeAdapter);
    }
}
