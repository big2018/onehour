package com.example.quarterhour.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.bean.UserBean;
import com.example.quarterhour.component.DaggerHttpComponent;
import com.example.quarterhour.ui.base.BaseActivity;
import com.example.quarterhour.ui.login.contract.LoginContrct;
import com.example.quarterhour.ui.login.presenter.LoginPresenter;
import com.example.quarterhour.util.SpUtil;

public class Login2Activity extends BaseActivity<LoginPresenter> implements LoginContrct.View {

    /**
     * 账号
     */
    private EditText ed_account;
    /**
     * 密码
     */
    private EditText ed_password;
    /**
     * 登录
     */
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ed_account = (EditText) findViewById(R.id.ed_account);
        ed_password = (EditText) findViewById(R.id.ed_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login2;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        Toast.makeText(this, "登陆成功!", Toast.LENGTH_SHORT).show();
        UserBean.DataBean data = userBean.getData();
        String icon = data.getIcon();
        String mobile = data.getMobile();
        String token = data.getToken();
        int uid = data.getUid();
        SpUtil.saveString(Login2Activity.this,"name",mobile);
        SpUtil.saveString(Login2Activity.this,"iconurl",icon);
        SpUtil.saveString(Login2Activity.this,"token",token);
        SpUtil.saveString(Login2Activity.this,"uid",uid+"");
        this.finish();
    }

    @Override
    public String getMobile() {
        return ed_account.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return ed_password.getText().toString().trim();
    }
}
