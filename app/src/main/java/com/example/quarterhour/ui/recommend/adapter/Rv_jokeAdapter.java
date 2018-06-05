package com.example.quarterhour.ui.recommend.adapter;

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
import com.example.quarterhour.bean.JokesBean;

import java.util.List;

public class Rv_jokeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<JokesBean.DataBean> list;
    private Context context;
    private final LayoutInflater inflater;

    public Rv_jokeAdapter(List<JokesBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_joke_item, parent, false);
        JokeViewHolder jokeViewHolder=new JokeViewHolder(view);
        return jokeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder jokeViewHolder= (JokeViewHolder) holder;
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).getUser().getIcon()).apply(requestOptions).into(jokeViewHolder.img);
        jokeViewHolder.tv_name.setText((String) list.get(position).getUser().getNickname());
        jokeViewHolder.tv_time.setText(list.get(position).getCreateTime());
        jokeViewHolder.tv_title.setText(list.get(position).getContent());
        String imgUrls = (String) list.get(position).getImgUrls();
        if (imgUrls!=null){
            Glide.with(context).load(imgUrls.split("\\|")[0]).into(jokeViewHolder.img_xia);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class JokeViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv_name;
        TextView tv_time;
        TextView tv_title;
        ImageView img_xia;

        public JokeViewHolder(View view) {
            super(view);
            this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            this.img = (ImageView) view.findViewById(R.id.img);
            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.img_xia = (ImageView) view.findViewById(R.id.img_xia);
        }
    }
}
