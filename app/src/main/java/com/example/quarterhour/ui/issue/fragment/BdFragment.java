package com.example.quarterhour.ui.issue.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.BdVideoBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.base.BaseFragment;
import com.example.quarterhour.ui.issue.adapter.BdAdapter;
import com.example.quarterhour.ui.issue.contract.BdFragmentContract;
import com.example.quarterhour.ui.issue.presenter.BdFragmentPresenter;

import java.util.List;

public class BdFragment extends BaseFragment<BdFragmentPresenter> implements BdFragmentContract.View {

    private RecyclerView recyclerView;

    @Override
    public int getContentLayout() {
        return R.layout.bdfragment_layout;
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
        recyclerView = view.findViewById(R.id.recycler_bd);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mPresenter.getVideos();
    }

    @Override
    public void getVideosSuccess(BdVideoBean bdVideoBean) {
        List<BdVideoBean.DataBean> list = bdVideoBean.getData();
        BdAdapter adapter = new BdAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
    }
}
