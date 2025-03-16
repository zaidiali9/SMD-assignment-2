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

public class Reference extends AppCompatActivity {
    EditText referenceText;
    Button btnCancel, btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reference);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnCancel.setOnClickListener(view -> onCancel());
        btnSubmit.setOnClickListener(view -> onSubmit());

    }
    private void init(){
        referenceText = findViewById(R.id.reference_edit_text);
        btnCancel = findViewById(R.id.cancel_button_reference);
        btnSubmit = findViewById(R.id.submit_button_referece);
    }
    private void onCancel(){
        setResult(RESULT_CANCELED);
        finish();
    }

    private void onSubmit(){
        String summaryText = this.referenceText.getText().toString();
        Intent i = new Intent();
        i.putExtra("referenceText", summaryText);
        setResult(RESULT_OK, i);
        finish();
    }
}