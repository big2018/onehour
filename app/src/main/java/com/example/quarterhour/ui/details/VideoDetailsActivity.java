package com.example.quarterhour.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.VideosBean;
import com.facebook.drawee.view.SimpleDraweeView;

import cn.jzvd.JZVideoPlayerStandard;

public class VideoDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgFh;
    private ImageView mImgXh;
    private ImageView mImgTy;
    private ImageView mImgFx;
    private SimpleDraweeView mSimpleTx;
    private JZVideoPlayerStandard mPlayer;
    private TextView mTvJs;
    private TextView mTvTime;
    private boolean xhbool = true;
    private boolean tybool = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        initView();

        Intent intent = getIntent();
        VideosBean.DataBean dataBean = (VideosBean.DataBean) intent.getSerializableExtra("videosbean");

        mSimpleTx.setImageURI(dataBean.getUser().getIcon());
        mPlayer.setUp(dataBean.getVideoUrl(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,dataBean.getWorkDesc());
        Glide.with(this).load(dataBean.getVideoUrl()).into(mPlayer.thumbImageView);

        mTvJs.setText(dataBean.getWorkDesc());
        mTvTime.setText(dataBean.getPlayNum()+"次播放    "+dataBean.getCreateTime());

    }

    private void initView() {
        mImgFh = (ImageView) findViewById(R.id.img_fh);
        mImgFh.setOnClickListener(this);
        mImgXh = (ImageView) findViewById(R.id.img_xh);
        mImgXh.setOnClickListener(this);
        mImgTy = (ImageView) findViewById(R.id.img_ty);
        mImgTy.setOnClickListener(this);
        mImgFx = (ImageView) findViewById(R.id.img_fx);
        mImgFx.setOnClickListener(this);
        mSimpleTx = (SimpleDraweeView) findViewById(R.id.simple_tx);
        mSimpleTx.setOnClickListener(this);
        mPlayer = (JZVideoPlayerStandard) findViewById(R.id.player);
        mTvJs = (TextView) findViewById(R.id.tv_js);
        mTvTime = (TextView) findViewById(R.id.tv_time);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;

            case R.id.img_fh:
                VideoDetailsActivity.this.finish();
                break;

            case R.id.img_xh:
                if (xhbool){
                    mImgXh.setImageResource(R.drawable.raw1499933215);
                    xhbool = !xhbool;
                }else {
                    mImgXh.setImageResource(R.drawable.raw_1499933216);
                    xhbool = !xhbool;
                }
                break;

            case R.id.img_ty:
                if (tybool){
                    mImgTy.setImageResource(R.drawable.raw499933216);
                    tybool = !tybool;
                }else {
                    mImgTy.setImageResource(R.drawable.raw_1499933217);
                    tybool = !tybool;
                }
                break;

            case R.id.simple_tx:
                Intent intent = new Intent(VideoDetailsActivity.this,DetailsActivity.class);
                startActivity(intent);
                break;

            case R.id.img_fx:
                break;
        }
    }
}
