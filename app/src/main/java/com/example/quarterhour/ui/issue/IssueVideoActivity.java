package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.ui.issue.adapter.IssueVideoAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IssueVideoActivity extends AppCompatActivity implements View.OnClickListener,SurfaceHolder.Callback{

    private SurfaceView mSurfaceview;
    private ImageView mImgFm;
    private RecyclerView mRecycleLvjing;
    private ImageView mImgStartandstop;
    File videoFile ;
    private MediaRecorder mediarecorder;
    // 记录是否正在进行录制
    private boolean isRecording = false;
    private SurfaceHolder surfaceHolder;
    private TextView tv_issuecanle;
    private boolean imgbool = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_video);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        initView();
        // 设置分辨率
        mSurfaceview.getHolder().setFixedSize(1280, 720);
        // 设置该组件让屏幕不会自动关闭
        mSurfaceview.getHolder().setKeepScreenOn(true);
        imgbool = !imgbool;

    }

    private void initView() {
        mSurfaceview = (SurfaceView) findViewById(R.id.surfaceview);
        SurfaceHolder holder = mSurfaceview.getHolder();
        holder.addCallback(this); // holder加入回调接口
        // setType必须设置，要不出错.
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        mImgFm = (ImageView) findViewById(R.id.img_fm);
        mRecycleLvjing = (RecyclerView) findViewById(R.id.recycle_lvjing);
        mRecycleLvjing.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i++)
            list.add("原色");
        mRecycleLvjing.setAdapter(new IssueVideoAdapter(this,list));

        mImgStartandstop = (ImageView) findViewById(R.id.img_startandstop);
        mImgStartandstop.setOnClickListener(this);

        tv_issuecanle = (TextView) findViewById(R.id.tv_issuecanle);
        tv_issuecanle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!isRecording){
            mImgFm.setVisibility(View.GONE);
            if (!Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED))
            {
                Toast.makeText(IssueVideoActivity.this
                        , "SD卡不存在，请插入SD卡！"
                        , Toast.LENGTH_SHORT).show();
                return;
            }
            mediarecorder = new MediaRecorder();// 创建mediarecorder对象
            // 设置录制视频源为Camera(相机)
            mediarecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            // 设置录制完成后视频的封装格式THREE_GPP为3gp.MPEG_4为mp4
            mediarecorder
                    .setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            // 设置录制的视频编码h263 h264
            mediarecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
            // 设置视频录制的分辨率。必须放在设置编码和格式的后面，否则报错
            mediarecorder.setVideoSize(176, 144);
            // 设置录制的视频帧率。必须放在设置编码和格式的后面，否则报错
            mediarecorder.setVideoFrameRate(20);
            mediarecorder.setPreviewDisplay(surfaceHolder.getSurface());
            // 设置视频文件输出的路径
            mediarecorder.setOutputFile("/sdcard/love.3gp");
            try {
                // 准备录制
                mediarecorder.prepare();
                // 开始录制
                mediarecorder.start();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            isRecording = !isRecording;
        }else {
            if (isRecording)
            {
                if (mediarecorder != null) {
                    // 停止录制
                    mediarecorder.stop();
                    // 释放资源
                    mediarecorder.release();
                    mediarecorder = null;
                    isRecording = !isRecording;
                    Intent intent = new Intent(IssueVideoActivity.this,SeeIssueVideoActivity.class);
                    startActivity(intent);

//                    finish();
                }
            }
        }
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        imgbool = !imgbool;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (imgbool) {
            mImgFm.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceHolder = holder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        surfaceHolder = holder;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mSurfaceview = null;
        surfaceHolder = null;
        mediarecorder = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediarecorder != null){
            mediarecorder.stop();
            mediarecorder.release();
            mediarecorder = null;
        }
    }
}
