package com.example.tsquizversion002;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;

import com.example.tsquizversion002.Models.QuestionModels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CountDownTimer timer;
    ArrayList<QuestionModels>list = new ArrayList<>();
    int count = 0;
    int score = 0;
    private SoundPool soundPool;
    private ConstraintLayout btn_1,btn_2,btn_3,btn_4;
    private int s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = (ConstraintLayout) findViewById(R.id.btn_1);
        btn_2 = (ConstraintLayout) findViewById(R.id.btn_2);
        btn_3 = (ConstraintLayout) findViewById(R.id.btn_3);
        btn_4 = (ConstraintLayout) findViewById(R.id.btn_4);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool = new SoundPool(2,AudioAttributes.CONTENT_TYPE_SONIFICATION,0);
        }
        s1 = soundPool.load(this,R.raw.collect,1);
        s2 = soundPool.load(this,R.raw.wromg,1);
    }

    public void Anwser(View v){
        switch (v.getId()){
            case R.id.btn_1:
                btn_1.setBackgroundResource(R.drawable.btn_green);
                soundPool.play(s1,1,1,0,0,1);
                break;
            case R.id.btn_2:
                btn_2.setBackgroundResource(R.drawable.btn_red);
                soundPool.play(s2,1,1,0,0,1);
                break;
            case R.id.btn_3:
                btn_3.setBackgroundResource(R.drawable.btn_red);
                soundPool.play(s2,1,1,0,0,1);
                break;
            case R.id.btn_4:
                btn_4.setBackgroundResource(R.drawable.btn_red);
                soundPool.play(s2,1,1,0,0,1);
                break;
        }
        btn_1.setBackgroundResource(R.drawable.btn_green);
    }
}