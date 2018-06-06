package com.example.quarterhour;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.quarterhour.ui.jokes.fragment.JokeFragment;
import com.example.quarterhour.ui.recommend.fragment.RecommendFragment;
import com.example.quarterhour.util.BottomBar;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame_layout;
    private BottomBar bottom_bar;
    private ImageView img_tou;
    /**
     * Android Studio
     */
    private TextView tv_username;
    private DrawerLayout drawer_layout;
    private ImageView mImageView;
    private LinearLayout liner;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        //设置监听
        bottom_bar.setContainer(R.id.frame_layout)
                .setTitleBeforeAndAfterColor("#BFBFBF", "#1296DB")
                .setTitleSize(15)
                .setIconWidth(30)
                .setIconHeight(30)
                .addItem(RecommendFragment.class, "推荐", R.drawable.raw_1500083878, R.drawable.raw_1500085367)
                .addItem(JokeFragment.class, "段子", R.drawable.raw_1500085327, R.drawable.raw_1500085899)
                .addItem(RecommendFragment.class, "视频", R.drawable.raw_1500083686, R.drawable.raw_1500086067)
                .build();
    }

    private void initView() {
        frame_layout = (FrameLayout) findViewById(R.id.frame_layout);
        bottom_bar = (BottomBar) findViewById(R.id.bottom_bar);
        img_tou = (ImageView) findViewById(R.id.img_tou);
        tv_username = (TextView) findViewById(R.id.tv_username);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mImageView = (ImageView) findViewById(R.id.imageView);
        liner = (LinearLayout) findViewById(R.id.liner);
    }

    private void initData() {
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this).load("http://p1.wmpic.me/article/2016/01/15/1452846717_StlCYymF.jpg").apply(requestOptions).into(mImageView);
        Glide.with(this).load("http://p1.wmpic.me/article/2016/01/15/1452846717_StlCYymF.jpg").apply(requestOptions).into(img_tou);
        //设置监听
        img_tou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(liner);
            }
        });
    }

}
