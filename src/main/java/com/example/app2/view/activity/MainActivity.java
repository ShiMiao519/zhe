package com.example.app2.view.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.app2.R;
import com.example.app2.view.activity.fragment.GouWu;
import com.example.app2.view.activity.fragment.FenLei;
import com.example.app2.view.activity.fragment.ShouYe;
import com.example.app2.view.activity.fragment.WoDe;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private RadioGroup rg;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private RadioButton rb_4;
    private List<Fragment> list;

    private FenLei shiPing;
    private GouWu guanZhu;
    private WoDe woDe;
    private ShouYe shouYe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

    }
    private void initData() {
        RadioGroup rg= (RadioGroup) findViewById(R.id.rg);
        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        shouYe = new ShouYe();
        shiPing = new FenLei();
        guanZhu = new GouWu();
        woDe = new WoDe();

        transaction.add(R.id.fragmentlay,shouYe).hide(shouYe);
        transaction.add(R.id.fragmentlay,shiPing).hide(shiPing);
        transaction.add(R.id.fragmentlay,guanZhu).hide(guanZhu);
        transaction.add(R.id.fragmentlay,woDe).hide(woDe);
        transaction.commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_1:
                    {

                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.show(shouYe).hide(shiPing).hide(guanZhu).hide(woDe);
                        transaction.commit();

                    }
                    break;
                    case R.id.rb_2:
                    {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.show(shiPing).hide(shouYe).hide(guanZhu).hide(woDe);
                        transaction.commit();
                    }
                    break;
                    case R.id.rb_3:
                    {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();

                        transaction.show(guanZhu).hide(shouYe).hide(shiPing).hide(woDe);
                        transaction.commit();
                    }
                    break;
                    case R.id.rb_4:
                    {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();

                        transaction.show(woDe).hide(shouYe).hide(shiPing).hide(guanZhu);
                        transaction.commit();
                    }
                    break;

                }
            }
        });

    }
}
