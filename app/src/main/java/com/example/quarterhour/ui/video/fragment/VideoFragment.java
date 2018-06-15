package com.example.quarterhour.ui.video.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.quarterhour.R;
import com.example.quarterhour.ui.base.BaseFragment;
import com.example.quarterhour.util.DensityUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment{

    private List<String> list_tab;
    private List<Fragment> fragments;
    private TabLayout tab;
    private ViewPager viewpager;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video,null);
        initView(view);
        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void initView(View view) {
        tab = view.findViewById(R.id.tab);
        viewpager = view.findViewById(R.id.viewpager);
        list_tab = new ArrayList<>();
        list_tab.add("热门");
        list_tab.add("附近");
        fragments = new ArrayList<>();
        fragments.add(new HotFrag());
        fragments.add(new NearbyFrag());
        viewpager.setAdapter(new Myadapter(getChildFragmentManager()));
        tab.setupWithViewPager(viewpager);
        setTabLine(tab,70,70);
    }

    class Myadapter extends FragmentPagerAdapter{
        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return list_tab.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return list_tab.get(position);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setTabLine(TabLayout tab, int left, int right) {
        try {
            Class<?> tablayout = tab.getClass();
            Field tabStrip = tablayout.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) tabStrip.get(tab);
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                //修改两个tab的间距
                params.setMarginStart(DensityUtil.dip2px(getActivity(), left));
                params.setMarginEnd(DensityUtil.dip2px(getActivity(), right));
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
//            Log.e(TAG,e.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
//            Log.e(TAG,e.toString());
        }
    }
}
