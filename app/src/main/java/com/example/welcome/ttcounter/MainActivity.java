package com.example.welcome.ttcounter;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Boolean back = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView gamePage = (TextView)findViewById(R.id.quick_play);
        gamePage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent game = new Intent(MainActivity.this, GameCounter.class);
                startActivity(game);
            }
        });

        TextView text = (TextView)findViewById(R.id.load_play);
        text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent obj = new Intent(MainActivity.this,load.class);
                startActivity(obj);
            }
        } );
    }

    public void onBackPressed() {

        if (back == true){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
            startActivity(intent);
            finish();
            System.exit(0);
        }
        Toast.makeText(this, "Press back again...", Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                back = false;
            }
        },3000);
        back = true;

    }


}
