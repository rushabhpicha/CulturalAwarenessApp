package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ca.culturalawarenessapp.R;
/*
    Author : Rushabh Picha
 */
public class CulturalModelDimensions extends AppCompatActivity {

    ListView listView;
    String[] listItem;
    ArrayAdapter<String> adapter;
    String bullet = "\u2022";
    private String environmentModuleString = "North America (U.S.A. and canada)\n "+bullet+" Control (Can-do attitue)\n\n" +
            " Latin America\n "+bullet+" Constraint " +
            "Asia\n "+bullet+" Harmony & Constraint\n\n" +
            "Western Europe\n "+bullet+" Control & Harmony\n\n" +
            "Eastern Europe\n "+bullet+" Constraint\n\n" +
            "Middle East\n "+bullet+" Constraint\n\n";

    private String timeModuleString = "North America (U.S.A. and canada)\n "+bullet+" Single-focussed\n "+bullet+" Fixed-Time Orientation\n "+bullet+" Present Orientation\n\n" +
            "Latin America\n "+bullet+" Multi-Focused\n "+bullet+" Fluid-Time Orientation\n "+bullet+" Present Orientation\n\n" +
            "Asia\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed- & Fluid-Time Orientation·\n "+bullet+" Past & Future Orientation \n\n" +
            "Western Europe\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed-Time Orientation·\n "+bullet+" Past & Future Orientation \n\n" +
            "Eastern Europe\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed- & Fluid-Time Orientation ·\n "+bullet+" Future Orientation \n\n" +
            "Middle-East\n "+bullet+" Multi-Focused\n "+bullet+" Fluid-Time Orientation ·\n "+bullet+" Past Orientation \n\n";

    private String actionModuleString = "North America (U.S.A. and canada)\n "+bullet+" Doing\n\n" +
            " Latin America\n "+bullet+" Being " +
            "Asia\n "+bullet+" Being\n\n" +
            "Western Europe\n "+bullet+" Being & Doing\n\n" +
            "Eastern Europe\n "+bullet+" Being & Doing\n\n" +
            "Middle East\n "+bullet+" Being\n\n";

    private String spaceModuleString = "North America (U.S.A. and canada)\n "+bullet+" Private-Oriented\n\n" +
            " Latin America\n "+bullet+" Private & Public-Oriented " +
            "Asia\n "+bullet+" Mixed Public- & Private-Oriented\n\n" +
            "Western Europe\n "+bullet+" Private & Public-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Being \n\n" +
            "Middle East\n "+bullet+" Being\n\n";

    private String powerModuleString = "North America (U.S.A. and canada)\n "+bullet+" Mixed Equality- & Hierarchy-Oriented \n\n" +
            "Latin America\n "+bullet+" Hierarchy-Oriented " +
            "Asia\n "+bullet+" Hierarchy-Oriented \n\n" +
            "Western Europe\n "+bullet+" Hierarchy-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Equality- & Hierarchy-Oriented  \n\n" +
            "Middle East\n "+bullet+" Hierarchy-Oriented \n\n";

    private String individualismModuleString = "North America (U.S.A. and canada)\n "+bullet+" Individualistic\n "+bullet+" Universalistic (Equal application of rules) \n\n " +
            "Latin America\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Asia\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Western Europe\n "+bullet+" Individualistic\n "+bullet+" Universalistic & Particularistic \n\n " +
            "Eastern Europe\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Middle East\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n ";

    private String competitivenessModuleString = "North America (U.S.A. and canada)\n "+bullet+" Competitive \n\n" +
            " Latin America\n "+bullet+" Cooperative & Competitive  " +
            "Asia\n "+bullet+" Cooperative \n\n" +
            "Western Europe\n "+bullet+" Competitive \n\n" +
            "Eastern Europe\n "+bullet+" Cooperative  \n\n" +
            "Middle East\n "+bullet+" Competitive \n\n";

    private String structureModuleString = "North America (U.S.A. and canada)\n "+bullet+" Flexibility-Oriented \n\n" +
            " Latin America\n "+bullet+" Order- & Flexibility-Oriented " +
            "Asia\n "+bullet+" Order-Oriented \n\n" +
            "Western Europe\n "+bullet+" Order- & Flexibility-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Order-Oriented   \n\n" +
            "Middle East\n "+bullet+" Order-Oriented \n\n";

    private String thinkingModuleString = "North America (U.S.A. and canada)\n "+bullet+" Inductive-Oriented \n "+bullet+" Linear- Oriented  \n\n " +
            "Latin America\n "+bullet+" Deductive-Oriented \n "+bullet+" Systemic-Oriented  \n\n " +
            "Asia\n "+bullet+" Deductive- & Inductive-Oriented\n "+bullet+" Systemic-Oriented  \n\n " +
            "Western Europe\n "+bullet+" Deductive- & Inductive-Oriented\n "+bullet+" Linear- & Systemic-Oriented  \n\n " +
            "Eastern Europe\n "+bullet+" Deductive- & Inductive-Oriented \n "+bullet+" Linear- & Systemic-Oriented  \n\n " +
            "Middle East\n "+bullet+" Deductive-Oriented t\n "+bullet+" Systemic-Oriented \n\n ";

    private String communicationModuleString = "North America (U.S.A. and canada)\n "+bullet+" Low-Context \n "+bullet+" Direct\n "+bullet+" Instrumental\n " +bullet+" Informal\n\n "+
            "Latin America\n "+bullet+" High-Context \n "+bullet+" Direct\n "+bullet+" Instrumental\n " +bullet+" Informal\n\n "+
            "Asia\n "+bullet+" High-Context\n "+bullet+" Indirect\n "+bullet+" Instrumental \n " +bullet+" Formal\n\n "+
            "Western Europe\n "+bullet+" Low-Context & High-Context\n "+bullet+" Direct & Indirect\n "+bullet+" Expressive & Instrumental \n " +bullet+" Formal\n\n "+
            "Eastern Europe\n "+bullet+" High-Context\n "+bullet+" Direct & Indirect\n "+bullet+" Instrumental & Expressive\n " +bullet+" Formal\n\n "+
            "Middle East\n "+bullet+" High-Context\n "+bullet+" Direct & Indirect\n "+bullet+" Expressive \n " +bullet+" Formal\n\n ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_model_dimensions);

        listView = findViewById(R.id.cultural_model_listview);
        listItem = getResources().getStringArray(R.array.cultural_dimensions_model_menu);
        //Using list_item_activity_main to disgit remote rm githubplay the items in the list.
        adapter = new ArrayAdapter<String>(CulturalModelDimensions.this,
                R.layout.list_item_cultural_model_dimensions, R.id.textview, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        environmentModule();
                        break;
                    case 1:
                        timeModule();
                        break;
                    case 2:
                        actionModule();
                        break;
                    case 3:
                        communicationModule();
                        break;
                    case 4:
                        spaceModule();
                        break;
                    case 5:
                        powerModule();
                        break;
                    case 6:
                        individualismModule();
                        break;
                    case 7:
                        competitivenessModule();
                        break;
                    case 8:
                        structureModule();
                        break;
                    case 9:
                        thinkingModule();
                        break;
                }
            }
        });
    }

    private void environmentModule() {
        openAlertDialog(environmentModuleString, "Environment");
    }

    private void timeModule() {
        openAlertDialog(timeModuleString, "Time");
    }

    private void actionModule() {
        openAlertDialog(actionModuleString, "Action");
    }

    private void communicationModule(){
        openAlertDialog(communicationModuleString, "Communication");
    }

    private void spaceModule(){
        openAlertDialog(spaceModuleString, "Space");
    }

    private void powerModule(){
        openAlertDialog(powerModuleString, "Power");
    }

    private void individualismModule(){
        openAlertDialog(individualismModuleString, "Indidualism");
    }

    private void competitivenessModule(){
        openAlertDialog(competitivenessModuleString, "Competitiveness");
    }

    private void structureModule(){
        openAlertDialog(structureModuleString, "Structure");
    }

    private void thinkingModule(){
        openAlertDialog(thinkingModuleString, "Thinking");
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
        AlertDialog.Builder builder = new AlertDialog.Builder(CulturalModelDimensions.this);
        builder.setMessage(message).setPositiveButton("OK", dialogClickListener).setTitle(title);

        AlertDialog alert = builder.create();
        alert.show();
    }
}
