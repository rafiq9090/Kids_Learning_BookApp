package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.teamalfa.kidslearningapp.adapter.Dashboardlistadapter;

public class ArabicSubjectActivity extends AppCompatActivity {
    GridView gridArabicSubjectItem;
    String[] itemArabicSubjectText;
    int[] itemArabicSubjectImage;
    ImageArrayHelper imageArrayHelper= new ImageArrayHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_subject);
        gridArabicSubjectItem = findViewById(R.id.grid_arabic_subject_item);
        getSupportActionBar().hide();
        itemArabicSubjectText = getResources().getStringArray(R.array.item_arabic);
        itemArabicSubjectImage = imageArrayHelper.itemArabicSubjectImage;
        Dashboardlistadapter dashboardlistadapter =new Dashboardlistadapter(itemArabicSubjectText,itemArabicSubjectImage,ArabicSubjectActivity.this);
        gridArabicSubjectItem.setAdapter(dashboardlistadapter);

        gridArabicSubjectItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        callAlphabet(R.array.alphabet_arabic);
                        break;
                    case 1:
                        testAlphabet(R.array.alphabet_arabic);
                        break;
                }
            }
        });
    }
    void testAlphabet(int array){
        Intent intent = new Intent(ArabicSubjectActivity.this,AlphabeticTestSorborno.class);
        intent.putExtra("array",array);
        startActivity(intent);
    }

    void callAlphabet(int array){
        Intent intent = new Intent(ArabicSubjectActivity.this, AlphabetActivity.class);
        intent.putExtra("alphabet_array",array);
        startActivity(intent);
    }
}