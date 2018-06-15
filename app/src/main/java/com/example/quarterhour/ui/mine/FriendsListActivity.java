package com.example.quarterhour.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.SearchFriBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.mine.adapter.RvFriAdapter;
import com.example.quarterhour.ui.mine.contract.SearchFriContract;
import com.example.quarterhour.ui.mine.presenter.SearchFriPresenter;

import java.util.List;

public class FriendsListActivity extends BaseActivity<SearchFriPresenter> implements SearchFriContract.View {

    private RecyclerView rv_friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        Intent intent = getIntent();
        String keywords = intent.getStringExtra("keywords");
        mPresenter.searchFri(keywords);
    }

    private void initView() {
        rv_friends = (RecyclerView) findViewById(R.id.rv_friends);
        rv_friends.setLayoutManager(new LinearLayoutManager(this));
        rv_friends.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_friends_list;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void showFri(SearchFriBean searchFriBean) {
        List<SearchFriBean.DataBean> data = searchFriBean.getData();
        RvFriAdapter rvFriAdapter = new RvFriAdapter(data, this);
        rv_friends.setAdapter(rvFriAdapter);
    }
}
