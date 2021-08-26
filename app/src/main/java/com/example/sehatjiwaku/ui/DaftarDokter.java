package com.example.sehatjiwaku.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sehatjiwaku.adapter.DokterAdapter;
import com.example.sehatjiwaku.api.ApiConfig;
import com.example.sehatjiwaku.databinding.ActivityDaftarDokterBinding;
import com.example.sehatjiwaku.model.GetDoctorResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarDokter extends AppCompatActivity {
    private ActivityDaftarDokterBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private DokterAdapter dokterAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDaftarDokterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        loadListDataDoctors();

        binding.fabAddDoctor.setOnClickListener(v -> {
            Intent intent = new Intent(DaftarDokter.this, FormDokterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void loadListDataDoctors() {
        Call<GetDoctorResponse> call = ApiConfig.getApiService().getDoctor();
        call.enqueue(new Callback<GetDoctorResponse>() {
            @Override
            public void onResponse(@NotNull Call<GetDoctorResponse> call, @NotNull Response<GetDoctorResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    binding.rvListDoctor.setHasFixedSize(true);
                    linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.rvListDoctor.setLayoutManager(linearLayoutManager);
                    dokterAdapter = new DokterAdapter(response.body().getData());
                    binding.rvListDoctor.setAdapter(dokterAdapter);
                    dokterAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NotNull Call<GetDoctorResponse> call, @NotNull Throwable t) {
                Log.d("Daftar Dokter", "onFailure: " + t.toString());
            }
        });
    }
}
