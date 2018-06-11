package com.example.quarterhour;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.quarterhour.ui.issue.IssueActivity;
import com.example.quarterhour.ui.jokes.fragment.JokeFragment;

import com.example.quarterhour.ui.login.LoginActivity;
import com.example.quarterhour.ui.mine.CollectActivity;
import com.example.quarterhour.ui.mine.FollowUsersActivity;
import com.example.quarterhour.ui.recommend.fragment.RecommendFragment;
import com.example.quarterhour.ui.video.fragment.VideoFragment;
import com.example.quarterhour.util.BottomBar;
import com.example.quarterhour.util.SpUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout frame_layout;
    private BottomBar bottom_bar;
    private ImageView img_tou;
    /**
     * Android Studio
     */
    private TextView tv_username;
    private DrawerLayout drawer_layout;
    private ImageView imageView_tou;
    private LinearLayout liner;
    private LinearLayout right;
    private RelativeLayout rl_follow;
    private RelativeLayout rl_shou;
    private RelativeLayout rl_search;
    private ImageView mImgTou;
    private ImageView mImgBianji;
    private FrameLayout mFrameLayout;
    private BottomBar mBottomBar;
    private LinearLayout mRight;
    /**
     * Android Studio
     */
    private TextView mTvUsername;
    /**
     * 编辑个性签名
     */
    private TextView mTextView;
    private ImageView mIg;
    private ImageView mIg0;
    private ImageView mIg1;
    private ImageView mIg2;
    private LinearLayout mLiner;
    private DrawerLayout mDrawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }else {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
        }

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
                .addItem(VideoFragment.class, "视频", R.drawable.raw_1500083686, R.drawable.raw_1500086067)
                .build();
    }

    private void initView() {
        frame_layout = (FrameLayout) findViewById(R.id.frame_layout);
        bottom_bar = (BottomBar) findViewById(R.id.bottom_bar);
        img_tou = (ImageView) findViewById(R.id.img_tou);
        tv_username = (TextView) findViewById(R.id.tv_username);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        imageView_tou = (ImageView) findViewById(R.id.imageView_tou);
        liner = (LinearLayout) findViewById(R.id.liner);
        right = (LinearLayout) findViewById(R.id.right);
        rl_follow = (RelativeLayout) findViewById(R.id.rl_follow);
        rl_shou = (RelativeLayout) findViewById(R.id.rl_shou);
        rl_search = (RelativeLayout) findViewById(R.id.rl_search);
        mImgBianji = (ImageView) findViewById(R.id.img_bianji);

        //侧拉的监听
        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                right.layout(liner.getRight(), 0, liner.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        //点击头像跳转登录的监听
        imageView_tou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //跳转到关注用户的列表
        rl_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FollowUsersActivity.class);
                startActivity(intent);
            }
        });

        //跳转到收藏页面
        rl_shou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CollectActivity.class);
                startActivity(intent);
            }
        });

        mImgBianji.setOnClickListener(this);

    }

    private void initData() {
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this).load("http://p1.wmpic.me/article/2016/01/15/1452846717_StlCYymF.jpg").apply(requestOptions).into(imageView_tou);
        Glide.with(this).load("http://p1.wmpic.me/article/2016/01/15/1452846717_StlCYymF.jpg").apply(requestOptions).into(img_tou);
        //设置监听
        img_tou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(liner);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = SpUtil.getString(this, "name", "");
        String iconurl = SpUtil.getString(this, "iconurl", "");
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(iconurl)){
            tv_username.setText(name);
            RequestOptions requestOptions = RequestOptions.circleCropTransform();
            Glide.with(this).load(iconurl).apply(requestOptions).into(imageView_tou);
            Glide.with(this).load(iconurl).apply(requestOptions).into(img_tou);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img_bianji:

                Intent intent = new Intent(MainActivity.this, IssueActivity.class);
                startActivity(intent);

                break;
        }
    }
}
