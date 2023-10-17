package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teamalfa.kidslearningapp.R;

public class AlphabeticTestOptionAdapter extends BaseAdapter {
    String [] optionAlphabet;
    Context context;

    public AlphabeticTestOptionAdapter(String[] optionAlphabet, Context context) {
        this.optionAlphabet = optionAlphabet;
        this.context = context;
    }

    @Override
    public int getCount() {
        return optionAlphabet.length;
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
        TextView tvOptionAlphabet = view.findViewById(R.id.tv_alphabet);
        tvOptionAlphabet.setText(optionAlphabet[i]);
        return view;
    }
}
