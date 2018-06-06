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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.AdBean;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.ui.base.BaseFragment;
import com.example.quarterhour.ui.recommend.adapter.Rv_jokeAdapter;
import com.example.quarterhour.ui.recommend.contract.RecommendContract;
import com.example.quarterhour.ui.recommend.presenter.RecommendPresenter;
import com.youth.banner.Banner;

import java.util.List;

public class GuanZhuFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View{

    private ImageView img_banner;
    private RecyclerView rv_gz;

    @Override
    public int getContentLayout() {
        return R.layout.frag_guanzhu;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        img_banner = (ImageView) view.findViewById(R.id.img_banner);
        rv_gz = (RecyclerView) view.findViewById(R.id.rv_gz);
        rv_gz.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPresenter.getJokes();
    }

    @Override
    public void showAd(AdBean adBean) {

    }

    @Override
    public void showJokes(JokesBean jokesBean) {
        List<JokesBean.DataBean> data = jokesBean.getData();
        Rv_jokeAdapter rv_jokeAdapter = new Rv_jokeAdapter(data, getActivity());
        rv_gz.setAdapter(rv_jokeAdapter);
//jhjhk
    }
}
