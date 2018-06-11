package com.example.quarterhour.ui.mine.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.quarterhour.R;
import com.example.quarterhour.bean.FollowUsersBean;

import java.util.List;

public class RvFollowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FollowUsersBean.DataBean> list;
    private Context context;
    private final LayoutInflater inflater;

    public RvFollowAdapter(List<FollowUsersBean.DataBean> dataBeans, Context context) {
        this.list = dataBeans;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.rv_followitem, parent, false);
        FollowViewHolder followViewHolder=new FollowViewHolder(inflate);
        return followViewHolder;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        FollowViewHolder followViewHolder= (FollowViewHolder) holder;
        followViewHolder.tv_time.setText(list.get(position).getCreatetime());
        followViewHolder.tv_username.setText(list.get(position).getUsername());
        if (list.get(position).getIcon()!=null){
            RequestOptions requestOptions = RequestOptions.circleCropTransform();
            Glide.with(context).load(list.get(position).getIcon()).apply(requestOptions).into(followViewHolder.img_head);
        }else {
            RequestOptions requestOptions = RequestOptions.circleCropTransform();
            Glide.with(context).load("http://img.zcool.cn/community/013e2c59dc8e95a801204463df7c92.jpg@1280w_1l_2o_100sh.jpg").apply(requestOptions).into(followViewHolder.img_head);
        }

        followViewHolder.layout_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        ImageView img_head;
        TextView tv_username;
        TextView tv_time;
        LinearLayout layout_follow;

        public FollowViewHolder(View itemView) {
            super(itemView);
            this.layout_follow=(LinearLayout) itemView.findViewById(R.id.layout_follow);
            this.img_head = (ImageView) itemView.findViewById(R.id.img_head);
            this.tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            this.tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
