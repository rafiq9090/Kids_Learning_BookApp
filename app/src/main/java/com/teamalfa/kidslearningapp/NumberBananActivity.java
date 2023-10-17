package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.teamalfa.kidslearningapp.adapter.NumberBananAdapter;

public class NumberBananActivity extends AppCompatActivity {

    String[] number;
    String[] nBanan;

    GridView gridNumberBanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_banan);
        gridNumberBanan = findViewById(R.id.grid_number_banan);
        SplashActivity.TextToSpechHelper textToSpeechHelper = new SplashActivity.TextToSpechHelper(NumberBananActivity.this);
        number = getResources().getStringArray(getIntent().getIntExtra("number",0));
        nBanan = getResources().getStringArray(getIntent().getIntExtra("number_banan",0));

        NumberBananAdapter numberBananAdapter = new NumberBananAdapter(number,nBanan,NumberBananActivity.this);
        gridNumberBanan.setAdapter(numberBananAdapter);

        gridNumberBanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textToSpeechHelper.speeak(nBanan[i]);
            }
        });

    }
}