package com.example.quarterhour.ui.video.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.example.quarterhour.R;
import com.example.quarterhour.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment{

    private List<String> list_tab;
    private List<Fragment> fragments;
    private TabLayout tab;
    private ViewPager viewpager;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void inject() {

    }

    @Override
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
}
