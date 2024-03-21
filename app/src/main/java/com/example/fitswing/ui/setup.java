package com.example.fitswing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;

public class setup extends AppCompatActivity {
    TextView username;
    EditText weight , height , age ;
    Button proceedBtn;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setup);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setupProfile();
    }

    private void setupProfile() {
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        proceedBtn = findViewById(R.id.finishedBtn);
        radioGroup = findViewById(R.id.radioGroupMode);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float user_weight = Float.parseFloat(weight.getText().toString());
                Float user_height = Float.parseFloat(height.getText().toString());
                Integer user_age = Integer.parseInt(age.getText().toString());

                if (TextUtils.isEmpty(weight.getText().toString()) || TextUtils.isEmpty(height.getText().toString()) || TextUtils.isEmpty(age.getText().toString())) {
                    Toast.makeText(setup.this, "Please fill in all the fields", Toast.LENGTH_LONG).show();
                } else if (user_age < 10) {
                    Toast.makeText(setup.this, "Minimum Age is 10", Toast.LENGTH_LONG).show();
                    age.requestFocus();
                } else if (user_height < 75) {
                    Toast.makeText(setup.this, "Minimum Height is 75cm", Toast.LENGTH_LONG).show();
                    height.requestFocus();
                } else if (user_weight < 15) {
                    Toast.makeText(setup.this, "Minimum Weight is 15kg", Toast.LENGTH_LONG).show();
                    weight.requestFocus();
                } else if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(setup.this, "Please Select Gender", Toast.LENGTH_LONG).show();
                    radioGroup.requestFocus();
                } else {
                    radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                    String gender = radioButton.getText().toString();
                    goToRegistration(user_weight,user_height,user_age,gender);
                }
            }
        });
    }

    private void goToRegistration(float weight, float height, int age, String gender){
        Intent intent = new Intent(setup.this, register.class);
        intent.putExtra("Weight", weight);
        intent.putExtra("Height", height);
        intent.putExtra("Age", age);
        intent.putExtra("Gender", gender);

        startActivity(intent);
        finish();

    }

}