package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.teamalfa.kidslearningapp.adapter.NumberBananAdapter;

public class DayMonthActivity extends AppCompatActivity {

    ListView listView;

    String[] dayMonthArray;
    String[] number ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_month);

        getSupportActionBar().hide();

        listView = findViewById(R.id.itemView);


        number = getResources().getStringArray(R.array.math_sonkha_50);

        dayMonthArray = getResources().getStringArray(getIntent().getIntExtra("dayMonthArray",-1));
        NumberBananAdapter numberBananAdapter = new NumberBananAdapter(number,dayMonthArray,this,true);
        listView.setAdapter(numberBananAdapter);
    }
}