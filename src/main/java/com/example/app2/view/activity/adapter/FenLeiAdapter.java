package com.example.app2.view.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app2.R;
import com.example.app2.model.utils.home.FenLeiBean;
import com.example.app2.view.activity.iview.InFenLei;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxiaoxiao on 2017/6/12.
 */

public class FenLeiAdapter extends BaseAdapter {

    private Context context;
    private List<FenLeiBean.DatasBean.ClassListBean> list=new ArrayList<>();
    public FenLeiAdapter(Context context){
        this.context=context;


    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=null;
        if (convertView==null){
           holder = new Holder();
            Log.e("dddd","===============");
            convertView=View.inflate(context, R.layout.frnlei_listview,null);
            holder.image_fl= (ImageView) convertView.findViewById(R.id.image_fl);
           holder.text_fl= (TextView) convertView.findViewById(R.id.text_fl);
            convertView.setTag(holder);

        }else {
            holder= (Holder) convertView.getTag();
        }
        holder.text_fl.setText(list.get(position).getGc_name());
        ImageLoader.getInstance().displayImage(list.get(position).getImage(),holder.image_fl);
        return convertView;
    }
    public void  setData(List<FenLeiBean.DatasBean.ClassListBean> list){
        if (list !=null) {
            this.list.addAll(list);
        }

    }
    static  class   Holder{
        ImageView image_fl;
        TextView text_fl;

    }
}
