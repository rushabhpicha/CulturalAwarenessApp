package com.example.culturalawarenessapp.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.culturalawarenessapp.R;
import com.example.culturalawarenessapp.sqlite.ContributeDatabase;

public class ContributeActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView title, tculture_name, tculture_description;
    Button submit;

    private static ContributeDatabase contributeDatabase = null;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);

        toolbar = findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tculture_name = findViewById(R.id.tculture_name);
        tculture_description = findViewById(R.id.tculture_description);
        submit = findViewById(R.id.submit);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Display Back button on the Toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSubmit();
            }
        });
    }


    void processSubmit(){
        String stringCultureName = String.valueOf(tculture_name.getText());
        String stringCultureDescription = String.valueOf(tculture_description.getText());

        ContributeDatabase contributeDatabase = new ContributeDatabase(ContributeActivity.this);
        contributeDatabase.getWritableDatabase();
        contributeDatabase.insertData(stringCultureName, stringCultureDescription);
        tculture_name.setText("");
        tculture_description.setText("");
        contributeDatabase.close();
        Toast.makeText(this,"Data Entered Successfully!",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
