package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.teamalfa.kidslearningapp.adapter.Dashboardlistadapter;

public class MathSubjectActivity extends AppCompatActivity {
    GridView gridMathSubjectItem;
    String[] itemMathSubjectText;
    int[] itemMathSubjectImage;
    ImageArrayHelper imageArrayHelper= new ImageArrayHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_subject);
        gridMathSubjectItem = findViewById(R.id.grid_math_subject_item);
        getSupportActionBar().hide();
        itemMathSubjectText = getResources().getStringArray(R.array.item_math);
        itemMathSubjectImage = imageArrayHelper.itemMathSubjectImage;
        Dashboardlistadapter dashboardlistadapter =new Dashboardlistadapter(itemMathSubjectText,itemMathSubjectImage,MathSubjectActivity.this);
        gridMathSubjectItem.setAdapter(dashboardlistadapter);

        gridMathSubjectItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        callAlphabet(R.array.math_sonkha_50);
                        break;
                    case 1:
                        callAlphabet(R.array.number_one_two_fifty);
                        break;
                    case 2:
                        numberSpell(R.array.math_sonkha_50,R.array.sonkha_banan);
                        break;
                    case 3:
                        numberSpell(R.array.number_one_two_fifty,R.array.number_banan);
                        break;
                    case 4:
                        callAlphabet(R.array.math_sonkha_even);
                        break;
                    case 5:
                        callAlphabet(R.array.number_even);
                        break;
                    case 6:
                        callAlphabet(R.array.math_sonkha_odd);
                        break;
                    case 7:
                        callAlphabet(R.array.number_odd);
                        break;
                    case 8:
                        testAlphabet(R.array.math_sonkha_50);
                        break;
                    case 9:
                        testAlphabet(R.array.number_one_two_fifty);
                        break;
                    case 10:
                        testAlphabet(R.array.math_sonkha_even);
                        break;
                    case 11:
                        testAlphabet(R.array.number_even);
                        break;
                    case 12:
                        testAlphabet(R.array.math_sonkha_odd);
                        break;
                    case 13:
                        testAlphabet(R.array.number_odd);
                        break;
                }
            }
        });
    }
    void testAlphabet(int array){
        Intent intent = new Intent(MathSubjectActivity.this,AlphabeticTestSorborno.class);
        intent.putExtra("array",array);
        startActivity(intent);
    }

    void numberSpell(int array, int numberBanan){
        Intent intent = new Intent(MathSubjectActivity.this,NumberBananActivity.class);
        intent.putExtra("number",array);
        intent.putExtra("number_banan",numberBanan);
        startActivity(intent);
    }

    void callAlphabet(int array){
        Intent intent = new Intent(MathSubjectActivity.this, AlphabetActivity.class);
        intent.putExtra("alphabet_array",array);
        startActivity(intent);
    }
}