package com.example.fitswing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitswing.MainActivity;
import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class add_activity extends AppCompatActivity {

    EditText activity_name;

    EditText activity_calories;
    EditText activity_description;

    EditText activity_date;

    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        activity_name = findViewById(R.id.txtName);
        activity_calories = findViewById(R.id.txtCalories);
        activity_description = findViewById(R.id.txtDescription);
        activity_date = findViewById(R.id.txtDate);
        addBtn = findViewById(R.id.btnRegister);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
                String userid = user.getUid();
                String name = activity_name.getText().toString();
                String calories = activity_calories.getText().toString();
                String description = activity_description.getText().toString();
                String date = activity_date.getText().toString();
                Map<String, String> additionalData = new HashMap<>();
                additionalData.put("activity", name);
                additionalData.put("calories", calories);
                additionalData.put("activity_description", description);
                additionalData.put("activity_date", date);
                DatabaseReference myRef = database.getReference("users").child(userid).child("challenges");
                String challengeId = myRef.push().getKey();
                myRef.child(challengeId).setValue(additionalData);
                Intent intent = new Intent(add_activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}