package com.example.quarterhour.ui.mine.adapter;

import android.content.Context;
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
import com.example.quarterhour.bean.SearchFriBean;

import java.util.List;

public class RvFriAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SearchFriBean.DataBean> list;
    private Context context;
    private final LayoutInflater inflater;

    public RvFriAdapter(List<SearchFriBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_fri_item, parent, false);
        FriViewHolder friViewHolder=new FriViewHolder(view);
        return friViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FriViewHolder friViewHolder= (FriViewHolder) holder;
        friViewHolder.tv_name.setText(list.get(position).getNickname());
        String icon = list.get(position).getIcon();
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        if (icon==null){
            Glide.with(context).load("http://img3.redocn.com/tupian/20150318/keaichangjinglukongbaipaizihanguochahua_4024842.jpg").apply(requestOptions).into(friViewHolder.img_fri);
        }else {
            Glide.with(context).load(icon).apply(requestOptions).into(friViewHolder.img_fri);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FriViewHolder extends RecyclerView.ViewHolder{
        ImageView img_fri;
        TextView tv_name;

        public FriViewHolder(View itemView) {
            super(itemView);
            this.img_fri = (ImageView) itemView.findViewById(R.id.img_fri);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
