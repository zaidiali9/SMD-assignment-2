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

public class PersonalDetails extends AppCompatActivity {

    Button btnSubmit, btnCancel;
    EditText name, phoneNumber, emailAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details);
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
        btnSubmit = findViewById(R.id.submit_button);
        btnCancel = findViewById(R.id.cancel_button);
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);
        emailAddress = findViewById(R.id.email);
    }
    void onCancel(){
        setResult(RESULT_CANCELED);
        finish();
    }

    void onSubmit(){
        String name = this.name.getText().toString();
        String phoneNumber = this.phoneNumber.getText().toString();
        String emailAddress = this.emailAddress.getText().toString();
        Intent i = new Intent();
        i.putExtra("name", name);
        i.putExtra("phoneNumber", phoneNumber);
        i.putExtra("emailAddress", emailAddress);
        setResult(RESULT_OK, i);
        finish();
    }
}