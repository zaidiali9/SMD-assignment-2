package com.example.assignment2;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    Button profilePicture, personalDetails, summary, education, experience, certification, references;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init(){
        profilePicture = findViewById(R.id.profile_picture);
        personalDetails = findViewById(R.id.personal_details);
        summary = findViewById(R.id.summary);
        education = findViewById(R.id.education);
        experience = findViewById(R.id.experience);
        certification = findViewById(R.id.certifications);
        references = findViewById(R.id.references);
    }
}