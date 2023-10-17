package com.teamalfa.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    Animation anim;
    TextView tvSoro, tvA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tvSoro = findViewById(R.id.tv_soro);
        tvA = findViewById(R.id.tv_a);
        getSupportActionBar().hide();

        anim = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.rotation_animation);
        tvSoro.setAnimation(anim);
        tvA.setAnimation(anim);

        Thread th = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3500);
                    startActivity(new Intent(SplashActivity.this,DashboardActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }

        };
        th.start();

    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    public static class TextToSpechHelper {
        Context context;
        TextToSpeech textToSpeech;

        public TextToSpechHelper(Context context) {
            this.context = context;
        }

        public void speeak(String text){
            textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i==TextToSpeech.SUCCESS){
                        int result = textToSpeech.setLanguage(new Locale("bn_BD"));
                        if (result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED){
                            Toast.makeText(context, "Language Not Supported", Toast.LENGTH_SHORT).show();
                        }else {
                            textToSpeech.setSpeechRate(.8f);
                            if (textToSpeech.isSpeaking()){
                            }else{
                                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);
                            }
                        }
                    }
                }
            });
        }
    }
}