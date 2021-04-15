package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.ca.culturalawarenessapp.R;
import com.ca.culturalawarenessapp.sqlite.LearnDbHelper;

import java.util.Arrays;
import java.util.List;

public class DiversityInclusionEquity extends AppCompatActivity {
    ListView listView;
    List<String> listItem;
    ArrayAdapter<String> adapter;
    String diversityMessage = "The reality that people differ from each other in a variety of ways.  Diversity is typically associated with organizational innovation and progress.  Drawn from examples in biological adaptation, emerging social challenges are best met with strategies that can be found among people from different cultures and experiences tied to race, ethnicity, sexual orientation, age, language, gender, sex, or physical characteristic, etc.";
    String inclusionMessage = "The degree to which a group, institution, or organization promotes the participation of all individuals from all backgrounds and groups in decision-making and other practices.";
    String equityMessage = "An effort to enact fairness that works to ensure that everyone has access to equal results and outcomes regardless of their starting point. Equity is often contrasted with equality.";
    String culturalMessage = "A group’s social practices passed on within the group, often to enhance survival or wellbeing and preserve group identity.  Culture can include behaviors, ceremonies, relationship types, forms of communication, values, beliefs, food, clothing, and art.";
    String competanceMessage = "The ability to respond appropriately and affirmatively to people of varying cultures, ages, races, religions, sexual orientations, abilities, and ethnicities. ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diversity_inclusion_equity);

        listView = findViewById(R.id.listview);
        listItem = Arrays.asList(getResources().getStringArray(R.array.diversityItems));
        adapter = new ArrayAdapter<String>(DiversityInclusionEquity.this,
                R.layout.list_item_activity_main, R.id.button, listItem);
        listView.setAdapter(adapter);

        // Main Menu of the app, which gives the direction to the user to access the app further.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                switch(position){
                    case 0:
                        openAlertDialog(diversityMessage, "Diversity");
                        break;
                    case 1:
                        openAlertDialog(inclusionMessage, "Inclusion");
                        break;
                    case 2:
                        openAlertDialog(equityMessage, "Equity");
                        break;
                    case 3:
                        openAlertDialog(culturalMessage, "Cultural");
                        break;
                    case 4:
                        openAlertDialog(competanceMessage, "Cultural Competance");
                        break;
                }
            }
        });
    }

    private void openAlertDialog(String message, String title) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(DiversityInclusionEquity.this);
        builder.setMessage(message).setPositiveButton("OK", dialogClickListener).setTitle(title);

        AlertDialog alert = builder.create();
        alert.show();
    }
}