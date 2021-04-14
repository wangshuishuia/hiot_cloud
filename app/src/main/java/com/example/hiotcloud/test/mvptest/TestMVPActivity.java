package com.example.hiotcloud.test.mvptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiotcloud.R;
import com.example.hiotcloud.base.BaseActivity;
import com.example.hiotcloud.test.dagger2test.DaggerPresenterComponent;
import com.example.hiotcloud.test.dagger2test.PresenterComponent;
import com.example.hiotcloud.test.mvptest.model.User;

import javax.inject.Inject;

public class TestMVPActivity extends BaseActivity<TestView,TestPresenter> implements TestView{

    @Inject
    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        final EditText etUserName = findViewById(R.id.et_user_name);
        final EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        final User user = new User();

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //mvc做法，在这里做身份校验
                user.setUserName(etUserName.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);
//                login(user);
            }

        });
    }

    @Override
    public TestPresenter creatPresenter() {
        return presenter;
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 创建注入器
     * @return
     */
    public PresenterComponent getComponent(){
        return DaggerPresenterComponent.builder().build();
    }
//    private void login(User user) {
//        if ("lisi".equals(user.getUserName()) && "123".equals(user.getPassword())){
//            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
//        }
//    }

}
