package com.example.fitswing.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitswing.MainActivity;
import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class add_activity extends AppCompatActivity {
    private static final String[] DATE_FORMATS = {
            "dd/MM/yyyy", "dd-MM-yyyy", "dd/MMM/yyyy", "dd-MMM-yyyy", "yyyy-MM-dd"
    };
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
                if(isValidDateFormat(activity_date.getText().toString())){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
                String userid = user.getUid();
                String name = activity_name.getText().toString();
                String calories = activity_calories.getText().toString();
                String description = activity_description.getText().toString();
                String date = activity_date.getText().toString();
                activity a = new activity(name,calories,description,date);
                DatabaseReference myRef = database.getReference("users").child(userid).child("challenges");
                String challengeId = myRef.push().getKey();
                myRef.child(challengeId).setValue(a);
                Intent intent = new Intent(add_activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else{
                    Toast.makeText(add_activity.this, "Invalid date format.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public static boolean isValidDateFormat(String inputDate) {
        for (String format : DATE_FORMATS) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false); // Disable lenient mode
            try {
                Date date = sdf.parse(inputDate);
                return inputDate.equals(sdf.format(date)); // Ensure parsed date matches the input
            } catch (ParseException e) {
                // Parsing failed, try next format
            }
        }
        return false; // No matching format found
    }
}