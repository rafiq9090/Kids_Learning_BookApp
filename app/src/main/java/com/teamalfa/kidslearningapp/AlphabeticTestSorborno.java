package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamalfa.kidslearningapp.adapter.AlphabeticTestAdapter;
import com.teamalfa.kidslearningapp.adapter.AlphabeticTestOptionAdapter;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import es.dmoral.toasty.Toasty;

public class AlphabeticTestSorborno extends AppCompatActivity {
    GridView gridAlphabeticTest,gridAlphabeticTestOption;
    String[] alhpabet;
    int lastClickIndex;
    TextView tvBlankText;
    String[] alphabetOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabetic_test_sorborno);
        gridAlphabeticTest = findViewById(R.id.grid_alphabetic_test);
        gridAlphabeticTestOption = findViewById(R.id.grid_alphabetic_test_option);
        getSupportActionBar().hide();
        int arrayID = getIntent().getIntExtra("array",0);
        alhpabet = getResources().getStringArray(arrayID);
        AlphabeticTestAdapter alphabeticTestAdapter = new AlphabeticTestAdapter(alhpabet,AlphabeticTestSorborno.this);
        gridAlphabeticTest.setAdapter(alphabeticTestAdapter);

        SplashActivity.TextToSpechHelper textToSpechHelper = new SplashActivity.TextToSpechHelper(AlphabeticTestSorborno.this);
        textToSpechHelper.speeak("তুমি কি টেস্ট এর জন্য প্রস্তুত? তাহলে শূন্য স্থানে চাপ দিয়ে, নিচের তিনটি অক্ষরের মধ্যে থেকে সঠিক অক্ষরে চাপ দাও।");
        gridAlphabeticTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lastClickIndex = i;
                alphabetOption = new String[3];
                int itemOne = getRandomValue(0,alhpabet.length);
                if (itemOne == i){
                    itemOne = getRandomValue(0,alhpabet.length);
                }
                alphabetOption[0] = alhpabet[itemOne];
                int itemTwo = getRandomValue(0,alhpabet.length);
                if (itemTwo == i){
                    itemTwo = getRandomValue(0,alhpabet.length);
                }

                tvBlankText = view.findViewById(R.id.tv_alphabet);

                tvBlankText.setBackgroundColor(Color.GRAY);

                alphabetOption[1] = alhpabet[itemTwo];
                alphabetOption[2] = alhpabet[i];
                Arrays.sort(alphabetOption);

                AlphabeticTestOptionAdapter alphabeticTestOptionAdapter = new AlphabeticTestOptionAdapter(alphabetOption,AlphabeticTestSorborno.this);
                gridAlphabeticTestOption.setAdapter(alphabeticTestOptionAdapter);
                textToSpechHelper.speeak("নিচ থেকে কোন অক্ষরটি এখানে বসবে? সেটার উপর চাপ দাও।");
            }
        });




        gridAlphabeticTestOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String alphabet = alhpabet[lastClickIndex];
                String optionAlphabet = alphabetOption[i];
                if (alphabet.equals(optionAlphabet)){
                    textToSpechHelper.speeak("মাশাআল্লাহ, তোমার উত্তরটি সঠিক হয়েছে। এই অক্ষরটি হলো, "+alphabet);
                    tvBlankText.setText(alhpabet[lastClickIndex]);
                    tvBlankText.setBackgroundColor(Color.GREEN);
                    Toasty.success(AlphabeticTestSorborno.this,"মাশাআল্লাহ, তোমার উত্তরটি সঠিক হয়েছে। এই অক্ষরটি হলো",Toast.LENGTH_SHORT,true).show();
                }else{
                    TextView tv = view.findViewById(R.id.tv_alphabet);
                    tv.setTextColor(Color.WHITE);
                    tv.setBackgroundColor(Color.RED);
                    textToSpechHelper.speeak("ভুল অক্ষর সিলেক্ট করেছো। সঠিক অক্ষরটি সিলেক্ট করো।");

                    Toasty.error(AlphabeticTestSorborno.this, "Wrong Alphabet Selected.", Toast.LENGTH_SHORT, true).show();

                   // Toast.makeText(AlphabeticTestSorborno.this, "Wrong Alphabet Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static int getRandomValue(int Min, int Max)
    {
        return ThreadLocalRandom.current().nextInt(Min, Max);
    }
}