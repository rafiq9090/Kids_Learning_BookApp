package com.teamalfa.kidslearningapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.teamalfa.kidslearningapp.adapter.AlphabetHorizonatlGridView;

import java.util.Random;

public class AlphabetWithSentenceActivity extends AppCompatActivity {
    String[] alphabet;
    int[] alphabetImage;
    String[] alphabetSentence;
    TextView tvAlphabet,tvAlphabetSentence;
    ImageView imgAlphabetImage;
    GridView gridView;
    SplashActivity.TextToSpechHelper tts;
    Animation zoomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_with_sentence);
        tvAlphabet = findViewById(R.id.tv_alphabet);
        tvAlphabetSentence = findViewById(R.id.tv_alphabet_sentence);
        imgAlphabetImage = findViewById(R.id.img_alphabet_image);
        gridView = findViewById(R.id.gridView);


        alphabet = getResources().getStringArray(getIntent().getIntExtra("alphabet",0));
        alphabetSentence = getResources().getStringArray(getIntent().getIntExtra("alphabeticSentence",0));
        alphabetImage = getIntent().getIntArrayExtra("alphabeticImage");

        getSupportActionBar().hide();

        AlphabetHorizonatlGridView alphabetHorizonatlGridView = new AlphabetHorizonatlGridView(alphabet,AlphabetWithSentenceActivity.this);
        gridView.setAdapter(alphabetHorizonatlGridView);

        tvAlphabet.setText(alphabet[0]);
//        tvAlphabet.setAnimation(zoomAnim);
        tvAlphabetSentence.setText(alphabetSentence[0]);
        tvAlphabet.setTextColor(rendomColor());
        imgAlphabetImage.setImageResource(alphabetImage[0]);

        tts = new SplashActivity.TextToSpechHelper(AlphabetWithSentenceActivity.this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                zoomAnim = AnimationUtils.loadAnimation(AlphabetWithSentenceActivity.this,R.anim.zoom_alphabet);
                tvAlphabet.setText(alphabet[i]);
                tvAlphabetSentence.setText(alphabetSentence[i]);
                tvAlphabet.setTextColor(rendomColor());
                imgAlphabetImage.setImageResource(alphabetImage[i]);
                tvAlphabetSentence.setTextColor(rendomColor());
                tvAlphabet.setAnimation(zoomAnim);
                speekFuntion(i);
            }
        });
    }
    void speekFuntion(int i){
        String speekText = alphabet[i] +"। "+alphabet[i] +" তে, " + alphabetSentence[i]+"। "+alphabet[i] +"। "+alphabet[i] +" তে, " + alphabetSentence[i];
        tts.speeak(speekText);
    }

    public int rendomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(100));
        return color;
    }
}