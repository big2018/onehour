package com.example.quarterhour.ui.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.VideosBean;
import com.example.quarterhour.ui.details.VideoDetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PubuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private  List<VideosBean.DataBean> data;
    private List<Integer> heights;
    private LayoutInflater inflater;

    public PubuAdapter(Context context, List<VideosBean.DataBean> data, List<Integer> heights) {
        this.context = context;
        this.data = data;
        this.heights = heights;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pubuliu_layout,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        ViewGroup.LayoutParams lp = viewHolder.simple_pubu.getLayoutParams();
        lp.height = heights.get(position);
        viewHolder.simple_pubu.setLayoutParams(lp);
        final VideosBean.DataBean dataBean = data.get(position);
        viewHolder.simple_pubu.setImageURI(dataBean.getCover());
        viewHolder.simple_pubu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,VideoDetailsActivity.class);
                intent.putExtra("videosbean",dataBean);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView simple_pubu;

        public ViewHolder(View itemView) {
            super(itemView);

            simple_pubu = itemView.findViewById(R.id.simple_pubu);

        }
    }
}
