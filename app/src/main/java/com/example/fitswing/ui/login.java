package com.example.fitswing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitswing.MainActivity;
import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    TextView goResgister;
    private EditText inputEmail, inputPassword;
    Button btnLogin;
    private FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        goResgister = findViewById(R.id.lnkRegister);
        inputEmail = findViewById(R.id.txtEmail);
        inputPassword = findViewById(R.id.txtPwd);
        authProfile = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });
        //goResgister.setOnClickListener(v -> startActivity(new Intent(activity_login.this, activity_setup_profil.class)));
        goResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //boolean setupProfileNeeded = true; // Set this based on your condition
                Intent intent = new Intent(login.this, setup.class);
                //intent.putExtra("setup_profile_needed", setupProfileNeeded);
                startActivity(intent);
                finish();
            }
        });

    }
    private void checkCredentials() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        if (email.isEmpty() || !email.contains("@")) {
            showError(inputEmail, "Email is not valid");
        } else if (password.isEmpty() || password.length() < 7) {
            showError(inputPassword, "Password must be 7 characters");
        } else {
            // Here you can proceed with authentication or registration
            LoginUser(email,password);
            Toast.makeText(this, "Call Registration Method", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoginUser(String email, String password) {
        authProfile.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(login.this, "Logged in Successfully", Toast.LENGTH_LONG).show();
                        // Navigate to HomeFragment
                        navigateToHomeFragment();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(login.this, "Failed to login: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void navigateToHomeFragment() {
        // Navigate to HomeFragment
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}