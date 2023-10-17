package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.teamalfa.kidslearningapp.adapter.AlphabetItemAdapter;

public class AlphabetActivity extends AppCompatActivity {
    GridView gridAlphabet;
    String[] alphabetText;
    boolean isHandWriting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        gridAlphabet = findViewById(R.id.grid_alphabet);
        getSupportActionBar().hide();
        int arrayInt = getIntent().getIntExtra("alphabet_array",0);
        alphabetText = getResources().getStringArray(arrayInt);
        isHandWriting = getIntent().getBooleanExtra("isHandWrite",false);
        if (isHandWriting){
            AlphabetItemAdapter alphabetItemAdapter = new AlphabetItemAdapter(alphabetText,AlphabetActivity.this,true);
            gridAlphabet.setAdapter(alphabetItemAdapter);
        }else{
            AlphabetItemAdapter alphabetItemAdapter = new AlphabetItemAdapter(alphabetText,AlphabetActivity.this);
            gridAlphabet.setAdapter(alphabetItemAdapter);
        }

    }
}