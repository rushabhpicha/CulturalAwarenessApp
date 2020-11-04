package com.example.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.culturalawarenessapp.R;
import com.example.culturalawarenessapp.datamodels.QuestionModel;
import com.example.culturalawarenessapp.sqlite.QuizDbHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import static com.example.culturalawarenessapp.activities.QuizMainActivity.KEY_HIGH_SCORE;
import static com.example.culturalawarenessapp.activities.QuizMainActivity.SHARED_PREF;

/*
    Author - Rushabh Picha
    This Activity is the real game where the Quiz starts and the user faces the problems the database throws at him.
 */
public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 10000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillsLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keuQuestionList";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private TextView textViewCategory;
    private TextView textViewDifficulty;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<QuestionModel> questionModelList;
    private int questionCounter;
    private int questionCounterTotal;
    private QuestionModel currentQuestionModel;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.tvQuestion);
        textViewScore = findViewById(R.id.tvScore);
        textViewQuestionCount = findViewById(R.id.tvQuestionCount);
        textViewCountDown = findViewById(R.id.tvCountDown);
        textViewCategory = findViewById(R.id.tvCategory);
        textViewDifficulty = findViewById(R.id.tvDifficulty);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmNext = findViewById(R.id.btnConfirm);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        // Retrieving the information sent by the QuizMainActivity.
        Intent  intent = getIntent();
        int categoryID = intent.getIntExtra(QuizMainActivity.EXTRA_CATEGORY_ID, 0);
         String categoryName = intent.getStringExtra(QuizMainActivity.EXTRA_CATEGORY_NAME);
        String difficulty = intent.getStringExtra(QuizMainActivity.EXTRA_DIFFICULTY);

        textViewCategory.setText("Category: " + categoryName);
        textViewDifficulty.setText("Difficulty: " + difficulty);

        // We check here if the savedInstanceState is null or not. It will always be null when the activity is first
        // called
        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = QuizDbHelper.getInstance(this);
            questionModelList = dbHelper.getQuestions(categoryID, difficulty);
            questionCounterTotal = questionModelList.size();
            Collections.shuffle(questionModelList);

            showNextQuestion();
        } else {
            questionModelList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            if (questionModelList == null) {
                finish();
            }
            questionCounterTotal = questionModelList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestionModel = questionModelList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showSolution() {
        rb1.setTextColor(getResources().getColor(R.color.colorFalseAnswer));
        rb2.setTextColor(getResources().getColor(R.color.colorFalseAnswer));
        rb3.setTextColor(getResources().getColor(R.color.colorFalseAnswer));

        switch (currentQuestionModel.getAnswerNr()) {
            case 1:
                rb1.setTextColor(getResources().getColor(R.color.colorTrueAnswer));
                textViewQuestion.setText("Answer 1 is correct");
                break;

            case 2:
                rb2.setTextColor(getResources().getColor(R.color.colorTrueAnswer));
                textViewQuestion.setText("Answer 2 is correct");
                break;

            case 3:
                rb3.setTextColor(getResources().getColor(R.color.colorTrueAnswer));
                textViewQuestion.setText("Answer 3 is correct");
                break;
        }
        if (questionCounter < questionCounterTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }
    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCounterTotal) {
            currentQuestionModel = questionModelList.get(questionCounter);
            textViewQuestion.setText(currentQuestionModel.getQuestion());
            rb1.setText(currentQuestionModel.getOption1());
            rb2.setText(currentQuestionModel.getOption2());
            rb3.setText(currentQuestionModel.getOption3());

            questionCounter++;
            textViewQuestionCount.setText("QuestionModel: " + questionCounter + " / " + questionCounterTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int second = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, second);
        textViewCountDown.setText(timeFormatted);
    }

    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestionModel.getAnswerNr()) {
            score++;
            textViewScore.setText("Score: " + score);
        }
        showSolution();
    }


    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionModelList);

    }
}
