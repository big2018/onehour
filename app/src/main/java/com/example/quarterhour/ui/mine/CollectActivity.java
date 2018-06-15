package com.example.quarterhour.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.mine.adapter.RvCollectAdapter;
import com.example.quarterhour.ui.mine.contract.CollectContract;
import com.example.quarterhour.ui.mine.presenter.CollectPresenter;
import com.example.quarterhour.util.SpUtil;

import java.util.List;

import cn.jzvd.JZVideoPlayer;

public class CollectActivity extends BaseActivity<CollectPresenter> implements CollectContract.View {


    private RecyclerView rv_collect;
    /**
     * 删除
     */
    private TextView tv_delete;
    private RvCollectAdapter rvCollectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mPresenter.getCollect(SpUtil.getString(this,"uid",""),SpUtil.getString(this,"token",""));
    }

    private void initView() {
        rv_collect = (RecyclerView) findViewById(R.id.rv_collect);
        rv_collect.setLayoutManager(new LinearLayoutManager(this));
        tv_delete = (TextView) findViewById(R.id.tv_delete);
        //删除的监听
        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_collect;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void showCollect(CollectBean collectBean) {
        if (collectBean.getCode().equals("0")) {
            List<CollectBean.DataBean> data = collectBean.getData();
            RvCollectAdapter rvCollectAdapter = new RvCollectAdapter(data, this);
            rv_collect.setAdapter(rvCollectAdapter);
        }
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

}
