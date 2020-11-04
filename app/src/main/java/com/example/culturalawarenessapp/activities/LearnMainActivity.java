package com.example.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.culturalawarenessapp.R;

public class LearnMainActivity extends AppCompatActivity {

    ListView listView;
    String[] listItem;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_main);

        listView = findViewById(R.id.listview);
        listItem = getResources().getStringArray(R.array.quiz_menu);
        adapter = new ArrayAdapter<String>(LearnMainActivity.this,
                R.layout.list_item_activity_main, R.id.textview, listItem);
        listView.setAdapter(adapter);

        // Main Menu of the app, which gives the direction to the user to access the app further.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Intent learnMainActivity = new Intent(LearnMainActivity.this, LearnActivity.class);
                startActivity(learnMainActivity);
            }
        });
    }
}
