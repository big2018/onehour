package com.example.quarterhour.ui.details.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.bean.WorkInfoBean;
import com.example.quarterhour.ui.details.DetailsActivity;
import com.example.quarterhour.util.AddImg;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class DetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    List<WorkInfoBean.DataBean.WorksEntitiesBean> list;
    private LayoutInflater inflater;
    private View view;
    private List<ImageView> images;
    private String imgtx;
    private String username;
//    private ImageView imageView = null;
    private Handler handler = new Handler();

    public DetailsAdapter(Context context, List<WorkInfoBean.DataBean.WorksEntitiesBean> list,String imgtx,String username) {
        this.context = context;
        this.list = list;
        this.imgtx = imgtx;
        this.username = username;
        inflater = LayoutInflater.from(context);
        images = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.recyclerdetails_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final boolean[] flag = {true};
        final ViewHolder viewHolder = (ViewHolder) holder;

        WorkInfoBean.DataBean.WorksEntitiesBean data = list.get(position);

        viewHolder.simple_user.setImageURI(imgtx);

        viewHolder.tv_username.setTextColor(Color.RED);
        viewHolder.tv_username.setText(username);
        viewHolder.tv_createtime.setText(data.getCreateTime());
        viewHolder.tv_nr.setText("骑着猪上高速：  这妹子我见过");
        viewHolder.image_bj.setImageResource(R.drawable.add);
        viewHolder.image_bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"点击了编辑图片",Toast.LENGTH_SHORT).show();
                if (flag[0]){
                    viewHolder.image_bj.setImageResource(R.drawable.sub);
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(viewHolder.image_bj, "rotation", 180f, 0f);
                    rotation.setDuration(500);
                    rotation.start();
                    AddImg.addImg(context,true,viewHolder.ll,R.drawable.heart,-100f,images,handler);
                    AddImg.addImg(context,true,viewHolder.ll,R.drawable.share,-200f,images,handler);
                    AddImg.addImg(context,true,viewHolder.ll,R.drawable.comment,-300f,images,handler);
                    flag[0] = !flag[0];
                }else {

                    viewHolder.image_bj.setImageResource(R.drawable.add);
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(viewHolder.image_bj, "rotation", 180f, 360f);
                    rotation.setDuration(500);
                    rotation.start();
                    AddImg.addImg(context,false,viewHolder.ll,R.drawable.heart,-100f,images,handler);
                    AddImg.addImg(context,false,viewHolder.ll,R.drawable.share,-200f,images,handler);
                    AddImg.addImg(context,false,viewHolder.ll,R.drawable.comment,-300f,images,handler);
                    flag[0] = !flag[0];

                }


            }
        });

        viewHolder.videoplayer.setUp(list.get(position).getVideoUrl(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"谁还不是小仙女呢！");
//        Glide.with(context).load(cover).into(holder.getVideoplayer().thumbImageView);
        Glide.with(context).load("https://www.zhaoapi.cn/images/1516841991537timg.jpg").into(viewHolder.videoplayer.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView simple_user;
        private TextView tv_username;
        private TextView tv_createtime;
        private ImageView image_bj;
        private TextView tv_nr;
        private RelativeLayout ll;
        private JZVideoPlayerStandard videoplayer;


        public ViewHolder(View itemView) {
            super(itemView);
            simple_user = itemView.findViewById(R.id.simple_user);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_createtime = itemView.findViewById(R.id.tv_createtime);
            image_bj = itemView.findViewById(R.id.image_bj);
            tv_nr = itemView.findViewById(R.id.tv_nr);
            ll = itemView.findViewById(R.id.ll);
            videoplayer = itemView.findViewById(R.id.videoplayer);

        }
    }


}
