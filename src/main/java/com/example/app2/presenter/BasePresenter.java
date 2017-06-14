package com.example.app2.presenter;

import com.example.app2.view.activity.iview.IMvp;

/**
 * Created by wangxiaoxiao on 2017/6/10.
 */

public class BasePresenter  <T extends IMvp>{
    public T tm;

    public void attachView(T t) {
        this.tm = t;
    }
    public T getMvpView(){
        return tm;
    }
}
