package com.example.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Preview extends AppCompatActivity {

    String imageUri, name, email, phone, address, summary, education, experience, certification, references;
    ImageView profileImage;
    TextView nameText, emailText, phoneText, summaryText, addressText, educationText, experienceText, certificationText, referencesText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        load();
        set();
    }
    private void init(){
        profileImage = findViewById(R.id.profile_image_previewscreen);
        nameText = findViewById(R.id.name_previewscreen);
        emailText = findViewById(R.id.email_previewscreen);
        phoneText = findViewById(R.id.phone_previewscreen);
        summaryText = findViewById(R.id.summary_text_previewscreen);
        educationText = findViewById(R.id.education_text_previewscreen);
        experienceText = findViewById(R.id.work_experience_text_previewscreen);
        certificationText = findViewById(R.id.certifications_text_previewscreen);
        referencesText = findViewById(R.id.references_text_previewscreen);

    }
    private void load(){
        // Load all the data from the previous activities
        Intent i = getIntent();
        // Load the data from the intent
        imageUri = i.getStringExtra("imageUri");
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        address = i.getStringExtra("address");
        summary = i.getStringExtra("summary");
        education = i.getStringExtra("education");
        experience = i.getStringExtra("experience");
        certification = i.getStringExtra("certification");
        references = i.getStringExtra("references");
    }
    private void set(){
        // Set the data to the views
        profileImage.setImageURI(Uri.parse(imageUri));
        nameText.setText(name);
        emailText.setText(email);
        phoneText.setText(phone);
        summaryText.setText(summary);
        educationText.setText(education);
        experienceText.setText(experience);
        certificationText.setText(certification);
        referencesText.setText(references);
    }
}