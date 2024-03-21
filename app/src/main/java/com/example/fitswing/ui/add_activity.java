package com.example.fitswing.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitswing.R;

public class add_activity extends AppCompatActivity {

    EditText activity_name;

    EditText calories;
    EditText description;

    EditText date;

    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        activity_name = findViewById(R.id.txtName);
        calories = findViewById(R.id.txtCalories);
        description = findViewById(R.id.txtDescription);

    }
}