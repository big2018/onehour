package com.example.quarterhour.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.quarterhour.R;

import java.util.List;

public class AddImg {

    public static void addImg(Context context, boolean flag, final RelativeLayout relativeLayout, int uri, float address, final List<ImageView> images, Handler handler){

        if (flag) {
            ImageView imageView = new ImageView(context);
            images.add(imageView);
            imageView.setImageResource(uri);

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(75, 75);
            lp.addRule(RelativeLayout.ALIGN_TOP, R.id.image_bj);
            lp.addRule(RelativeLayout.ALIGN_RIGHT, R.id.image_bj);

            relativeLayout.addView(imageView, lp);

            ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 180f, 0f);
            ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1.0f);
            float translationX = imageView.getTranslationX();
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", translationX, address);
            AnimatorSet set = new AnimatorSet();
            //添加动画
            set.play(objectAnimator).with(alpha).with(rotation);
            set.setDuration(500);
            set.start();
        }else {
            if (images != null) {
                for (int i = 0 ; i < images.size() ; i++ ) {
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(images.get(i), "rotation", 0f, 180f);
                    ObjectAnimator alpha = ObjectAnimator.ofFloat(images.get(i), "alpha", 1.0f, 0f);
                    float translationX = images.get(i).getTranslationX();
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(images.get(i), "translationX", translationX, -address);
                    AnimatorSet set = new AnimatorSet();
                    //添加动画
                    set.play(objectAnimator).with(alpha).with(rotation);
                    set.setDuration(500);
                    set.start();
                    final int finalI = i;
                    System.out.println(handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            relativeLayout.removeView(images.get(finalI));
                        }
                    },500));

                }
            }
        }
    }


}
