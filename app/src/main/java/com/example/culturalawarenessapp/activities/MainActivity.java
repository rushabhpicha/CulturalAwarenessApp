package com.example.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.culturalawarenessapp.R;
/*
    Author : Rushabh Picha
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] listItem;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        listItem = getResources().getStringArray(R.array.main_menu);
        adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.list_item_activity_main, R.id.textview, listItem);
        listView.setAdapter(adapter);

        // Main Menu of the app, which gives the direction to the user to access the app further.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                switch(position){
                    case 0:
                        Intent quiz = new Intent(MainActivity.this, QuizMainActivity.class);
                        startActivity(quiz);
                        break;
                    case 1:
                        Intent learn = new Intent(MainActivity.this, LearnMainActivity.class);
                        startActivity(learn);
                        break;
                    case 2:
                        Intent contribute = new Intent(MainActivity.this, ContributeActivity.class);
                        startActivity(contribute);
                        break;
                    case 3:
                        Intent about_us = new Intent(MainActivity.this, AboutUsActivity.class);
                        startActivity(about_us);
                        break;
                    case 4:
                        Intent help = new Intent(MainActivity.this, HelpActivity.class);
                        startActivity(help);
                        break;
                }
            }
        });
    }
}
