package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.ca.culturalawarenessapp.R;
import com.ca.culturalawarenessapp.adapters.LearnActivityAdapter;
import com.ca.culturalawarenessapp.datamodels.LearnDataModel;
import com.ca.culturalawarenessapp.sqlite.LearnDbHelper;

import java.util.ArrayList;
import java.util.List;

/*
    Author : Rushabh Picha
 */
public class LearnActivity extends AppCompatActivity {
    LearnDbHelper learnDbHelper;
    SQLiteDatabase sqLiteDatabase;
    public static List<LearnDataModel> learnDataModels;
    RecyclerView recyclerView;
    LearnActivityAdapter learnActivityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        recyclerView = findViewById(R.id.recyclerView);
        Intent intent = getIntent();
        String cultureName = intent.getStringExtra("curCulture");
        System.out.println("culture" +cultureName);
        learnDbHelper = LearnDbHelper.getInstance(LearnActivity.this);
        sqLiteDatabase = learnDbHelper.getWritableDatabase();

        learnDataModels = learnDbHelper.getLearnInfo(cultureName);
//        System.out.println("LearnDataModels data through the database" +learnDataModels.get(1).getInfo());

        learnActivityAdapter = new LearnActivityAdapter((ArrayList<LearnDataModel>) learnDataModels, this); // Instance of RecycleAdapter
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this); // Instance of LayoutManager
        recyclerView.setLayoutManager(mLayoutManager); // setting the LayoutManager to the RecyclerView
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // Setting the Default Animation for RV.
        recyclerView.setAdapter(learnActivityAdapter);

    }
}
