package com.example.quarterhour.ui.issue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quarterhour.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class IssueVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    private String imgurl = "https://www.zhaoapi.cn/images/quarter/1515587806806151496296995.jpg";

    public IssueVideoAdapter(Context context,List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.issuevideo_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.img_issuevideo.setImageURI(imgurl);
        viewHolder.tv_issuevideo.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView img_issuevideo;
        private TextView tv_issuevideo;

        public ViewHolder(View itemView) {
            super(itemView);

            img_issuevideo = itemView.findViewById(R.id.img_issuevideo);
            tv_issuevideo = itemView.findViewById(R.id.tv_issuevideo);

        }
    }

}
