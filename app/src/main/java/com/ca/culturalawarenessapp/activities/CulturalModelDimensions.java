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
    private String environmentInfo = "Can individuals and groups shape their own destiny?\n\n" +
            "Control Orientation / Harmony Orientation / Constraint Orientation\n\n" +
            "(1) Control Orientation: Individuals and groups can shape their own destiny.\n\n" +
            "(2) Harmony Orientation: People are an integral part of the social environment. " +
            "Harmonious relations with the world and with others are important.\n\n" +
            "(3) Constraint Orientation: Events are determined by external forces (chance, luck, or " +
            "supernatural forces) \n\n";
    private String environmentModuleString = "North America (U.S.A. and canada)\n "+bullet+" Control (Can-do attitue)\n\n" +
            " Latin America\n "+bullet+" Constraint " +
            "Orientation\n "+bullet+" Harmony & Constraint\n\n" +
            "Western Europe\n "+bullet+" Control & Harmony\n\n" +
            "Eastern Europe\n "+bullet+" Constraint Orientation\n\n" +
            "Middle East\n "+bullet+" Constraint Orientation\n\n";

    private String timeModuleInfo = "How individuals perceive the nature of time and its use?\n\n" +
            "(1) Single-Focused Cultures/ Multi-Focused Cultures\n" +
            "\t\t(a) Single-Focused Cultures: Do one task at a time and meeting set deadlines.\n" +
            "\t\t(b) Multi-Focused Cultures: Do multiple tasks simultaneously.\n\n" +
            "(2) Fixed-Time Orientation/ Fluid-Time Orientation\n" +
            "\t\t(a) Fixed-Time Orientation: Time is money. Punctuality and good time management\n" +
            "\t\t(b) Fluid-Time Orientation: Time is perceived to be an organic flowing process.\n" +
            "Delays are expected, deadlines and commitments on timing are endowed with a" +
            "great deal of flexibility.\n\n" +
            "(3) Past Orientation /Present Orientation /Future Orientation\n" +
            "\t\t(a) Past Orientation: Maintaining historical continuity has a high value. Plans for\n" +
            "change need to fit with what has happened previously and long time frames.\n" +
            "\t\t(b) Present Orientation: aims for quick results and stress the current goals.\n" +
            "\t\t(c) Future Orientation: willing to trade short-term gains for long-term results.\n\n ";

    private String timeModuleString = "North America (U.S.A. and canada)\n "+bullet+" Single-focussed\n "+bullet+" Fixed-Time Orientation\n "+bullet+" Present Orientation\n\n" +
            "Latin America\n "+bullet+" Multi-Focused\n "+bullet+" Fluid-Time Orientation\n "+bullet+" Present Orientation\n\n" +
            "Asia\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed- & Fluid-Time Orientation·\n "+bullet+" Past & Future Orientation \n\n" +
            "Western Europe\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed-Time Orientation·\n "+bullet+" Past & Future Orientation \n\n" +
            "Eastern Europe\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed- & Fluid-Time Orientation ·\n "+bullet+" Future Orientation \n\n" +
            "Middle-East\n "+bullet+" Multi-Focused\n "+bullet+" Fluid-Time Orientation ·\n "+bullet+" Past Orientation \n\n";

    private String actionModuleInfo = "How individuals view actions and interactions? Doing / Being\n\n" +
            "(1) Doing: Task-driven. Performance is measured against set standards and rewarded.\n\n" +
            "(2) Being: Relationship-driven. Affiliation, character, personal quality, and relationship" +
            "are valued. Getting to know each other.\n\n";

    private String actionModuleString = "North America (U.S.A. and canada)\n "+bullet+" Doing\n\n" +
            " Latin America\n "+bullet+" Being " +
            "Asia\n "+bullet+" Being\n\n" +
            "Western Europe\n "+bullet+" Being & Doing\n\n" +
            "Eastern Europe\n "+bullet+" Being & Doing\n\n" +
            "Middle East\n "+bullet+" Being\n\n";


    private String spaceModuleInfo = "How individuals demarcate their physical and psychological space?\n\n" +
            "Public-Oriented Cultures / Private-Oriented Cultures\n\n" +
            "(1) Public-Oriented Cultures: Value open access and accessibility. Close physical proximity" +
            "is sought, relationship building is important, and information is shared on a \"good to " +
            "know\" basis.\n\n" +
            "(2) Private-Oriented Cultures: Value the clear demarcation of boundaries and their respectful" +
            "treatment, and information is shared on a \"need to know\" basis. \n\n";

    private String spaceModuleString = "North America (U.S.A. and canada)\n "+bullet+" Private-Oriented\n\n" +
            " Latin America\n "+bullet+" Private & Public-Oriented " +
            "Asia\n "+bullet+" Mixed Public- & Private-Oriented\n\n" +
            "Western Europe\n "+bullet+" Private & Public-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Being \n\n" +
            "Middle East\n "+bullet+" Being\n\n";

    private String powerModuleInfo = "How individuals view differential power relationships?\n\n" +
            "Hierarchy-Oriented Cultures/ Equality-Oriented Cultures\n\n" +
            "(I) Hierarchy-Oriented Cultures: Value social stratification and accept differing degrees of" +
            "power, status, and authority.\n\n" +
            "(2) Equality-Oriented Cultures: Value the reduction of hierarchy. Power and privileges must" +
            "earned and to some extent shared. Prefer the impersonal authority of mutually agreed upon goals" +
            " and objectives rather than the arbitrary power of a superior. \n\n";

    private String powerModuleString = "North America (U.S.A. and canada)\n "+bullet+" Mixed Equality- & Hierarchy-Oriented \n\n" +
            "Latin America\n "+bullet+" Hierarchy-Oriented " +
            "Asia\n "+bullet+" Hierarchy-Oriented \n\n" +
            "Western Europe\n "+bullet+" Hierarchy-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Equality- & Hierarchy-Oriented  \n\n" +
            "Middle East\n "+bullet+" Hierarchy-Oriented \n\n";

    private String individualismModuleInfo = "How individuals define their identity?\n\n" +
            "(1) Individualistic Cultures/ Collectivist Cultures\n\n" +
            "\t\t(a) Individualistic Cultures: focus on the individual person and her or his achievement" +
            "(individual skills, contributions, and talent). View conflict as inevitable.\n\n" +
            "\t\t(b) Collectivist Cultures: Value the subordination of individual interests to those of the" +
            "group and harmony rather than conflict. Group decisions take precedence over" +
            "individual decisions.\n\n" +
            "(2) Universalistic Cultures/Particularistic Cultures\n\n" +
            "\t\t(a) Universalistic Cultures: apply consistent universal principles, rules, process," +
            "procedures, and law. \"One size fits all\" approach.\n\n" +
            "\t\t(b) Particularistic (or situation oriented) Cultures: emphasize difference, uniqueness," +
            "exception, condition, and specific situation.\n\n";

    private String individualismModuleString = "North America (U.S.A. and canada)\n "+bullet+" Individualistic\n "+bullet+" Universalistic (Equal application of rules) \n\n " +
            "Latin America\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Asia\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Western Europe\n "+bullet+" Individualistic\n "+bullet+" Universalistic & Particularistic \n\n " +
            "Eastern Europe\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Middle East\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n ";

    private String competitivenessModuleInfo = "How individuals are motivated?\n" +
            "Competitive Cultures / Cooperative Cultures\n\n" +
            "\t\t(1) Competitive Cultures: Value competition for resources for material success (the" +
            "acquisition and accumulation of wealth, property, goods, fame, expertise, and others)" +
            "and value ambition, assertiveness, initiative, performance, and excellence.\n" +
            "\t\t\t\t "+bullet+"Competitiveness on the individual level: the desire to outperfonn other individuals.\n" +
            "\t\t\t\t "+bullet+" Competitiveness on the group level: the desire to outperform rival group.\n\n" +
            "(2) Competitive Cultures value sympathy, numing, and relationships focusing on quality of" +
            "life \n\n";

    private String competitivenessModuleString = "North America (U.S.A. and canada)\n "+bullet+" Competitive \n\n" +
            " Latin America\n "+bullet+" Cooperative & Competitive  " +
            "Asia\n "+bullet+" Cooperative \n\n" +
            "Western Europe\n "+bullet+" Competitive \n\n" +
            "Eastern Europe\n "+bullet+" Cooperative  \n\n" +
            "Middle East\n "+bullet+" Competitive \n\n";

    private String structureModuleInfo = "How individuals approach change, risk, ambiguity, and uncertainty?\n\n" +
            "Order-Oriented and Flexibility-Oriented \n\n" +
            "\t\t(1) Order-Oriented Cultures: Seek certainty and value security, predictability, and clarity." +
            "Resist change and risk.\n\n" +
            "\t\t(2) Flexibility-Oriented Clutures: Tolerate uncertainty, conflict, and risk and continually" +
            "search for alternative ways of getting things done. \n\n";

    private String structureModuleString = "North America (U.S.A. and canada)\n "+bullet+" Flexibility-Oriented \n\n" +
            " Latin America\n "+bullet+" Order- & Flexibility-Oriented " +
            "Asia\n "+bullet+" Order-Oriented \n\n" +
            "Western Europe\n "+bullet+" Order- & Flexibility-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Order-Oriented   \n\n" +
            "Middle East\n "+bullet+" Order-Oriented \n\n";

    private String thinkingModuleInfo = "How individuals conceptualize?\n\n" +
            " (1) Deductive-Oriented Cultures and Inductive-Oriented Cultures\n\n" +
            " \t\t(a) Deductive-Oriented Cultures (top-down): Emphasize abstract thinking. Appeal is" +
            "made to theories and principles that have produced results in the past or are expected" +
            "to produce results in the future\n\n." +
            "\t\t (b) Deductive-Oriented Cultures (bottom-up): Derive principles and theories from the" +
            "analysis of data (facts, empirical observations, and experimentation). Guided less by" +
            "the past or future than by the present).\n\n" +
            "(2) Linear-Oriented Cultures and Systemic-Oriented Cultures\n\n" +
            "\t\t(a) Linear-Oriented Cultures: Dissect a problem or an issue into more manageable small" +
            "pieces. Emphasize detail, precision, and pragmatic results.\n" +
            "\t\t(b) Systemic-Oriented Cultures: Stress on integrated (holistic or synthetic) approach\n" +
            "focusing on relationships and connections among parts. \n\n";

    private String thinkingModuleString = "North America (U.S.A. and canada)\n "+bullet+" Inductive-Oriented \n "+bullet+" Linear- Oriented  \n\n " +
            "Latin America\n "+bullet+" Deductive-Oriented \n "+bullet+" Systemic-Oriented  \n\n " +
            "Asia\n "+bullet+" Deductive- & Inductive-Oriented\n "+bullet+" Systemic-Oriented  \n\n " +
            "Western Europe\n "+bullet+" Deductive- & Inductive-Oriented\n "+bullet+" Linear- & Systemic-Oriented  \n\n " +
            "Eastern Europe\n "+bullet+" Deductive- & Inductive-Oriented \n "+bullet+" Linear- & Systemic-Oriented  \n\n " +
            "Middle East\n "+bullet+" Deductive-Oriented \n "+bullet+" Systemic-Oriented \n\n ";

    private String communicationModuleInfo = "How individuals express themselves?\n\n" +
            "(1) High-Context/ Low-Context\n\n" +
            "\t\t a) High-Context: Implicit and less literal communication. Nonverbal communication\n" +
            "is valued (body language, voice tone, facial expressions, use of silence).\n\n" +
            "\t\t(b) Low-Context: Explicit and literal communication. Specificity and accuracy in word\n" +
            "usage are highly valued.\n\n" +
            "(2) Direct Communication/reel Communication \n\n"+
            "\t\t(a) Direct Communication: Speak one's mind in a straightforward way. Conflict," +
            "tension, and frank feedback are viewed as constructive and important.\n\n" +
            "\t\t(b) Indirect Communication : Conflict avoidance and saving face are valued.\n\n" +
            "\t\t(3) Expressive Cultures / Instrumental Cultures\n" +
            "(a)Expressive Cultures: Emotional connectedness through display and accentuation of" +
            "emotions is valued.\n" +
            "\t\t(b) Instrumental Cultures: Reduction (or elimination) of emotion and accuracy of\n" +
            "communication are valued. Communication is problem-centered. rational. and issueoriented with factual details.\n\n" +
            "(4)Formal Cultures/Informal Cultures\n" +
            "\t\t(a) Formal Cultures: place a high value on etiquette, protocol, and ritualistic exchanges\n" +
            "(dress, greetings. and forms of address).\n" +
            "\t\t(b) Informal Cultures: View etiquette and protocol as a barrier to communication and\n" +
            "relationship.\n\n";

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
        openAlertDialog(environmentInfo + environmentModuleString, "Environment");
    }

    private void timeModule() {
        openAlertDialog(timeModuleInfo + timeModuleString, "Time");
    }

    private void actionModule() {
        openAlertDialog(actionModuleInfo + actionModuleString, "Action");
    }

    private void communicationModule(){
        openAlertDialog(communicationModuleInfo + communicationModuleString, "Communication");
    }

    private void spaceModule(){
        openAlertDialog(spaceModuleInfo + spaceModuleString, "Space");
    }

    private void powerModule(){
        openAlertDialog(powerModuleInfo + powerModuleString, "Power");
    }

    private void individualismModule(){
        openAlertDialog(individualismModuleInfo + individualismModuleString, "Indidualism");
    }

    private void competitivenessModule(){
        openAlertDialog(competitivenessModuleInfo + competitivenessModuleString, "Competitiveness");
    }

    private void structureModule(){
        openAlertDialog(structureModuleInfo + structureModuleString, "Structure");
    }

    private void thinkingModule(){
        openAlertDialog(thinkingModuleInfo + thinkingModuleString, "Thinking");
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
