package com.example.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    Button profilePicture, personalDetails, summary, education, experience, certification, references, preview;
    ActivityResultLauncher<Intent> getImageLauncher, getPersonalDetailsLauncher, getSummaryLauncher, getEducationLauncher, getExperienceLauncher, getCertificationLauncher, getReferencesLauncher;
    Uri imageUri;
    String name, email, phone, address, summaryText, educationText, experienceText, certificationText, referencesText;
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
        profilePicture.setOnClickListener(v -> setImage());
        preview.setOnClickListener(v -> setPreview());
        personalDetails.setOnClickListener(v -> {
            Intent intent = new Intent(this, PersonalDetails.class);
            getPersonalDetailsLauncher.launch(intent);
        });

        summary.setOnClickListener(v -> {
            Intent intent = new Intent(this, Summary.class);
            getSummaryLauncher.launch(intent);
        });

        education.setOnClickListener(v -> {
            Intent intent = new Intent(this, Education.class);
            getEducationLauncher.launch(intent);
        });

        experience.setOnClickListener(v -> {
            Intent intent = new Intent(this, Experience.class);
            getExperienceLauncher.launch(intent);
        });

        certification.setOnClickListener(v -> {
            Intent intent = new Intent(this, Certification.class);
            getCertificationLauncher.launch(intent);
        });

        references.setOnClickListener(v -> {
            Intent intent = new Intent(this, Reference.class);
            getReferencesLauncher.launch(intent);
        });
    }

    private void init(){
        profilePicture = findViewById(R.id.profile_picture);
        personalDetails = findViewById(R.id.personal_details);
        summary = findViewById(R.id.summary);
        education = findViewById(R.id.education);
        experience = findViewById(R.id.experience);
        certification = findViewById(R.id.certifications);
        references = findViewById(R.id.references);
        preview = findViewById(R.id.Preview);
        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                imageUri = result.getData().getData();
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show();
            }
        });
        getPersonalDetailsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                name = result.getData().getStringExtra("name");
                email = result.getData().getStringExtra("emailAddress");
                phone = result.getData().getStringExtra("phoneNumber");
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No personal details entered", Toast.LENGTH_SHORT).show();
            }
        });
        getSummaryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                summaryText = result.getData().getStringExtra("summaryText");
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No summary entered", Toast.LENGTH_SHORT).show();
            }
        });
        getEducationLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                educationText = result.getData().getStringExtra("educationText");
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No education entered", Toast.LENGTH_SHORT).show();
            }
        });
        getExperienceLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                experienceText = result.getData().getStringExtra("experienceText");
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No experience entered", Toast.LENGTH_SHORT).show();
            }
        });

        getCertificationLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                certificationText = result.getData().getStringExtra("certificationText");
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No certification entered", Toast.LENGTH_SHORT).show();
            }
        });

        getReferencesLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) ->{
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                referencesText = result.getData().getStringExtra("referenceText");
            }
            else if(result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(this, "No references entered", Toast.LENGTH_SHORT).show();
            }
        });
            }
    private void setImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        getImageLauncher.launch(intent);
    }
    private void setPreview(){
        Intent intent = new Intent(this, Preview.class);
        intent.putExtra("imageUri", imageUri.toString());
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        intent.putExtra("address", address);
        intent.putExtra("summary", summaryText);
        intent.putExtra("education", educationText);
        intent.putExtra("experience", experienceText);
        intent.putExtra("certification", certificationText);
        intent.putExtra("references", referencesText);
        startActivity(intent);
    }
}