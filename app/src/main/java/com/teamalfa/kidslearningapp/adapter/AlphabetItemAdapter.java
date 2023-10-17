package com.teamalfa.kidslearningapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teamalfa.kidslearningapp.R;
import com.teamalfa.kidslearningapp.SplashActivity;
import com.teamalfa.kidslearningapp.hendWrintingActivity;

import java.util.Random;

public class AlphabetItemAdapter extends BaseAdapter {
    Animation zoomAlphabetAnim;
    String[] alphabhetText;
    Context context;
    SplashActivity.TextToSpechHelper textToSpechHelper;
    boolean isHandWritin = false;

    public AlphabetItemAdapter(String[] itemBanglaT, Context context) {
        textToSpechHelper = new SplashActivity.TextToSpechHelper(context);
        this.alphabhetText = itemBanglaT;
        this.context = context;
        zoomAlphabetAnim = AnimationUtils.loadAnimation(context,R.anim.zoom_alphabet);
    }

    public AlphabetItemAdapter(String[] itemBanglaT, Context context,boolean isHandWritin) {
        textToSpechHelper = new SplashActivity.TextToSpechHelper(context);
        this.alphabhetText = itemBanglaT;
        this.context = context;
        this.isHandWritin = isHandWritin;
    }

    @Override
    public int getCount() {
        return alphabhetText.length;
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
            view= LayoutInflater.from(context).inflate(R.layout.item_alphabet,viewGroup,false);
        }
        TextView tv = view.findViewById(R.id.tv_alphabet);
        // image view
        //ImageView btnSpeeak = view.findViewById(R.id.btn_speak);
        tv.setText(alphabhetText[i]);
        tv.setTextColor(rendomColor());
        tv.setAnimation(zoomAlphabetAnim);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isHandWritin){
                    Intent intent = new Intent(context, hendWrintingActivity.class);
                    intent.putExtra("alphabet",alphabhetText[i]);
                    context.startActivity(intent);
                }else {
                    textToSpechHelper.speeak(alphabhetText[i]);
                }
            }
        });
//        btnSpeeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textToSpechHelper.speeak(alphabhetText[i]);
//            }
//        });

        return view;
    }

    public int rendomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(100));
        return color;
    }
}
