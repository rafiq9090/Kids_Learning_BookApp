package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teamalfa.kidslearningapp.R;

public class AlphabeticTestAdapter extends BaseAdapter {
    String[] alphabet;
    Context context;

    Animation zoomAlphabetAnim;

    public AlphabeticTestAdapter(String[] alphabet, Context context) {
        this.alphabet = alphabet;
        this.context = context;
        zoomAlphabetAnim = AnimationUtils.loadAnimation(context,R.anim.zoom_alphabet);
    }

    @Override
    public int getCount() {
        return alphabet.length;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_alphabet,viewGroup,false);
        }
        TextView tv = view.findViewById(R.id.tv_alphabet);
        if (i%2==0){
            tv.setText(alphabet[i]);
            tv.setAnimation(zoomAlphabetAnim);
        }else {
            tv.setText("");
        }
        return view;
    }
}
