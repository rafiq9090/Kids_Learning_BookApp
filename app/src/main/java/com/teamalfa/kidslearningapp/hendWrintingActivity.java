package com.teamalfa.kidslearningapp;

import static com.teamalfa.kidslearningapp.DisplyPaint.colorlist;
import static com.teamalfa.kidslearningapp.DisplyPaint.current_brush;
import static com.teamalfa.kidslearningapp.DisplyPaint.pathlist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class hendWrintingActivity extends AppCompatActivity {

    public static Path path = new Path();

    public  static Paint paint_brush = new Paint();
    TextView tvHandWritingAlphabet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hend_wrinting);
        getSupportActionBar().hide();
        tvHandWritingAlphabet = findViewById(R.id.tv_hand_writing_alphabet);
        String alphabet = getIntent().getStringExtra("alphabet");
        tvHandWritingAlphabet.setText(alphabet);
    }





    public void ereser(View view) {
        pathlist.clear();
        colorlist.clear();
        path.reset();
    }
    public void pen(View view) {
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());
    }


    public void red(View view) {
        paint_brush.setColor(Color.RED);
        currentColor(paint_brush.getColor());
    }

    public void yellow(View view) {
        paint_brush.setColor(Color.YELLOW);
        currentColor(paint_brush.getColor());
    }

    public void blue(View view) {
        paint_brush.setColor(Color.BLUE);
        currentColor(paint_brush.getColor());
    }

    public void megenda(View view) {
        paint_brush.setColor(Color.MAGENTA);
        currentColor(paint_brush.getColor());
    }
    public void  currentColor(int c){
        current_brush =c;
        path = new Path();
    }

    @Override
    protected void onPause() {
        pathlist.clear();
        colorlist.clear();
        path.reset();
        super.onPause();
    }
}
