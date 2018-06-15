package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quarterhour.MainActivity;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.BaseBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.issue.contract.IssueVContract;
import com.example.quarterhour.ui.issue.presenter.IssueVPresenter;

import java.io.File;

public class IssueVActivity extends BaseActivity<IssueVPresenter> implements View.OnClickListener,IssueVContract.View {

    private ImageView fm;
    /**
     * 返回
     */
    private TextView mTvIssuef;
    private LinearLayout mLlShare;
    private ImageView mImgSuo;
    /**
     * 点击输入视频简介..
     */
    private TextView mTvIssuejs;
    /**
     * 发布
     */
    private TextView mTvIssuenext;
    private String imgfile;
    private String videofile;
    private String latitude = "39.1";
    private String longitude = "32.1";
    private String uid = "15162";
    private String token = "AE14621B95BC1C30DAD83E27B3993BF9";
    private boolean suo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_issue_v);
        initView();

        videofile = Environment.getExternalStorageDirectory().getPath()+"/love.3gp";
        imgfile = Environment.getExternalStorageDirectory().getPath()+"/1.jpg";
//        String path2 = "/sdcard/1.jpg";
        File file = new File(imgfile);
        if (file.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgfile);
            fm.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this,"文件没有找到",Toast.LENGTH_SHORT).show();
        }

    }

    private void initView() {
        mTvIssuef = (TextView) findViewById(R.id.tv_issuef);
        mTvIssuef.setOnClickListener(this);
        mLlShare = (LinearLayout) findViewById(R.id.ll_share);
        mImgSuo = (ImageView) findViewById(R.id.img_suo);
        mImgSuo.setOnClickListener(this);
        mTvIssuejs = (TextView) findViewById(R.id.tv_issuejs);
        mTvIssuenext = (TextView) findViewById(R.id.tv_issuenext);
        mTvIssuenext.setOnClickListener(this);
        fm = (ImageView) findViewById(R.id.fm);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_issuef:

                Intent intent = new Intent(IssueVActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.tv_issuenext:

                mPresenter.publishVideo(uid,videofile,imgfile,latitude,longitude,token,"android","101");

                break;

            case R.id.img_suo:

                if (suo){
                    mImgSuo.setImageResource(R.drawable.suoclose);
                    suo = !suo;
                }else {
                    mImgSuo.setImageResource(R.drawable.suoopen);
                    suo = !suo;
                }

                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_issue_v;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void publishVideoSuccess(BaseBean s) {
        Toast.makeText(this,s.getMsg(),Toast.LENGTH_SHORT).show();
        if (s.getCode().equals("0")){
            Intent intent = new Intent(IssueVActivity.this,IssueSuccessActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
