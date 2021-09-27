package com.example.sehatjiwaku.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sehatjiwaku.adapter.DokterAdapter;
import com.example.sehatjiwaku.adapter.GejalaAdapter;
import com.example.sehatjiwaku.api.ApiConfig;
import com.example.sehatjiwaku.databinding.ActivityDaftarGejalaBinding;
import com.example.sehatjiwaku.model.GetGejalaResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarGejala extends AppCompatActivity {
    private ActivityDaftarGejalaBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private GejalaAdapter gejalaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDaftarGejalaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        loadListDataGejala();

        binding.fabAddGejala.setOnClickListener(v -> {
            Intent intent = new Intent(DaftarGejala.this, FormGejala.class);
            startActivity(intent);
        });
    }

    private void loadListDataGejala(){
        Call<GetGejalaResponse> call = ApiConfig.getApiService().getGejala();
        call.enqueue(new Callback<GetGejalaResponse>() {
            @Override
            public void onResponse(@NotNull Call<GetGejalaResponse> call, @NotNull Response<GetGejalaResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    binding.rvListGejala.setHasFixedSize(true);
                    linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.rvListGejala.setLayoutManager(linearLayoutManager);
                    gejalaAdapter = new GejalaAdapter(response.body().getData());
                    binding.rvListGejala.setAdapter(gejalaAdapter);
                    gejalaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NotNull Call<GetGejalaResponse> call, @NotNull Throwable t) {
                Log.d("Daftar Dokter", "onFailure: " + t.toString());
            }
        });
    }
}