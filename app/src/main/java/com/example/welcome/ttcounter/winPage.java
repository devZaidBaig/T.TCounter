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

        TextView t = (TextView)findViewById(R.id.res_button);
        t.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent t = new Intent(winPage.this,MainActivity.class);
                startActivity(t);
            }
        });
    }


    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
