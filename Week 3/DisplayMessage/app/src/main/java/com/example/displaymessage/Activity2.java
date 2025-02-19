package com.example.displaymessage;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        // Get the message from Intent
        Intent intent = getIntent();
        String userMessage = intent.getStringExtra(EXTRA_MESSAGE);

        // If userMessage is null or empty, set a default message
        if (userMessage == null || userMessage.isEmpty()) {
            userMessage = "No message entered!";
        }

        // Display combined message
        TextView textView = findViewById(R.id.result);
        textView.setText(userMessage);

        // Clickable link to Google
        TextView linkTextView = findViewById(R.id.linkTextView);
        linkTextView.setText("Click here to open Google");
        linkTextView.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(browserIntent);
        });

        // Reply back to MainActivity
        EditText replyEditText = findViewById(R.id.replyEditText);
        Button replyButton = findViewById(R.id.replyButton);

        replyButton.setOnClickListener(v -> {
            String replyMessage = replyEditText.getText().toString();
            Intent replyIntent = new Intent();
            replyIntent.putExtra("REPLY_MESSAGE", replyMessage);
            setResult(RESULT_OK, replyIntent);
            finish(); // Close Activity2
        });
    }
}
