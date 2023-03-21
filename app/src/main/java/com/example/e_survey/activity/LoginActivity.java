package com.example.e_survey.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_survey.R;

public class LoginActivity extends AppCompatActivity {

    AppCompatButton btnLogin;
    EditText email, password;

    String sEmail, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btnLogin.setOnClickListener(view -> {
            sEmail = email.getText().toString();
            sPassword = password.getText().toString();

            if (sEmail.equals("")){
                email.setError("Wajib diisi!");
            } else if (sPassword.equals("")) {
                password.setError("Wajib diisi!");
            }else {
                Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

    }
}