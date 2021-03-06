package com.example.quarterhour.ui.jokes.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.JokesBean;
import com.example.quarterhour.ui.details.DetailsActivity;
import com.example.quarterhour.util.AddImg;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class DzAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<JokesBean.DataBean> list;
    private LayoutInflater inflater;
    private View view;
    private List<ImageView> images;
//    private ImageView imageView = null;
    private Handler handler = new Handler();

    public DzAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        images = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.recyclerdz_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final boolean[] flag = {true};
        final ViewHolder viewHolder = (ViewHolder) holder;

        JokesBean.DataBean dataBean = list.get(position);

        viewHolder.simple_user.setImageURI(dataBean.getUser().getIcon());
        viewHolder.simple_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
//                intent.putExtra("uid")
                context.startActivity(intent);
            }
        });

        viewHolder.tv_username.setTextColor(Color.RED);
        viewHolder.tv_username.setText(dataBean.getUser().getNickname()+"");
        viewHolder.tv_createtime.setText(dataBean.getCreateTime());
        viewHolder.tv_nr.setText(dataBean.getContent());
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

        public ViewHolder(View itemView) {
            super(itemView);
            simple_user = itemView.findViewById(R.id.simple_user);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_createtime = itemView.findViewById(R.id.tv_createtime);
            image_bj = itemView.findViewById(R.id.image_bj);
            tv_nr = itemView.findViewById(R.id.tv_nr);
            ll = itemView.findViewById(R.id.ll);
        }
    }


}
