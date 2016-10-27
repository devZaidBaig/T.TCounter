package com.example.welcome.ttcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class GameCounter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickgame);
    }

    public int scoreA = 0,scoreB=0;

    public void getScoreA(View view){
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


}
