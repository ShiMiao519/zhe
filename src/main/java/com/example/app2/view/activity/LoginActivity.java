package com.example.app2.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app2.R;
import com.example.app2.model.utils.HttpUtils;
import com.example.app2.model.utils.home.LoginBean;
import com.example.app2.view.activity.fragment.ShouYe;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by wangxiaoxiao on 2017/6/9.
 */

public class LoginActivity extends Activity{

    private EditText edit_name;
    private EditText edit_pwd;
    private Button button_denglu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        findViewById(R.id.zhuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ZhuCeActivity.class);
                startActivity(intent);

            }
        });
        initView();
        initData();
    }

    private void initData() {
        button_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCode(edit_name.getText().toString(), edit_pwd.getText().toString());
            }
        });
    }

    private void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        button_denglu = (Button) findViewById(R.id.button_denglu);
    }
    public void getCode(String user, String password) {
        Observer<LoginBean> observer=  new Observer<LoginBean>(){

            @Override
            public void onError(Throwable e) {
                Log.d("memeda", "login:" + e.toString());

            }

            @Override
            public void onComplete() {

            }


            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                Log.d("memeda", "login:" + loginBean.getCode() + "");

            }
        };
        HttpUtils.login(user, password, "android", observer);
    }

}
