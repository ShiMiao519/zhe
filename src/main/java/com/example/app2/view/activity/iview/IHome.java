package com.example.app2.view.activity.iview;

/**
 * Created by wangxiaoxiao on 2017/6/10.
 */

public interface IHome<T> extends  IMvp {
    void callbackStr(T t);
    void callbackErr(String errMsg, int errCode);
}
