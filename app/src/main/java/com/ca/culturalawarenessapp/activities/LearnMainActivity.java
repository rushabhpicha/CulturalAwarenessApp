package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ca.culturalawarenessapp.R;
import com.ca.culturalawarenessapp.sqlite.LearnDbHelper;

import java.util.ArrayList;
import java.util.List;

public class LearnMainActivity extends AppCompatActivity {

    ListView listView;
    List<String> listItem;
    ArrayAdapter<String> adapter;
    LearnDbHelper learnDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_main);

        listView = findViewById(R.id.listview);
        learnDbHelper = LearnDbHelper.getInstance(LearnMainActivity.this);
        listItem = learnDbHelper.getCultureNames();
        adapter = new ArrayAdapter<String>(LearnMainActivity.this,
                R.layout.list_item_activity_main, R.id.textview, listItem);
        listView.setAdapter(adapter);

        // Main Menu of the app, which gives the direction to the user to access the app further.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String curCulture = listItem.get(position);
                Intent learnMainActivity = new Intent(LearnMainActivity.this, LearnActivity.class);

                System.out.println("Culture onCLick" +curCulture);

                learnMainActivity.putExtra("curCulture", curCulture );
                startActivity(learnMainActivity);
            }
        });
    }
}
