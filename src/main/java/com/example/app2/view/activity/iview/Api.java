package com.example.app2.view.activity.iview;

import com.example.app2.model.utils.home.LoginBean;
import com.example.app2.model.utils.home.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by wangxiaoxiao on 2017/6/10.
 */

public interface Api {
    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<RegisterBean> getRegCode(@Field("act") String sort,
                                        @Field("op") String op,
                                        @Field("username") String username,
                                        @Field("password") String password,
                                        @Field("password_confirm") String password_confirm,
                                        @Field("email") String email,
                                        @Field("client") String client);

    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<LoginBean> getLoginCode(@Field("act") String sort,
                                       @Field("username") String username,
                                       @Field("password") String password,
                                       @Field("client") String client);
}
