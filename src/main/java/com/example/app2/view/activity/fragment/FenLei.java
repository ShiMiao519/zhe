package com.example.app2.view.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.app2.R;
import com.example.app2.model.utils.home.FenLeiBean;
import com.example.app2.view.activity.adapter.FenLeiAdapter;
import com.example.app2.view.activity.iview.InFenLei;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by wangxiaoxiao on 2017/5/10.
 */

public class FenLei extends Fragment {


    private ListView listView1;
    private ListView listView2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fenlei,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView1 = (ListView) getView().findViewById(R.id.class1ListView);
        listView2 = (ListView) getView().findViewById(R.id.class2ListView);
        initData();
        initLeiBiao();

    }
   //地区列表
     private void initLeiBiao() {

     }
  //分类
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.163.32/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InFenLei fenLei = retrofit.create(InFenLei.class);
        Call<FenLeiBean> string = fenLei.getString();
        string.enqueue(new Callback<FenLeiBean>() {
            @Override
            public void onResponse(Call<FenLeiBean> call, Response<FenLeiBean> response) {
            Log.e("ssss","onResponse"+response.body().getDatas().getClass_list().get(0).getGc_name());

                FenLeiAdapter fenLeiAdapter = new FenLeiAdapter(getActivity());
                fenLeiAdapter.setData(response.body().getDatas().getClass_list());
                listView1.setAdapter(fenLeiAdapter);
            }

            @Override
            public void onFailure(Call<FenLeiBean> call, Throwable t) {
                Log.e("Retrofit===","失败");

            }
        });

    }

}
