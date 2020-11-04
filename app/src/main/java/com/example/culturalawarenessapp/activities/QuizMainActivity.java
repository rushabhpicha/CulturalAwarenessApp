package com.example.culturalawarenessapp.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.culturalawarenessapp.R;
import com.example.culturalawarenessapp.datamodels.Category;
import com.example.culturalawarenessapp.datamodels.QuestionModel;
import com.example.culturalawarenessapp.sqlite.QuizDbHelper;

import java.util.List;

/*
    Author - Rushabh Picha
    This activity is the home to start your Quiz. This activity takes details about which culture you want to learn
    about and what difficulty you want to start off with.
 */
public class QuizMainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_QUIZ = 1;
    public  static final String EXTRA_CATEGORY_ID= "extraCategoryID";
    public  static final String EXTRA_CATEGORY_NAME = "extraCategoryName";
    public  static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String SHARED_PREF = "sharedPrefs";
    public static final String KEY_HIGH_SCORE = "keyHighScore";

    private TextView textViewHighScore;
    private Spinner spinnerDifficulty;
    private Spinner spinnerCategory;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        textViewHighScore = findViewById(R.id.tvHighScore);
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);
        spinnerCategory = findViewById(R.id.spinner_category);

        loadCategories();

        loadDifficultyLevels();

        loadHighScore();

        Button buttonStartQuiz = findViewById(R.id.btnStartQuiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }
    // onActivityResult is called back when user wants to come back to this activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode  , resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if(resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if(score > highScore) {
                    updateHighScore(score);
                }
            }
        }
    }

    /*
        This method takes the category and the difficulty level that the user enters and pass it onto the next
        QuizActivity class to retrieve approriate questions and start the quiz. We use putExtra method of the
        intent class to send the data.
     */
    private void startQuiz() {
        Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
        int categoryID = selectedCategory.getId();
        String categoryName = selectedCategory.getName();

        String difficulty = spinnerDifficulty.getSelectedItem().toString();
        System.out.println(difficulty);

        Intent intent = new Intent(QuizMainActivity.this, QuizActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
        intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }


    /* This method loads all the categories of cultures for the user to take the test upon. This method indirectly
        makes use of getAllCategories method defined in our QuizDbHelper class.
     */

    private  void loadCategories() {
        QuizDbHelper dbHelper = QuizDbHelper.getInstance(this);
        List<Category> categories = dbHelper.getAllCategories();

        Toast.makeText(this, ""+categories, Toast.LENGTH_SHORT).show();

        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryArrayAdapter);
    }

    /* The loadDifficultyLevels method gives the three types of difficulties associated with a question.
        It indirectly uses the getAllDifficultylevels() from the QuizDbHelper() class.
     */
    private void loadDifficultyLevels() {
        String[] difficultyLevels = QuestionModel.getAllDifficultyLevels();
        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);
    }

    /*
       This method updates the high score that the user has achieved till now.
       We use SharedPreferences to store the high score so that the score is always associated to
       the app whenever the user quits it.
     */

    private void loadHighScore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGH_SCORE, 0);
        textViewHighScore.setText("HighScore: " + highScore);
    }


    private void updateHighScore(int highScoreNew) {
        highScore = highScoreNew;
        textViewHighScore.setText("HighScore: " + highScore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGH_SCORE, highScore);
        editor.apply();
    }
}