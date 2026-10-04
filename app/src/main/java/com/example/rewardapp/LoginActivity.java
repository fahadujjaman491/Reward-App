package com.example.rewardapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText email;
    private EditText password;
    private Button loginBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(v -> {

            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if (userEmail.isEmpty()) {
                email.setError("Email দিন");
                email.requestFocus();
                return;
            }

            if (userPassword.isEmpty()) {
                password.setError("Password দিন");
                password.requestFocus();
                return;
            }

            // আপাতত Demo Login
            if (userEmail.equals("test@gmail.com")
                    && userPassword.equals("123456")) {

                Toast.makeText(
                        LoginActivity.this,
                        "Login সফল হয়েছে",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        MainActivity.class
                );

                startActivity(intent);
                finish();

            } else {

                Toast.makeText(
                        LoginActivity.this,
                        "Email অথবা Password ভুল",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        registerBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    RegisterActivity.class
            );

            startActivity(intent);
        });
    }
}