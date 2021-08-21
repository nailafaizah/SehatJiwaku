package com.example.sehatjiwaku.api;

import com.example.sehatjiwaku.model.LoginModel;
import com.example.sehatjiwaku.model.LoginResponse;
import com.example.sehatjiwaku.model.RegisterModel;
import com.example.sehatjiwaku.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterModel data);

    @POST("login")
    Call<LoginResponse> login(@Body LoginModel data);
}
