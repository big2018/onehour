package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quarterhour.MainActivity;
import com.example.quarterhour.R;
import com.example.quarterhour.ui.details.VideoDetailsActivity;

public class IssueSuccessActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 发表成功，快分享给好友捧场吧~！
     */
    private TextView mSss;
    private LinearLayout mLlIssue;
    /**
     * 前去看看！！！
     */
    private TextView mTiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_success);
        initView();
    }

    private void initView() {
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mSss = (TextView) findViewById(R.id.sss);
        mLlIssue = (LinearLayout) findViewById(R.id.ll_issue);
        mTiao = (TextView) findViewById(R.id.tiao);
        mTiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                Intent intent = new Intent(IssueSuccessActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tiao:
                Intent intent1 = new Intent(IssueSuccessActivity.this, VideoDetailsActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }
}
