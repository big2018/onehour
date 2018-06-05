package com.example.quarterhour.ui.recommend.fragment;

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

import com.example.quarterhour.R;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment {

    private View view;
    private TabLayout tab_layout;
    private ViewPager vp;
    private List<String> myTabs=new ArrayList<>();
    private List<Fragment> list_frag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tui, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        vp = (ViewPager) view.findViewById(R.id.vp);
        initData();
    }

    private void initData() {
        myTabs.add("热门");
        myTabs.add("关注");
        list_frag = new ArrayList<>();
        HotFragment hotFragment = new HotFragment();
        GuanZhuFragment guanZhuFragment = new GuanZhuFragment();
        list_frag.add(hotFragment);
        list_frag.add(guanZhuFragment);
        vp.setAdapter(new MyVpAdapter(getChildFragmentManager()));
        tab_layout.setupWithViewPager(vp);
    }

    class MyVpAdapter extends FragmentPagerAdapter{

        public MyVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return myTabs.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return list_frag.get(position);
        }

        @Override
        public int getCount() {
            return myTabs.size();
        }
    }



}
