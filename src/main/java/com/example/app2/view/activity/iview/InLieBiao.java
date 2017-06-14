package com.example.app2.view.activity.iview;

import com.example.app2.model.utils.home.FenLeiBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wangxiaoxiao on 2017/6/13.
 */

public interface InLieBiao {
    @GET("mobile/index.php?act=area&op=index ")
    Call<String> getLieBiao();
}
