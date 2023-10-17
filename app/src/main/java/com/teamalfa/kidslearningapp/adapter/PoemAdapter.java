package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.teamalfa.kidslearningapp.R;
import com.teamalfa.kidslearningapp.SplashActivity;

public class PoemAdapter extends BaseAdapter {
    String[] poemTitle;
    String[] poemDes;
    Context context;

    public PoemAdapter(String[] poemTitle, String[] poemDes, Context context) {
        this.poemTitle = poemTitle;
        this.poemDes = poemDes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return poemDes.length;
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
        SplashActivity.TextToSpechHelper textToSpechHelper = new SplashActivity.TextToSpechHelper(context);
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_poem_layout,viewGroup,false);
        }
        TextView tvTitle = view.findViewById(R.id.tv_poem_title);
        TextView tvDes = view.findViewById(R.id.tv_poem_des);
        ImageButton btnSpeak = view.findViewById(R.id.btn_speak);

        tvTitle.setText(poemTitle[i]);
        tvDes.setText(poemDes[i]);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpechHelper.speeak(poemTitle[i]+"। "+poemDes[i]);
            }
        });
        return view;
    }
}
