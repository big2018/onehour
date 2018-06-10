package com.example.quarterhour.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.util.SpUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ImageView img_qqlogin;
    /**
     * 其他方式登录
     */
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListener();
    }

    private void initView() {
        img_qqlogin = (ImageView) findViewById(R.id.img_qqlogin);
        tv_login = (TextView) findViewById(R.id.tv_login);
    }

    private void setListener() {
        img_qqlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //qq登录
                UMShareAPI umShareAPI = UMShareAPI.get(LoginActivity.this);
                umShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Login2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();
//            StringBuilder ss = new StringBuilder();
//            for (Map.Entry<String, String> entry : data.entrySet()) {
//                String key = entry.getKey();
//                String value = entry.getValue();
//                ss.append(key + ":");
//                ss.append(value + "\n");
//            }
//            Log.i("===",ss.toString());
            String name = data.get("name");
            String iconurl = data.get("iconurl");
            SpUtil.saveString(LoginActivity.this,"name",name);
            SpUtil.saveString(LoginActivity.this,"iconurl",iconurl);
            finish();
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

}
