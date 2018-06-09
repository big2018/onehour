package com.example.quarterhour.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quarterhour.MainActivity;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.VideosBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.editorpage.ShareActivity;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;

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
    private VideosBean.DataBean dataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        initView();

        Intent intent = getIntent();
        dataBean = (VideosBean.DataBean) intent.getSerializableExtra("videosbean");

        mSimpleTx.setImageURI(dataBean.getUser().getIcon());
        mPlayer.setUp(dataBean.getVideoUrl(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, dataBean.getWorkDesc()+"");
        Glide.with(this).load(dataBean.getVideoUrl()).into(mPlayer.thumbImageView);

        mTvJs.setText(dataBean.getWorkDesc());
        mTvTime.setText(dataBean.getPlayNum()+"次播放    "+ dataBean.getCreateTime());

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
                if (tybool){
                    if (xhbool){
                        mImgXh.setImageResource(R.drawable.raw1499933215);
                        xhbool = !xhbool;
                    }else {
                        mImgXh.setImageResource(R.drawable.raw_1499933216);
                        xhbool = !xhbool;
                    }
                }else {

                }

                break;

            case R.id.img_ty:
                if(xhbool){
                    if (tybool){
                        mImgTy.setImageResource(R.drawable.raw499933216);
                        tybool = !tybool;
                    }else {
                        mImgTy.setImageResource(R.drawable.raw_1499933217);
                        tybool = !tybool;
                    }
                }else {

                }

                break;

            case R.id.simple_tx:
                Intent intent = new Intent(VideoDetailsActivity.this,DetailsActivity.class);
                startActivity(intent);
                break;

            case R.id.img_fx:
//                UMWeb web = new UMWeb(dataBean.getVideoUrl());,SHARE_MEDIA.WEIXIN
                UMVideo video = new UMVideo(dataBean.getVideoUrl());
                new ShareAction(VideoDetailsActivity.this).withMedia(video).setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(shareListener).open();
//                new ShareAction(VideoDetailsActivity.this)
//                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
//                        .withText("hello")//分享内容
//                        .withMedia(video)
//                        .setCallback(shareListener)//回调监听器
//                        .share();
//                new ShareAction(VideoDetailsActivity.this).withText("hello").withMedia(video).share();
                break;
        }
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(VideoDetailsActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VideoDetailsActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(VideoDetailsActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }



}
