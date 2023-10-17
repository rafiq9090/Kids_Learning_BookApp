package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.teamalfa.kidslearningapp.adapter.Dashboardlistadapter;

public class BanglaActivity extends AppCompatActivity {
    GridView gridBanglaItem;
    String[] itemBanglaText;
    int[] itemBanglaImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla);
        gridBanglaItem = findViewById(R.id.grid_bangla_item);

        getSupportActionBar().hide();

        ImageArrayHelper imgArrayHelp = new ImageArrayHelper();

        itemBanglaImage = imgArrayHelp.itemBanglaSubjectImage;
        itemBanglaText = getResources().getStringArray(R.array.item_bangla);
        Dashboardlistadapter dashboardlistadapter =new Dashboardlistadapter(itemBanglaText,itemBanglaImage,BanglaActivity.this);
        gridBanglaItem.setAdapter(dashboardlistadapter);

        gridBanglaItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] alphabet;
                String[] alphabeticSentence;
                switch (i){
                    case 0:
                        callAlphabet(R.array.sorborno);
                        break;
                    case 1:
                        callAlphabet(R.array.benjonborno);
                        break;
                    case 2:
                        callAlphabeticSentence(R.array.sorborno, R.array.alphabetic_sentence_sorborno,imgArrayHelp.itemBanglaSorbornoAlphabeticImage);
                        break;
                    case 3:
                        callAlphabeticSentence(R.array.benjonborno, R.array.alphabetic_sentence_benjonbornno,imgArrayHelp.itemBanglaBenjonbornoAlphabeticImage);
                        break;
                    case 4:
                        testAlphabet(R.array.sorborno);
                        break;
                    case 5:
                        testAlphabet(R.array.benjonborno);
                        break;
                    case 6:
                        Intent intent = new Intent(BanglaActivity.this,PoemActivity.class);
                        intent.putExtra("poemTitle",R.array.bangla_poem_title);
                        intent.putExtra("poemDes",R.array.bangla_poem_des);
                        startActivity(intent);
                        break;
                    case 7:
                        callDayMonth(R.array.day_bangla);
                        break;
                    case 8:
                        callDayMonth(R.array.month_bangla);
                        break;
                    case 9:
                        callDayMonth(R.array.seasons_bangla);
                        break;
                }
            }
        });
    }
    void testAlphabet(int array){
        Intent intent = new Intent(BanglaActivity.this,AlphabeticTestSorborno.class);
        intent.putExtra("array",array);
        startActivity(intent);
    }

    void callAlphabet(int array){
        Intent intent = new Intent(BanglaActivity.this, AlphabetActivity.class);
        intent.putExtra("alphabet_array",array);
        startActivity(intent);
    }
    void callAlphabeticSentence(int alphabetArray, int alphabeticSentenceArray, int[] sentenceImageArray){
       Intent intent =  new Intent(BanglaActivity.this,AlphabetWithSentenceActivity.class);
       intent.putExtra("alphabet",alphabetArray);
       intent.putExtra("alphabeticSentence",alphabeticSentenceArray);
       intent.putExtra("alphabeticImage",sentenceImageArray);
       startActivity(intent);
    }

    void callDayMonth(int dayMonthArray){
        Intent intent = new Intent(BanglaActivity.this,DayMonthActivity.class);
        intent.putExtra("dayMonthArray",dayMonthArray);
        startActivity(intent);

    }

}