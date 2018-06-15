package com.example.quarterhour.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quarterhour.R;

public class SearchFriActivity extends AppCompatActivity {

    /**
     * 输入ID或者钟友名
     */
    private EditText rd_keywords;
    /**
     * 搜索
     */
    private TextView tv_sou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_fri);
        initView();

        //设置点击的监听
        tv_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String trim = rd_keywords.getText().toString().trim();

                if (!TextUtils.isEmpty(trim)) {
                    Intent intent = new Intent(SearchFriActivity.this, FriendsListActivity.class);
                    intent.putExtra("keywords",trim);
                    startActivity(intent);
                }
            }
        });
    }

    private void initView() {
        rd_keywords = (EditText) findViewById(R.id.rd_keywords);
        tv_sou = (TextView) findViewById(R.id.tv_sou);
    }
}
