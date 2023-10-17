package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamalfa.kidslearningapp.R;

import java.util.Random;

public class AlphabetHorizonatlGridView extends BaseAdapter {
    String[] itemAlphabet;
    Context context;

    public AlphabetHorizonatlGridView(String[] itemAlphabet, Context context) {
        this.itemAlphabet = itemAlphabet;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemAlphabet.length;
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
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_alphabet_hz_rv,viewGroup,false);
        }
        TextView tv = view.findViewById(R.id.tv_alphabet_h_rv);
        tv.setText(itemAlphabet[i]);
        tv.setTextColor(rendomColor());
        return view;
    }

    public int rendomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(100));
        return color;
    }
}
