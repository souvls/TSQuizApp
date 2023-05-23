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
import android.widget.Button;
import android.widget.TextView;

import com.example.tsquizversion002.Models.QuestionModels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_next;
    TextView txt_opA,txt_opB,txt_opC,txt_opD,txt_QT;
    CountDownTimer timer;
    ArrayList<QuestionModels>list = new ArrayList<>();
    int number = 1;
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
        txt_QT = (TextView) findViewById(R.id.txt_question);
        txt_opA = (TextView) findViewById(R.id.txt_optionA);
        txt_opB = (TextView) findViewById(R.id.txt_optionB);
        txt_opC = (TextView) findViewById(R.id.txt_optionC);
        txt_opD = (TextView) findViewById(R.id.txt_optionD);
        //btn_next = (Button) findViewById(R.id.btn_next);

        //play sound ________________________________________________________
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

        //add câu hỏi _______________________________________________________________-
        QuestionSetOne();
        bindingData(number);
        // btn next --------------------------------------------------------------
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number+=1;
                bindingData(number);
                resetButton();
            }
        });


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
    private void QuestionSetOne(){
        list.add(new QuestionModels("1+1=?","1","3","4","2"));
        list.add(new QuestionModels("1+2=?","1","2","4","3"));
        list.add(new QuestionModels("1+3=?","1","3","2","4"));
        list.add(new QuestionModels("1+4=?","1","3","4","5"));
        list.add(new QuestionModels("1+5=?","1","3","4","6"));
        list.add(new QuestionModels("1+6=?","1","3","4","7"));
        list.add(new QuestionModels("1+7=?","1","3","4","8"));
        list.add(new QuestionModels("1+8=?","1","3","4","9"));
        list.add(new QuestionModels("2+9=?","1","3","4","11"));
    }
    private void bindingData(int number){
        txt_QT.setText(list.get(number).getQuestion());
        txt_opA.setText(list.get(number).getOptionA());
        txt_opB.setText(list.get(number).getOptionB());
        txt_opC.setText(list.get(number).getOptionC());
        txt_opD.setText(list.get(number).getCorrectAnswer());
    }
    void resetButton(){
        btn_1.setBackgroundResource(R.drawable.btn_white);
        btn_2.setBackgroundResource(R.drawable.btn_white);
        btn_3.setBackgroundResource(R.drawable.btn_white);
        btn_4.setBackgroundResource(R.drawable.btn_white);
    }
}