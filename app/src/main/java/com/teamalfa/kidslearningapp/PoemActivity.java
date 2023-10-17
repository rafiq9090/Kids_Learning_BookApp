package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.teamalfa.kidslearningapp.adapter.PoemAdapter;

public class PoemActivity extends AppCompatActivity {
    ListView listPoem;
    String[] poemTitle;
    String[] poemDes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);
        getSupportActionBar().hide();
        listPoem = findViewById(R.id.list_poem);

        poemTitle = getResources().getStringArray(getIntent().getIntExtra("poemTitle",0));
        poemDes = getResources().getStringArray(getIntent().getIntExtra("poemDes",0));

        PoemAdapter poemAdapter = new PoemAdapter(poemTitle,poemDes,PoemActivity.this);
        listPoem.setAdapter(poemAdapter);
    }
}