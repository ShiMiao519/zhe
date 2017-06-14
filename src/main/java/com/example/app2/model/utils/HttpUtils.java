package com.example.app2.model.utils;

import android.util.Log;

import com.example.app2.model.utils.home.LoginBean;
import com.example.app2.model.utils.home.RegisterBean;
import com.example.app2.view.activity.iview.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by wangxiaoxiao on 2017/6/10.
 */

public class HttpUtils {
    static public void login(String username, String password, String client, Observer<LoginBean> observer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.163.32/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<LoginBean> observable = api.getLoginCode("login", username, password, client);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    static public void register(String username, String password,String password2,String email, String client, Observer<RegisterBean> observer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.163.32/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Log.e("数据",username+"====="+password+"====="+password2+"====="+email+"====="+client);
        Observable<RegisterBean> observable = api.getRegCode("login","register", username, password, password2,email,client);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
