package com.example.e_survey.api;
import com.example.e_survey.model.ResponseIdentitas;
import com.example.e_survey.model.ResponseLogin;
import com.example.e_survey.model.ResponseToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterfaces {

    @FormUrlEncoded
    @POST("masuk")
    Call<ResponseLogin> dataLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("api/survey")
    Call<ResponseToken> dataToken(
            @Header("Authorization") String token
    );

    @POST("api/v1/survey")
    Call<ResponseIdentitas> dataIdentitas(

    );



}
