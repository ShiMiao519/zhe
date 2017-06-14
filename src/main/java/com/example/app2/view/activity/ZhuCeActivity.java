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
import com.example.app2.model.utils.home.RegisterBean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.R.attr.name;


/**
 * Created by wangxiaoxiao on 2017/6/9.
 */

public class ZhuCeActivity extends Activity{

    private EditText edit_phone;
    private EditText edit_pwd;
    private EditText edit_email;
    private Button button_zhuce;
    private EditText edit_pwdtwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce_main);
        initView();
        initData();

    }

    private void initData() {
        button_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = edit_phone.getText().toString();
                String pw = edit_pwd.getText().toString();
                String pw2 = edit_pwdtwo.getText().toString();
                String e = edit_email.getText().toString();
                getCode(p,pw , pw2, e);
                Intent intent = new Intent(ZhuCeActivity.this, LoginActivity.class);
                startActivity(intent);
                clear();
            }
        });
    }

    private void initView() {
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        edit_pwdtwo = (EditText) findViewById(R.id.edit_pwdtwo);
        edit_email = (EditText) findViewById(R.id.edit_email);
        button_zhuce = (Button) findViewById(R.id.button_zhuce);
    }
    public void getCode(String user, String password, String password2, String email) {
        Observer<RegisterBean> observer = new Observer<RegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterBean value) {
                Log.d("memeda", "register:" + value);
                Log.d("memeda", "register:" + value.getCode()+value.getDatas().toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("memeda", "register:" + e.toString());
            }

            @Override
            public void onComplete() {

            }
        };
        HttpUtils.register(user, password, password2, email, "android", observer);
    }
    public void clear(){
        edit_phone.setText("");
        edit_pwd.setText("");
        edit_pwdtwo.setText("");
        edit_email.setText("");
    }

    /** 
      * 验证用户名 
      * @param username 用户名 
      * @return boolean 
      */
    public static boolean checkUsername(String username){
        // 昵称格式：限16个字符，支持中英文、数字、减号或下划线
              String regex = "([a-zA-Z0-9]{6,12})";
                Pattern p = Pattern.compile(regex);
               Matcher m = p.matcher(username);
               return m.matches();
    }

         /**
      * 正则表达式：验证密码
      */
      public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    /**
          * 校验密码
          *
          * @param password
          * @return 校验通过返回true，否则返回false
          */
 public static boolean isPassword(String password) {
         return Pattern.matches(REGEX_PASSWORD, password);
 }
    // 判断email格式是否正确
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
