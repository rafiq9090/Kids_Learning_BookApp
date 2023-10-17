package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teamalfa.kidslearningapp.R;
import com.teamalfa.kidslearningapp.SplashActivity;

import java.util.Random;

public class NumberBananAdapter extends BaseAdapter {

    String[] Number;
    String[] bNanan;
    Context mContext;

    Boolean isDayMonth = false;

    public NumberBananAdapter(String[] number, String[] bNanan, Context mContext, Boolean isBanan) {
        Number = number;
        this.bNanan = bNanan;
        this.mContext = mContext;
        this.isDayMonth = isBanan;
    }

    public NumberBananAdapter(String[] number, String[] bNanan, Context mContext) {
        Number = number;
        this.bNanan = bNanan;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return bNanan.length;
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

        int color = rendomColor();

        if (isDayMonth == false){

            if (view == null){
                view = LayoutInflater.from(mContext).inflate(R.layout.item_banan,viewGroup,false);
            }
            TextView number =view.findViewById(R.id.tv_number);
            TextView  nBanan = view.findViewById(R.id.tv_banan);
            number.setTextColor(color);
            nBanan.setTextColor(color);
            number.setText(Number[i]);
            nBanan.setText(bNanan[i]);
        }
        else {
            if (view == null){
                view = LayoutInflater.from(mContext).inflate(R.layout.itemdaymothyear,viewGroup,false);
            }
            TextView number =view.findViewById(R.id.item_showing_one_item);
            TextView  nBanan = view.findViewById(R.id.item_showing_tow_item);
            number.setTextColor(color);
            nBanan.setTextColor(color);
            number.setText(Number[i]);
            nBanan.setText(bNanan[i]);
        }

        return view;
    }
    public int rendomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(100));
        return color;
    }
}
