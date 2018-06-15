package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.quarterhour.R;
import com.example.quarterhour.ui.issue.adapter.IssueVideoAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.internal.Utils;

public class SeeIssueVideoActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView mVideoview;
    /**
     * 返回
     */
    private TextView mTvSeeiussreturn;
    /**
     * 保存到本地
     */
    private TextView mTvBc;
    private RecyclerView mRecyclerSeeissue;
    /**
     * 下一步
     */
    private TextView mTvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_issue_video);
        initView();

        String videoUrl1 = Environment.getExternalStorageDirectory().getPath()+"/love.3gp" ;


        Uri uri = Uri.parse( videoUrl1 );

        mVideoview = (VideoView)this.findViewById(R.id.videoview );

        //设置视频控制器
        mVideoview.setMediaController(new MediaController(this));

        //设置视频路径
        mVideoview.setVideoURI(uri);

        //开始播放视频
        mVideoview.start();


    }

    private void initView() {
        mVideoview = (VideoView) findViewById(R.id.videoview);
        mTvSeeiussreturn = (TextView) findViewById(R.id.tv_seeiussreturn);
        mTvSeeiussreturn.setOnClickListener(this);
        mTvBc = (TextView) findViewById(R.id.tv_bc);
        mTvBc.setOnClickListener(this);
        mRecyclerSeeissue = (RecyclerView) findViewById(R.id.recycler_seeissue);
        mRecyclerSeeissue.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 4 ; i++ )
            list.add("原色");
        mRecyclerSeeissue.setAdapter(new IssueVideoAdapter(this,list));

        mTvNext = (TextView) findViewById(R.id.tv_next);
        mTvNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_seeiussreturn:
                finish();
                break;
            case R.id.tv_bc:
                Intent intent = new Intent(SeeIssueVideoActivity.this,SaveVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_next:
                Intent intent1 = new Intent(SeeIssueVideoActivity.this,IssueVActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
