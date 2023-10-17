package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.teamalfa.kidslearningapp.adapter.Dashboardlistadapter;

public class EnglishSubjectActivity extends AppCompatActivity {
    GridView gridEnglisSubjectItem;
    String[] itemEnglishSubjectText;
    int[] itemEnglishSubjectImage;
    ImageArrayHelper imageArrayHelper= new ImageArrayHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_subject);
        gridEnglisSubjectItem = findViewById(R.id.grid_english_subject_item);
        getSupportActionBar().hide();
        itemEnglishSubjectText = getResources().getStringArray(R.array.item_english);
        itemEnglishSubjectImage = imageArrayHelper.itemEnglishSubjectImage;
        Dashboardlistadapter dashboardlistadapter =new Dashboardlistadapter(itemEnglishSubjectText,itemEnglishSubjectImage,EnglishSubjectActivity.this);
        gridEnglisSubjectItem.setAdapter(dashboardlistadapter);

        gridEnglisSubjectItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageArrayHelper imgArrayHelp = new ImageArrayHelper();
                switch (i){
                    case 0:
                        callAlphabet(R.array.alphabet_english_capital);
                        break;
                    case 1:
                        callAlphabet(R.array.alphabet_english_small);
                        break;
                    case 2:
                        callAlphabeticSentence(R.array.alphabet_english_capital,R.array.alphabetic_sentence_english,imgArrayHelp.itemEnglishAlphabetImage);
                        break;
                    case 3:
                        testAlphabet(R.array.alphabet_english_capital);
                        break;
                    case 4:
                        testAlphabet(R.array.alphabet_english_small);
                        break;
                    case 5:
                        callDayMonth(R.array.day_english);
                        break;
                    case 6:
                        callDayMonth(R.array.month_english);
                        break;
                    case 7:
                        callDayMonth(R.array.seasons_english);
                        break;
                }
            }
        });
    }
    void testAlphabet(int array){
        Intent intent = new Intent(EnglishSubjectActivity.this,AlphabeticTestSorborno.class);
        intent.putExtra("array",array);
        startActivity(intent);
    }

    void callAlphabet(int array){
        Intent intent = new Intent(EnglishSubjectActivity.this, AlphabetActivity.class);
        intent.putExtra("alphabet_array",array);
        startActivity(intent);
    }
    void callAlphabeticSentence(int alphabetArray, int alphabeticSentenceArray, int[] sentenceImageArray){
        Intent intent =  new Intent(EnglishSubjectActivity.this,AlphabetWithSentenceActivity.class);
        intent.putExtra("alphabet",alphabetArray);
        intent.putExtra("alphabeticSentence",alphabeticSentenceArray);
        intent.putExtra("alphabeticImage",sentenceImageArray);
        startActivity(intent);
    }
    void callDayMonth(int dayMonthArray){
        Intent intent = new Intent(EnglishSubjectActivity.this,DayMonthActivity.class);
        intent.putExtra("dayMonthArray",dayMonthArray);
        startActivity(intent);

    }
}