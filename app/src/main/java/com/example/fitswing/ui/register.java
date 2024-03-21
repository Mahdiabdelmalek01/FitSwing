package com.example.fitswing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private EditText inputName, inputEmail, inputPassword, inputConfirmPassword;
    Button btnRegistration;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        inputName = findViewById(R.id.txtName);
        inputEmail = findViewById(R.id.txtEmail);
        inputPassword = findViewById(R.id.txtPassword);
        inputConfirmPassword = findViewById(R.id.txtConfirmPassword);
        // Sign in success, update UI with the signed-in user's information
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        btnRegistration=findViewById(R.id.btnRegister);

        Intent intent = getIntent();
        float weight = intent.getFloatExtra("Weight",0.1f);
        float height = intent.getFloatExtra("Height",0.0f);
        int age = intent.getIntExtra("Age",0);
        String gender = intent.getStringExtra("Gender");

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials(weight, height, age, gender);
            }
        });
    }

    private void checkCredentials(float weight, float height, int age, String gender) {
        String username = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String confirmPassword = inputConfirmPassword.getText().toString().trim();


        if (username.isEmpty() || username.length() < 6) {
            showError(inputName, "Username must be at least 6 characters");
        } else if (!email.matches(emailPattern)) {
            showError(inputEmail, "Invalid email address");
        } else if (password.isEmpty() || password.length() < 7) {
            showError(inputPassword, "Password must be at least 7 characters");
        } else if (!password.equals(confirmPassword)) {
            showError(inputConfirmPassword, "Passwords do not match");
        } else {
            registerUser(email, password,username,weight,height,age,gender);

        }
    }
    private void registerUser(String email, String password, String username, float weight, float height, int age, String gender) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        sendVerificationEmail();
                        user usr = new user(username, Float.toString(weight), Float.toString(height), Integer.toString(age), gender);
                        FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
                        DatabaseReference myRef = database.getReference("users");
                        FirebaseUser user = mAuth.getCurrentUser();
                        String userid = user.getUid();
                        myRef.child(userid).setValue(usr);
                        Intent intent = new Intent(register.this, login.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(register.this, "Failed to create user: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Verification email sent to " + user.getEmail(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(register.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

}