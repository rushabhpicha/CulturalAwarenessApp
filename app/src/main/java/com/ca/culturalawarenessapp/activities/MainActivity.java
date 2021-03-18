package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ca.culturalawarenessapp.R;
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
        /*

        Animation animFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        Animation animBounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        listView.startAnimation(animFade);
        listView.startAnimation((animBounce));

         */
        Animation up_from_bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        listView.startAnimation(up_from_bottom);


        // Main Menu of the app, which gives the direction to the user to access the app further.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                switch(position){
                    case 1:
                        Intent quiz = new Intent(MainActivity.this, QuizMainActivity.class);
                        startActivity(quiz);
                        break;
                    case 0:
                        Intent learn = new Intent(MainActivity.this, LearnMainActivity.class);
                        startActivity(learn);
                        break;
//                    case 2:
//                        Intent contribute = new Intent(MainActivity.this, ContributeActivity.class);
//                        startActivity(contribute);
//                        break;
                    case 2:
                        Intent culturalModelAndDimensions = new Intent(MainActivity.this, CulturalModelDimensions.class);
                        startActivity(culturalModelAndDimensions);
                        break;
                    case 3:
                        Intent diversityInclusionEquity = new Intent(MainActivity.this, DiversityInclusionEquity.class);
                        startActivity(diversityInclusionEquity);
                        break;
                    case 6:
                        openAboutUsDialog();
                        break;
                    case 5:
                        Intent help = new Intent(MainActivity.this, FeedbackActivity.class);
                        startActivity(help);
                        break;

                }
            }
        });
    }

    private void openAboutUsDialog() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(R.string.about_us_info).setPositiveButton("OK", dialogClickListener);

        AlertDialog alert = builder.create();
        alert.show();
    }
}
