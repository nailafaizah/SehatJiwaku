package com.example.sehatjiwaku.api;

import com.example.sehatjiwaku.model.DoctorModel;
import com.example.sehatjiwaku.model.GetDoctorResponse;
import com.example.sehatjiwaku.model.LoginModel;
import com.example.sehatjiwaku.model.LoginResponse;
import com.example.sehatjiwaku.model.PostPutDeleteDoctorResponse;
import com.example.sehatjiwaku.model.RegisterModel;
import com.example.sehatjiwaku.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterModel data);

    @POST("login")
    Call<LoginResponse> login(@Body LoginModel data);

    @GET("dokter")
    Call<GetDoctorResponse> getDoctor();

    @POST("dokter")
    Call<PostPutDeleteDoctorResponse> createDoctor(@Body DoctorModel data);

    @PUT("dokter/{id}")
    Call<PostPutDeleteDoctorResponse> updateDoctor(@Path("id") int id, @Body DoctorModel data);
}
