package com.example.welcome.ttcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class winPage extends AppCompatActivity {

    String string;
    public void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.winpage);
        Bundle str = getIntent().getExtras();
        string = str.getString("key");
        TextView obj = (TextView) findViewById(R.id.win_view);
        obj.setText(string);
    }

    public void onButtonClick(View view){
        Intent i = new Intent(winPage.this,MainActivity.class);
        startActivity(i);
    }

    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
