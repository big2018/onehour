package com.example.quarterhour.ui.mine.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.CollectBean;
import com.example.quarterhour.ui.details.DetailsActivity;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class RvCollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CollectBean.DataBean> list;
    private Context context;
    private final LayoutInflater inflater;

    public RvCollectAdapter(List<CollectBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_collectitem, parent, false);
        CollectViewHolder collectViewHolder=new CollectViewHolder(view);
        return collectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        CollectViewHolder collectViewHolder= (CollectViewHolder) holder;
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).getUser().getIcon()).apply(requestOptions).into(collectViewHolder.img);
        collectViewHolder.tv_name.setText(list.get(position).getUser().getNickname());
        collectViewHolder.tv_time.setText(list.get(position).getCreateTime());
        collectViewHolder.tv_title.setText(list.get(position).getWorkDesc());
        String videoUrl = list.get(position).getVideoUrl();
        collectViewHolder.jz_video.setUp(videoUrl,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,list.get(position).getWorkDesc());
        Glide.with(context).load(Uri.parse(list.get(position).getCover())).into(collectViewHolder.jz_video.thumbImageView);

        collectViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                int uid = list.get(position).getUid();
                intent.putExtra("uid",uid);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class CollectViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv_name;
        TextView tv_time;
        TextView tv_title;
        JZVideoPlayerStandard jz_video;

        public CollectViewHolder(View view) {
            super(view);
            this.img = (ImageView) view.findViewById(R.id.img);
            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            this.jz_video = (JZVideoPlayerStandard) view.findViewById(R.id.jz_video);
        }
    }
}
