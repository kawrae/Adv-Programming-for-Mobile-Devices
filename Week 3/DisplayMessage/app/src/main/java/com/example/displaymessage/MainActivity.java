package com.example.displaymessage;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView replyTextView;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replyTextView = findViewById(R.id.replyTextView);

        // Register Activity Result Launcher
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String replyMessage = result.getData().getStringExtra("REPLY_MESSAGE");
                        replyTextView.setText("Reply from Activity2: " + replyMessage);
                    }
                }
        );

        // Yahoo link
        TextView yahooLink = findViewById(R.id.yahooLink);
        yahooLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yahoo.com"));
            startActivity(browserIntent);
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Activity2.class);

        // Get user input from EditText
        EditText editText = findViewById(R.id.msg);
        String userMessage = editText.getText().toString();

        // Create Teacher and Student objects
        Teacher teacher = new Teacher("Mr. Sajjad Bagheri", "Male", "University Lecturer", "Web & Mobile Development");
        Student student = new Student("Corey Black", "Male", "Web & Mobile Development", "Level 9");

        // Combine messages
        String combinedMessage = userMessage + "\n\n--- Teacher Details ---\n" + teacher.getDetails() +
                "\n\n--- Student Details ---\n" + student.getDetails();

        // Send combined message to Activity2
        intent.putExtra(EXTRA_MESSAGE, combinedMessage);
        activityResultLauncher.launch(intent);
    }
}