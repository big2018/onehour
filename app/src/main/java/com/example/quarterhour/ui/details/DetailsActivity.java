package com.example.quarterhour.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.WorkInfoBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.details.adapter.DetailsAdapter;
import com.example.quarterhour.ui.details.contract.DetailsContract;
import com.example.quarterhour.ui.details.presenter.DetailsPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsContract.View, View.OnClickListener {

    private SimpleDraweeView mSimpleTx;
    /**
     * 作品（3）
     */
    private TextView mTvNum;
    private ImageView img;
    private RecyclerView mRecyclerWorkinfo;
    private SimpleDraweeView mSimpleBackgroud;
    private String imgurl = "https://www.zhaoapi.cn/images/quarter/1515587806806151496296995.jpg";
    private String uid = "71";
    private String token = "FE74BBCA3513EA66C47D308B65B4E0B3";
    private int num = 0;
    private ImageView mImgGz;
    private ImageView mSimpleDz;
    private TextView mTvUser;
    private ImageView mImgReturn;
    private ImageView mImgMessage;
    private boolean flag = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        int uids = intent.getIntExtra("uid", 0);
        if (uids==0){
            uid=71+"";
        }else {
            uid=uids+"";
        }
        initView();
        mPresenter.getWorkInfo(this.uid, token);
    }

    private void initView() {
        mSimpleTx = (SimpleDraweeView) findViewById(R.id.simple_tx);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        img = (ImageView) findViewById(R.id.simple_dz);
        img.setOnClickListener(this);
        mRecyclerWorkinfo = (RecyclerView) findViewById(R.id.recycler_workinfo);
        mRecyclerWorkinfo.setLayoutManager(new LinearLayoutManager(this));
        mSimpleBackgroud = (SimpleDraweeView) findViewById(R.id.simple_backgroud);
        mSimpleBackgroud.setImageURI(imgurl);
        mImgGz = (ImageView) findViewById(R.id.img_gz);
        mImgGz.setOnClickListener(this);
        mSimpleDz = (ImageView) findViewById(R.id.simple_dz);
        mTvUser = (TextView) findViewById(R.id.tv_user);
        mImgReturn = (ImageView) findViewById(R.id.img_return);
        mImgReturn.setOnClickListener(this);
        mImgMessage = (ImageView) findViewById(R.id.img_message);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void getWorkInfoSuccess(WorkInfoBean workInfoBean) {
        WorkInfoBean.DataBean.UserBean data = workInfoBean.getData().getUser();
        mSimpleTx.setImageURI(data.getIcon());
        mTvUser.setText(data.getNickname());

        List<WorkInfoBean.DataBean.WorksEntitiesBean> list = workInfoBean.getData().getWorksEntities();
        DetailsAdapter adapter = new DetailsAdapter(DetailsActivity.this,list,data.getIcon(),data.getNickname());
        mRecyclerWorkinfo.setAdapter(adapter);
        mTvNum.setText("作品（"+list.size()+"）");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.simple_dz:

                if (num == 0) {
                    img.setImageResource(R.drawable.dz2);
                    num += 1;
                } else if (num == 1) {
                    img.setImageResource(R.drawable.dz3);
                    num += 1;
                } else if (num == 2) {
                    img.setImageResource(R.drawable.dz4);
                    num += 1;
                } else {
                    return;
                }

                break;

            case R.id.img_gz:
                if (flag) {
                    mImgGz.setImageResource(R.drawable.gz2);
                    flag = !flag;
                }else {
                    mImgGz.setImageResource(R.drawable.gz1);
                    flag = !flag;
                }
                break;

            case R.id.img_return:
                DetailsActivity.this.finish();
                break;
        }
    }
}
