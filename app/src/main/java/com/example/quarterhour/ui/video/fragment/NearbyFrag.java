package com.example.quarterhour.ui.video.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.base.BaseFragment;
import com.example.quarterhour.ui.video.adapter.PubuAdapter;
import com.example.quarterhour.ui.video.contract.NearbyContract;
import com.example.quarterhour.ui.video.presenter.NearbyPresenter;

import java.util.ArrayList;
import java.util.List;

public class NearbyFrag extends BaseFragment<NearbyPresenter> implements NearbyContract.View {

    private RecyclerView hot_recycler;
    private String token = "FE74BBCA3513EA66C47D308B65B4E0B3";

    @Override
    public int getContentLayout() {
        return R.layout.hot;
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
        hot_recycler = view.findViewById(R.id.hot_recycler);
        hot_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        mPresenter.getNearVideos(token);
    }

    @Override
    public void getNearVideosSuccess(VideosBean nearVideosBean) {
        if (nearVideosBean.getCode().equals("0")) {
            List<VideosBean.DataBean> data = nearVideosBean.getData();
            List<Integer> heights = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                heights.add((int) (100 + Math.random() * 300));
            }
            PubuAdapter adapter = new PubuAdapter(getActivity(), data, heights);
            hot_recycler.setAdapter(adapter);
        }
    }
}
