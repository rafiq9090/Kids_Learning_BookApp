package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DoaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa);
        getSupportActionBar().hide();
    }
}