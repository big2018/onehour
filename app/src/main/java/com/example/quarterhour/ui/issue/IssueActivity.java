package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quarterhour.R;

public class IssueActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 取消
     */
    private TextView mTvCancel;
    private ImageView mImgSp;
    private ImageView mImgDz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        initView();
    }

    private void initView() {
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(this);
        mImgSp = (ImageView) findViewById(R.id.img_sp);
        mImgSp.setOnClickListener(this);
        mImgDz = (ImageView) findViewById(R.id.img_dz);
        mImgDz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_cancel:

                IssueActivity.this.finish();

                break;
            case R.id.img_sp:

                Intent intent = new Intent(IssueActivity.this,IssueVideoActivity.class);
                startActivity(intent);

                break;
            case R.id.img_dz:



                break;
        }
    }
}
