package com.example.sj.testlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by sj on 2017/10/3.
 */

public class CheckAdapter extends BaseAdapter {
    ArrayList<bean> data;
    Context context;

    public CheckAdapter(ArrayList<bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void update(int index){
            bean beans=data.get(index);
            beans.setCheck(true);
            notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);

        View mview = inflater.inflate(R.layout.item_checkbox, null);
        CheckBox check=mview.findViewById(R.id.checkBox);
        if(data.get(position).isCheck){
            check.setChecked(true);
        }else{
            check.setChecked(false);
        }

        return mview;
    }


}
