package com.example.welcome.ttcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.welcome.ttcounter.R.id.list_view;

/**
 * Created by Zaid on 11/22/2016.
 * A class for listview resource
 */

public class load extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savepage);

        //Array list initialization
        ArrayList<Word> obj = new ArrayList<Word>();
        obj.add(new Word("1"));
        obj.add(new Word("2"));
        obj.add(new Word("3"));
        obj.add(new Word("4"));

        WordAdapter adapter = new WordAdapter(this,obj);

        ListView list = (ListView)findViewById(R.id.list_view);

        list.setAdapter(adapter);


    }


}
