package com.example.e_survey.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_survey.R;
import com.example.e_survey.api.ApiInterfaces;
import com.example.e_survey.api.ApiServer;
import com.example.e_survey.config.SharedPrefManager;
import com.example.e_survey.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    AppCompatButton btnLogin;
    EditText email, password;

    String sEmail, sPassword;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        if (sharedPrefManager.getSPSudahLogin().equals(true)){
            if (sharedPrefManager.getSpLevel().equals("3")){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Aplikasi Hanya Diperuntukan Pasien Yang Telah Terdaftar", Toast.LENGTH_SHORT).show();
            }
        }

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
                toLogin(sEmail, sPassword);
            }
        });

    }

    private void toLogin(String sEmail, String sPassword) {
        ApiInterfaces apiInterfaces = ApiServer.konekRetrofit().create(ApiInterfaces.class);
        Call<ResponseLogin> call = apiInterfaces.dataLogin(sEmail, sPassword);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, response.body().getUsername());
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_USER, String.valueOf(response.body().getIduser()));
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TOKEN, response.body().getAccess_token());
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_LEVEL, response.body().getLevel());
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_AVATAR, response.body().getAvatar());
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_MOBILE, response.body().getMobile());
                    Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}