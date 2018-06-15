package com.example.quarterhour.ui.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.quarterhour.MainActivity;
import com.example.quarterhour.R;
import com.example.quarterhour.ui.issue.fragment.BdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class SaveVideoActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> list_tab;
    private List<Fragment> fragments;
    /**
     * 返回
     */
    private TextView mTvSavereturn;
    private TabLayout mTabSave;
    private ViewPager mPagerSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_video);
        initView();


        list_tab = new ArrayList<>();
        list_tab.add("本地作品");
        list_tab.add("已上传");
        fragments = new ArrayList<>();
        fragments.add(new BdFragment());
        fragments.add(new BdFragment());
        mPagerSave.setAdapter(new Myadapter(getSupportFragmentManager()));
        mTabSave.setupWithViewPager(mPagerSave);

    }

    private void initView() {
        mTvSavereturn = (TextView) findViewById(R.id.tv_savereturn);
        mTvSavereturn.setOnClickListener(this);
        mTabSave = (TabLayout) findViewById(R.id.tab_save);
        mPagerSave = (ViewPager) findViewById(R.id.pager_save);
    }

    class Myadapter extends FragmentPagerAdapter {
        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return list_tab == null ? 0 : list_tab.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return list_tab.get(position);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_savereturn:
                Intent intent = new Intent(SaveVideoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}
