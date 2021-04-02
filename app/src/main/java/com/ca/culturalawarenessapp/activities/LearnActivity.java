package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ca.culturalawarenessapp.R;
import com.ca.culturalawarenessapp.adapters.LearnActivityAdapter;
import com.ca.culturalawarenessapp.datamodels.LearnDataModel;
import com.ca.culturalawarenessapp.sqlite.LearnDbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
    FloatingActionButton floatingActionButton;
    String cultureName = "";
    String youTubeUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        floatingActionButton = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        Intent intent = getIntent();
        cultureName = intent.getStringExtra("curCulture");

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

        if(cultureName.equals("Asian")) youTubeUrl = "9DmCYV45LmI";
        else if(cultureName.equals("American")) youTubeUrl = "tLTCXNqjiE8";
        else if(cultureName.equals("Indian")) youTubeUrl = "lK3oqU2WNY0";
        else if(cultureName.equals("Latin")) youTubeUrl = "RGtSx1vA33s";
        else if(cultureName.equals("Europe")) youTubeUrl = "NutQz-MkVYQ";


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean connected = checkInternetConnection();
                if(connected){
                    Intent webView = new Intent(LearnActivity.this, WebViewActivity.class);
                    webView.putExtra("youtube_url", youTubeUrl);
                    startActivity(webView);
                }
                else{
                    Toast.makeText(LearnActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean checkInternetConnection(){
        boolean connected;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;

        return connected;
    }
}
