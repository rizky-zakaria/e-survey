package com.example.e_survey.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.e_survey.R;
import com.example.e_survey.api.ApiInterfaces;
import com.example.e_survey.api.ApiServer;
import com.example.e_survey.config.SharedPrefManager;
import com.example.e_survey.model.ResponseToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (sharedPrefManager.getSPToken().equals("")){
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
//                }else {
//                    cekToken(sharedPrefManager.getSPToken());
//                }

            }
        }, 3000);

    }

    private void cekToken(String spToken) {
        ApiInterfaces apiInterfaces = ApiServer.konekRetrofit().create(ApiInterfaces.class);
        Call<ResponseToken> call = apiInterfaces.dataToken(spToken);
        call.enqueue(new Callback<ResponseToken>() {
            @Override
            public void onResponse(Call<ResponseToken> call, Response<ResponseToken> response) {

            }

            @Override
            public void onFailure(Call<ResponseToken> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}