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
    private String environmentInfo = "Environment: Can individuals and groups can shape their own destiny?\n" +
            "Control Orientation / Harmony Orientation / Constraint Orientation\n\n" +
            "(1) Control Orientation: Individuals and groups can shape their own destiny.\n" +
            "(2) Harmony Orientation: People are an integral part of the social environment.\n" +
            "Harmonious relations with the world and with others are important.\n" +
            "(3) Constraint Orientation: Events ae determined by external forces (chance, luck, or" +
            "supernatural forces) \n\n";
    private String environmentModuleString = "North America (U.S.A. and canada)\n "+bullet+" Control (Can-do attitue)\n\n" +
            " Latin America\n "+bullet+" Constraint " +
            "Asia\n "+bullet+" Harmony & Constraint\n\n" +
            "Western Europe\n "+bullet+" Control & Harmony\n\n" +
            "Eastern Europe\n "+bullet+" Constraint\n\n" +
            "Middle East\n "+bullet+" Constraint\n\n";

    private String timeModuleInfo = "How individuals perceive the nature of time and its use?\n" +
            "(1) Single-Focused Cultures/ Multi-Focused Cultures\n" +
            "(a) Single-Focused Cultures: Do one task at a time and meeting set deadlines.\n" +
            "(b) Multi-Focused Cultures: Do multiple tasks simultaneously.\n" +
            "(2) Fixed-Time Orientation/ Fluid-Time Orientation\n" +
            "(a) Fixed-Time Orientation: Time is money. Punctuality and good time management\n" +
            "(b) Fluid-Time Orientation: Time is perceived to be an organic flowing process.\n" +
            "Delays are expected, deadlines and commitments on timing are endowed with a\n" +
            "great deal of flexibility.\n" +
            "(3) Past Orientation /Present Orientation /Future Orientation\n" +
            "(a) Past Orientation: Maintaining historical continuity has a high value. Plans for\n" +
            "change need to fit with what has happened previously and long time frames.\n" +
            "(b) Present Orientation: aims for quick results and stress the current goals.\n" +
            "(c) Future Orientation: willing to trade short-term gains for long-term results. ";

    private String timeModuleString = "North America (U.S.A. and canada)\n "+bullet+" Single-focussed\n "+bullet+" Fixed-Time Orientation\n "+bullet+" Present Orientation\n\n" +
            "Latin America\n "+bullet+" Multi-Focused\n "+bullet+" Fluid-Time Orientation\n "+bullet+" Present Orientation\n\n" +
            "Asia\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed- & Fluid-Time Orientation·\n "+bullet+" Past & Future Orientation \n\n" +
            "Western Europe\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed-Time Orientation·\n "+bullet+" Past & Future Orientation \n\n" +
            "Eastern Europe\n "+bullet+" Single-Focused and Multi-Focused\n "+bullet+" Fixed- & Fluid-Time Orientation ·\n "+bullet+" Future Orientation \n\n" +
            "Middle-East\n "+bullet+" Multi-Focused\n "+bullet+" Fluid-Time Orientation ·\n "+bullet+" Past Orientation \n\n";

    private String actionModuleInfo = "How individuals view actions and interactions? Doing / Being\n" +
            "(1) Doing: Task-driven. Performance is measured against set standards and rewarded.\n" +
            ". ;:)+ (2) Being: Relationship-driven. Affiliation, character, personal quality, and relationship\n" +
            "~,<>- are valued. \"Getting to know each other.\" ";

    private String actionModuleString = "North America (U.S.A. and canada)\n "+bullet+" Doing\n\n" +
            " Latin America\n "+bullet+" Being " +
            "Asia\n "+bullet+" Being\n\n" +
            "Western Europe\n "+bullet+" Being & Doing\n\n" +
            "Eastern Europe\n "+bullet+" Being & Doing\n\n" +
            "Middle East\n "+bullet+" Being\n\n";


    private String spaceModuleInfo = "How individuals demarcate their physical and psychological space?\n" +
            "Public-Oriented Cultures/ Private-Oriented Cultures\n" +
            "(I) Pub I ic-Oriented Cultures: value open access and accessibility. Close physical proximity\n" +
            "is sought, relationship building is important, and information is shared on a \"good to\n" +
            "know\" basis.\n" +
            "(2) Private-Oriented Cultures: value the clear demarcation of boundaries and their respectful\n" +
            "treatment, and information is shared on a \" need to know\" basis. ";

    private String spaceModuleString = "North America (U.S.A. and canada)\n "+bullet+" Private-Oriented\n\n" +
            " Latin America\n "+bullet+" Private & Public-Oriented " +
            "Asia\n "+bullet+" Mixed Public- & Private-Oriented\n\n" +
            "Western Europe\n "+bullet+" Private & Public-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Being \n\n" +
            "Middle East\n "+bullet+" Being\n\n";

    private String powerModuleInfo = "How individuals view differential power relationships?\n" +
            "Hierarchy-Oriented Cultures/ Equality-Oriented Cultures\n" +
            "(I) Hierarchy-Oriented Cultures: value social stratification and accept differing degrees of\n" +
            "power, status, and authority.\n" +
            "(2) Equality-Oriented Cultures: value the reduction of hierarchy. Power and privileges must\n" +
            "earned and to some extent shared. Prefer the impersonal authority of mutually agreedupon goals" +
            " and objectives rather than the arbitrary power of a superior. ";

    private String powerModuleString = "North America (U.S.A. and canada)\n "+bullet+" Mixed Equality- & Hierarchy-Oriented \n\n" +
            "Latin America\n "+bullet+" Hierarchy-Oriented " +
            "Asia\n "+bullet+" Hierarchy-Oriented \n\n" +
            "Western Europe\n "+bullet+" Hierarchy-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Equality- & Hierarchy-Oriented  \n\n" +
            "Middle East\n "+bullet+" Hierarchy-Oriented \n\n";

    private String individualismModuleInfo = "How individuals define their identity?\n" +
            "(I) Individualistic Cultures/ Collectivist Cultures\n" +
            "(a) Individualistic Cultures: focus on the individual person and her or his achievement\n" +
            "(individual skills, contributions, and talent). View conflict as inevitable.\n" +
            "t ~\"J (b) Collectivist Cultures: value the subordination of individual interests to those of the\n" +
            "l(\\(<, group and harmony rather than conflict. Group decisions take precedence over\n" +
            "individual decisions.\n" +
            "(2) Universalistic Cultures/ Particularistic Cultures\n" +
            "(a) Universalistic Cultures: apply consistent universal principles, rules, process,\n" +
            "procedures, and law. \"One size fits all\" approach.\n" +
            "(b) Particularistic (or situation oriented) Cultures: emphasize difference, uniqueness,\n" +
            "exception, condition, and specific situation.";

    private String individualismModuleString = "North America (U.S.A. and canada)\n "+bullet+" Individualistic\n "+bullet+" Universalistic (Equal application of rules) \n\n " +
            "Latin America\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Asia\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Western Europe\n "+bullet+" Individualistic\n "+bullet+" Universalistic & Particularistic \n\n " +
            "Eastern Europe\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n " +
            "Middle East\n "+bullet+" Collectivist\n "+bullet+" Particularistic \n\n ";

    private String CompetitivenessModuleInfo = "How individuals are motivated?\n" +
            "Competitive Cultures / Cooperative Cultures ( I ) Competitive Cultures: value competition for resources for material success ( the\n" +
            "acquisition and accumulation of wealth, property, goods, fame, expertise, and others)\n" +
            "and value ambition, assertiveness, initiative, performance, and excellence.\n" +
            "• Competitiveness on the individual level: the desire to outperfonn other individuals.\n" +
            "• Competitiveness on the group level: the desire to outperform rival group.\n" +
            "(2) Coopemtive CuJtocesc value sympathy, num\"ing, and celationships focusing on quality of\n" +
            "life (quaUty leisuce and cecceation, pe,sonal time, and time spent with the family";

    private String competitivenessModuleString = "North America (U.S.A. and canada)\n "+bullet+" Competitive \n\n" +
            " Latin America\n "+bullet+" Cooperative & Competitive  " +
            "Asia\n "+bullet+" Cooperative \n\n" +
            "Western Europe\n "+bullet+" Competitive \n\n" +
            "Eastern Europe\n "+bullet+" Cooperative  \n\n" +
            "Middle East\n "+bullet+" Competitive \n\n";

    private String structureModuleInfo = "How individuals approach change, risk, ambiguity, and uncertainty?\n" +
            "Order-Oriented I Flexibility-Oriented (I) O,de,-O,iented Culwes: soek ce,tainty and value secu,ity, predictability, and cladty.\n" +
            "Resist change and risk. (2) Flexib;rity-Odented Cultucesc Tolemnt uncertainty, conflict, and risk and continually\n" +
            "search for alternative ways of getting things done. ";

    private String structureModuleString = "North America (U.S.A. and canada)\n "+bullet+" Flexibility-Oriented \n\n" +
            " Latin America\n "+bullet+" Order- & Flexibility-Oriented " +
            "Asia\n "+bullet+" Order-Oriented \n\n" +
            "Western Europe\n "+bullet+" Order- & Flexibility-Oriented \n\n" +
            "Eastern Europe\n "+bullet+" Order-Oriented   \n\n" +
            "Middle East\n "+bullet+" Order-Oriented \n\n";

    private String thinkingModuleInfo = "How individuals conceptualize? (I) Deductive-Oriented Cultures I Inductive-Oriented Cultures (a) Oeductive-Odented Cultuces (\"top-down \"): emphasize abstract thinking. Appeal is\n" +
            "made to theories and principles that have produced results in the past or are expected\n" +
            "to produce results in the future . (b) fnductive-Oriented Cultures (\"bottom-up \"): derive principles and theories from the\n" +
            "analysis of data (facts, empirical observations, and experimentation). Guided less by\n" +
            "the past or future than by the present).\n" +
            "(2) Linear-Oriented Cultures I Systemic-Oriented Cultures\n" +
            "(a) Linear-Oriented Cultures: dissect a problem or an issue into more manageable small\n" +
            "pieces. Emphasize detail, precision, and pragmatic results.\n" +
            "(b) Syste'.11ic-Orient~d Cu!tures: stress on integrated (holistic or synthetic) approach\n" +
            "focusing on relat1onsh1ps and connections among parts. ";

    private String thinkingModuleString = "North America (U.S.A. and canada)\n "+bullet+" Inductive-Oriented \n "+bullet+" Linear- Oriented  \n\n " +
            "Latin America\n "+bullet+" Deductive-Oriented \n "+bullet+" Systemic-Oriented  \n\n " +
            "Asia\n "+bullet+" Deductive- & Inductive-Oriented\n "+bullet+" Systemic-Oriented  \n\n " +
            "Western Europe\n "+bullet+" Deductive- & Inductive-Oriented\n "+bullet+" Linear- & Systemic-Oriented  \n\n " +
            "Eastern Europe\n "+bullet+" Deductive- & Inductive-Oriented \n "+bullet+" Linear- & Systemic-Oriented  \n\n " +
            "Middle East\n "+bullet+" Deductive-Oriented t\n "+bullet+" Systemic-Oriented \n\n ";

    private String communicationModuleInfo = "How individuals express themselves?\n" +
            "(1) High-Context/ Low-Context\n" +
            "J:a) High-Context: Implicit and less literal communication. Nonverbal communication\n" +
            "is valued (body language, voice tone, facial expressions, use of silence).\n" +
            "(b) Low-Context: Explicit and literal communication. Specificity and accuracy in word\n" +
            "usage are highly valued.\n" +
            "(2) Direct Communication /_~reel Communication \n"+
            "(a) Direct Communication: Speak one 's mind in a straightforward way. Conflict,\n" +
            "tension, and frank feedback are viewed as constructive and important.\n" +
            "(b) Indirect Communication : Conflict avoidance and saving face are valued.\n" +
            "(3) Expressive Cultures / Instrumental Cultures\n" +
            "-------\n" +
            "(~s-i.ve Cultures: Emotional connectedness through display and accentuation of\n" +
            "· emotions is valued.\n" +
            "(b) Instrumental Cultures: Reduction (or elimination) of emotion and accuracy of\n" +
            "communication are valued. Communication is problem-centered. rational. and issueoriented with factual details.\n" +
            "(4) Formal Cultures/ Informal Cultures\n" +
            "~ --f'\"ormal Cultures: place a high value on etiquette, protocol, and ritualistic exchanges\n" +
            "( dress, greetings. and forms of address).\n" +
            "(b) Informal Cultures: view etiquette and protocol as a barrier to communication and\n" +
            "relationship. Empha";

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
        openAlertDialog(communicationModuleInfo + competitivenessModuleString, "Competitiveness");
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
