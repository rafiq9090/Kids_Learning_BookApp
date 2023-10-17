package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.teamalfa.kidslearningapp.BanglaActivity;
import com.teamalfa.kidslearningapp.R;

import soup.neumorphism.NeumorphImageView;
import soup.neumorphism.NeumorphTextView;

public class Dashboardlistadapter extends BaseAdapter {
    String[] itemDash;
    int [] itemImage;
    Context context;

    public Dashboardlistadapter(String[] itemDash,int[] itemImage,Context context) {
        this.itemDash = itemDash;
        this.itemImage = itemImage;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemDash.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view=LayoutInflater.from(context).inflate(R.layout.item_view,viewGroup,false);
        }
        TextView tv = view.findViewById(R.id.tv_item);
        NeumorphImageView img = view.findViewById(R.id.item_img);
        tv.setText(itemDash[i]);
        img.setImageResource(itemImage[i]);
        return view;
    }
}
