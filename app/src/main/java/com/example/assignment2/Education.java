package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Education extends AppCompatActivity {
    EditText educationText;
    Button btnCancel, btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnCancel.setOnClickListener(v -> onCancel());
        btnSubmit.setOnClickListener(v -> onSubmit());
    }
    private void init(){
        educationText = findViewById(R.id.educationText);
        btnCancel = findViewById(R.id.cancel_button_education);
        btnSubmit = findViewById(R.id.submit_button_education);
    }
    private void onCancel(){
        setResult(RESULT_CANCELED);
        finish();
    }

    private void onSubmit(){
        String summaryText = this.educationText.getText().toString();
        Intent i = new Intent();
        i.putExtra("educationText", summaryText);
        setResult(RESULT_OK, i);
        finish();
    }
}