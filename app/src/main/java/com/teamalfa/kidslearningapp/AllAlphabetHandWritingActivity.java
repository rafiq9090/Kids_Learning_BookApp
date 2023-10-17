package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.teamalfa.kidslearningapp.adapter.Dashboardlistadapter;

public class AllAlphabetHandWritingActivity extends AppCompatActivity {
    GridView gridAllAlphabetHandWriting;
    String[] itemText;
    int[] itemImage;
    ImageArrayHelper imageArrayHelper = new ImageArrayHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alphabet_hand_writing);
        gridAllAlphabetHandWriting = findViewById(R.id.grid_all_alphabet_hand_writing);
        getSupportActionBar().hide();

        itemImage = imageArrayHelper.itemHandWritingImage;
        itemText = getResources().getStringArray(R.array.item_hand_writing);

        Dashboardlistadapter dashboardlistadapter = new Dashboardlistadapter(itemText,itemImage,AllAlphabetHandWritingActivity.this);
        gridAllAlphabetHandWriting.setAdapter(dashboardlistadapter);

        gridAllAlphabetHandWriting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        callAlphabet(R.array.sorborno);
                        break;
                    case 1:
                        callAlphabet(R.array.benjonborno);
                        break;
                    case 2:
                        callAlphabet(R.array.alphabet_english_capital);
                        break;
                    case 3:
                        callAlphabet(R.array.alphabet_english_small);
                        break;
                    case 4:
                        callAlphabet(R.array.alphabet_arabic);
                        break;
                    case 5:
                        callAlphabet(R.array.math_sonkha_50);
                        break;
                    case 6:
                        callAlphabet(R.array.number_one_two_fifty);
                        break;
                }
            }
        });
    }
    void callAlphabet(int array){
        Intent intent = new Intent(AllAlphabetHandWritingActivity.this, AlphabetActivity.class);
        intent.putExtra("alphabet_array",array);
        intent.putExtra("isHandWrite",true);
        startActivity(intent);
    }
}