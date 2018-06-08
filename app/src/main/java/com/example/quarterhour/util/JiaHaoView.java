package com.example.quarterhour.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.quarterhour.R;




public class JiaHaoView extends RelativeLayout {
    private ImageView image_show;
    private ImageView image_jian;
    private ImageView image_report;
    private ImageView image_copy;
    private ImageView image_pingbi;
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            image_jian.setVisibility(View.INVISIBLE);
            image_report.setVisibility(View.INVISIBLE);
            image_copy.setVisibility(View.INVISIBLE);
            image_pingbi.setVisibility(View.INVISIBLE);
        }
    };

    public JiaHaoView(Context context) {
        super(context);
    }

    public JiaHaoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.jia_item, this, false);
        image_show = view.findViewById(R.id.image_show);
        image_jian = view.findViewById(R.id.image_jian);
        image_report = view.findViewById(R.id.image_report);
        image_copy = view.findViewById(R.id.image_copy);
        image_pingbi = view.findViewById(R.id.image_pingbi);
        //默认隐藏
        image_jian.setVisibility(View.GONE);
        image_report.setVisibility(View.GONE);
        image_copy.setVisibility(View.GONE);
        image_pingbi.setVisibility(View.GONE);

        //加号按钮的点击事件,展示另外三张图片
        image_show.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果加号显示,其他四个都隐藏
                image_show.setVisibility(View.INVISIBLE);
                image_jian.setVisibility(View.VISIBLE);
                image_report.setVisibility(View.VISIBLE);
                image_copy.setVisibility(View.VISIBLE);
                image_pingbi.setVisibility(View.VISIBLE);
                showMenu();

            }
        });

        //减号的点击事件,隐藏另外三张图片
        image_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                image_show.setVisibility(View.VISIBLE);
                hideMenu();
                if (image_jian.getVisibility() == View.VISIBLE) {
                   handler.sendEmptyMessageDelayed(0,270);
                }

            }
        });

        addView(view);
    }

    public JiaHaoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //属性动画,,展示出来
    public void showMenu() {
        //三个平移动画 平移出来
        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(image_pingbi
                , "translationX", 0, -60f);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy
                , "translationX", 0, -130f);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_report
                , "translationX", 0, -200f);

        //旋转动画
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(image_jian, "rotation", 0, -360);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(image_report, "rotation", 0, -360);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(image_copy, "rotation", 0, -360);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(image_pingbi, "rotation", 0, -360);

        //组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(600);//动画时长
//        animatorSet.setInterpolator(new OvershootInterpolator());
        //设置动画一起播放
        animatorSet.playTogether(rotation1, rotation2, rotation3, rotation4, firstAnimator, secondAnimator, thirdAnimator);

        animatorSet.start();

    }

    public void hideMenu() {
        //三个平移回去
        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(image_pingbi
                , "translationX", -60f, 0f);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy
                , "translationX",  -130f,0f);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_report
                , "translationX", -200f, 0f);
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(image_show, "rotation", 0, 360);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(image_copy, "rotation", 0, 360);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(image_pingbi, "rotation", 0, 360);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(image_report, "rotation", 0, 360);

        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(rotation1).with(rotation2).with(rotation3).with(rotation4).with(thirdAnimator).with(secondAnimator).with(firstAnimator);
        animatorSet.setDuration(600);
//        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.playTogether(rotation1, rotation2, rotation3, rotation4, firstAnimator, secondAnimator, thirdAnimator);
        animatorSet.start();
    }

}
