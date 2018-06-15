package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.MainActivity;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.issue.contract.IssueJActivityContract;
import com.example.quarterhour.ui.issue.presenter.IssueJActivityPresenter;

public class IssueJActivity extends BaseActivity<IssueJActivityPresenter> implements IssueJActivityContract.View, View.OnClickListener {

    /**
     * 返回
     */
    private TextView mTvIssuejf;
    /**
     * 发表
     */
    private TextView mTvIssuejfb;
    /**
     * 请输入内容，禁止输入色情、暴力等违反国家法律的内容，违者将以封号处理
     */
    private EditText mEtIssuej;
    private String uid = "15162";
    private String token = "AE14621B95BC1C30DAD83E27B3993BF9";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.activity_issue_j);
        initView();

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_issue_j;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void publishJokeSuccess(BaseBean baseBean) {
        Toast.makeText(this,baseBean.getMsg(),Toast.LENGTH_SHORT).show();
        if (baseBean.getCode().equals("0")){
            Intent intent =new Intent(IssueJActivity.this,IssueSuccessActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initView() {
        mTvIssuejf = (TextView) findViewById(R.id.tv_issuejf);
        mTvIssuejf.setOnClickListener(this);
        mTvIssuejfb = (TextView) findViewById(R.id.tv_issuejfb);
        mTvIssuejfb.setOnClickListener(this);
        mEtIssuej = (EditText) findViewById(R.id.et_issuej);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_issuejf:
                Intent intent = new Intent(IssueJActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_issuejfb:
                mPresenter.publishJoke(uid,token,mEtIssuej.getText().toString());
                break;
        }
    }
}
