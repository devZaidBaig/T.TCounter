package com.example.welcome.ttcounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileOutputStream;


public class GameCounter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickgame);
        display(checkA());
        display1(checkB());
    }

    public int scoreA = 0,scoreB=0;

    public int checkA(){
        SharedPreferences obj = getSharedPreferences("save",MODE_PRIVATE);
        int tempA = obj.getInt("keyA",0);
        return tempA;
    }

    public int checkB(){
        SharedPreferences obj = getSharedPreferences("save",MODE_PRIVATE);
        int tempB = obj.getInt("keyB",0);
        return tempB;
    }

    public void getScoreA(View view){
        if(scoreA==0){
            scoreA=checkA();
            display(scoreA);
        }
        scoreA++;
        if(scoreA==11){
            String pone = "Player 1 wins...";
            Bundle obj = new Bundle();
            obj.putString("key",pone);
            Intent o = new Intent(GameCounter.this,winPage.class);
            o.putExtras(obj);
            startActivity(o);
        }
        display(scoreA);
    }

    public void getScoreB(View view){
        Log.d("TAG","save = "+checkA());
        Log.d("Tag","score = "+scoreB);
        if(scoreB==0){
            scoreB=checkB();
            display1(scoreB);
        }
        scoreB++;
        if(scoreB==11) {
            String pone = "Player 2 wins...";
            Bundle obj = new Bundle();
            obj.putString("key",pone);
            Intent o = new Intent(GameCounter.this,winPage.class);
            o.putExtras(obj);
            startActivity(o);
        }
        display1(scoreB);
    }

    public void display(int number){
        TextView obj = (TextView)findViewById(R.id.score_display);
        obj.setText(""+number);
    }

    public void display1(int number){
        TextView obj = (TextView)findViewById(R.id.score_display1);
        obj.setText(""+number);
    }

    public void onClickButton_2(View view){
        scoreA=0;
        scoreB=0;
        display(scoreA);
        display1(scoreB);

    }

    public void saveButton(View view){
        save(scoreA,scoreB);
        Toast.makeText(this, "The score has been saved...", Toast.LENGTH_SHORT).show();
    }

    public void getdeductA(View view){
        if(scoreA==0){
            display(scoreA);
        }
        else{
            scoreA--;
            display(scoreA);
        }
    }

    public void getdeductB(View view){
        if (scoreB==0){
            display1(scoreB);
        }
        else{
            scoreB--;
            display1(scoreB);
        }
    }

    public void save(int savea, int saveb){
        Log.d("TAG", "scores "+savea+saveb);
        SharedPreferences sharedPref = getSharedPreferences("save",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("keyA",savea);
        editor.putInt("keyB",saveb);
        editor.commit();
    }

}
