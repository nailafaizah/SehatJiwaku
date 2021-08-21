package com.example.sehatjiwaku.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public static ApiService getApiService() {
        // jangan lupa ganti IP Address ganti jaringan
        String ipAddress = "192.168.0.101";
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(50, TimeUnit.MINUTES) // connect timeout
                .writeTimeout(50, TimeUnit.MINUTES) // write timeout
                .readTimeout(50, TimeUnit.MINUTES) // read timeout
                .build();
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://"+ ipAddress +"/api-sehatjiwaku/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(ApiService.class);
    }
}
