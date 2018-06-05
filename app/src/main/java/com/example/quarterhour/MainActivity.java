package com.example.quarterhour;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.quarterhour.ui.recommend.fragment.RecommendFragment;
import com.example.quarterhour.util.BottomBar;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame_layout;
    private BottomBar bottom_bar;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //设置监听
        bottom_bar.setContainer(R.id.frame_layout)
                .setTitleBeforeAndAfterColor("#BFBFBF", "#1296DB")
                .setTitleSize(15)
                .setIconWidth(30)
                .setIconHeight(30)
                .addItem(RecommendFragment.class, "推荐",R.drawable.raw_1500083878,R.drawable.raw_1500085367)
                .addItem(RecommendFragment.class, "段子",R.drawable.raw_1500085327,R.drawable.raw_1500085899)
                .addItem(RecommendFragment.class, "视频",R.drawable.raw_1500083686,R.drawable.raw_1500086067)
                .build();
    }

    private void initView() {
        frame_layout = (FrameLayout) findViewById(R.id.frame_layout);
        bottom_bar = (BottomBar) findViewById(R.id.bottom_bar);
    }
}
