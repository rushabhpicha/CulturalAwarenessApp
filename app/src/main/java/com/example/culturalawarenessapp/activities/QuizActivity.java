package com.example.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.culturalawarenessapp.R;

public class QuizActivity extends AppCompatActivity {

    String[] listItem;
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        listView = findViewById(R.id.listview);
        listItem = getResources().getStringArray(R.array.quiz_menu);
        adapter = new ArrayAdapter<String>(QuizActivity.this,
                R.layout.list_item_activity_main, R.id.textview, listItem);
        listView.setAdapter(adapter);
    }
}
