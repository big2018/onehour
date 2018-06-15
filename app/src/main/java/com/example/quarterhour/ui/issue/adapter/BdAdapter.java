package com.example.quarterhour.ui.issue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.BdVideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class BdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<BdVideoBean.DataBean> list;
    private LayoutInflater inflater;

    public BdAdapter(Context context, List<BdVideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.bdadapter_item,null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.simpleDraweeView.setImageURI(list.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView simpleDraweeView;

        public ViewHolder(View itemView) {
            super(itemView);

            simpleDraweeView = itemView.findViewById(R.id.simple_bd);

        }
    }

}
