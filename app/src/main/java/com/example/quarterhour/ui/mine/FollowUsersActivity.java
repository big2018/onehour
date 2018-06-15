package com.example.quarterhour.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.FollowUsersBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.details.DetailsActivity;
import com.example.quarterhour.ui.mine.adapter.RvFollowAdapter;
import com.example.quarterhour.ui.mine.contract.FollowContract;
import com.example.quarterhour.ui.mine.presenter.FollowPresenter;
import com.example.quarterhour.util.SpUtil;

import java.util.List;

public class FollowUsersActivity extends BaseActivity<FollowPresenter> implements FollowContract.View {

    private RecyclerView rv_followuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_users);
        initView();
        mPresenter.getFollowUsers(SpUtil.getString(this,"uid",""),SpUtil.getString(this,"token",""));
    }

    private void initView() {
        rv_followuser = (RecyclerView) findViewById(R.id.rv_followuser);
        rv_followuser.setLayoutManager(new LinearLayoutManager(this));
        rv_followuser.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_follow_users;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void showFollowUsers(List<FollowUsersBean.DataBean> dataBeans) {
        if (dataBeans!= null) {
            RvFollowAdapter rvFollowAdapter = new RvFollowAdapter(dataBeans, this);
            rv_followuser.setAdapter(rvFollowAdapter);

            rvFollowAdapter.setOnItemClickListener(new RvFollowAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Intent intent = new Intent(FollowUsersActivity.this, DetailsActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


}
