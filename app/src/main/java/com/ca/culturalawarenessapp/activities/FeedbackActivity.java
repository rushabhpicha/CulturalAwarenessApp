package com.ca.culturalawarenessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ca.culturalawarenessapp.R;

public class FeedbackActivity extends AppCompatActivity {
    EditText nameField, emailField, feedbackField;
    CheckBox responseCheckbox;
    Button submit;
    String emailAddress, emailBody, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        nameField = (EditText) findViewById(R.id.EditText_Enter_your_name);
        name = nameField.getText().toString();

        emailField = (EditText) findViewById(R.id.EditText_Enter_your_Email);
        emailAddress = emailField.getText().toString();

        feedbackField = (EditText) findViewById(R.id.EditText_FeedbackBody);
        emailBody = feedbackField.getText().toString();

        responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        boolean isChecked = responseCheckbox.isChecked();

        submit=(Button)findViewById(R.id.ButtonSendFeedback);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    public void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"enmuheidat@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        i.putExtra(Intent.EXTRA_TEXT, emailBody);//message is your details
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FeedbackActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

