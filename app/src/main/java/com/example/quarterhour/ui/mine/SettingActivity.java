package com.example.quarterhour.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.quarterhour.R;
import com.example.quarterhour.ui.login.Login2Activity;

public class SettingActivity extends AppCompatActivity {

    /**
     * 退出登录
     */
    private Button btn_tui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();

        btn_tui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, Login2Activity.class);
                startActivity(intent);
                SettingActivity.this.finish();
            }
        });

    }


    private void initView() {
        btn_tui = (Button) findViewById(R.id.btn_tui);
    }
}
