package com.example.sehatjiwaku.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.sehatjiwaku.api.ApiConfig;
import com.example.sehatjiwaku.databinding.ActivityFormDokterBinding;
import com.example.sehatjiwaku.model.DataDoctor;
import com.example.sehatjiwaku.model.DoctorModel;
import com.example.sehatjiwaku.model.PostPutDeleteDoctorResponse;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormDokterActivity extends AppCompatActivity {
    private ActivityFormDokterBinding binding;
    public final static String KEY_UPDATE_DOCTOR = "key_update";
    private DataDoctor dataDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormDokterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataDoctor = getIntent().getParcelableExtra(KEY_UPDATE_DOCTOR);
        if(dataDoctor != null){
            binding.btnSimpan.setText("Perbarui");
            binding.btnSimpan.setBackgroundColor(0xFFFFC107);
            binding.etNamaDokter.setText(dataDoctor.getNamaDokter());
        }

        binding.btnSimpan.setOnClickListener(v -> {
            if(binding.btnSimpan.getText().equals("Simpan")){
                addDoctor(v);
            }else{
                updateDoctor(v, dataDoctor.getIdDokter());
            }
        });
    }

    private void updateDoctor(View view, String id) {
        DoctorModel data = new DoctorModel(binding.etNamaDokter.getText().toString());
        int idDoctor = Integer.parseInt(id);
        Call<PostPutDeleteDoctorResponse> call = ApiConfig.getApiService().updateDoctor(idDoctor, data);
        call.enqueue(new Callback<PostPutDeleteDoctorResponse>() {
            @Override
            public void onResponse(@NotNull Call<PostPutDeleteDoctorResponse> call, @NotNull Response<PostPutDeleteDoctorResponse> response) {
                assert response.body() != null;
                Snackbar.make(view, response.body().getMessage(), Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(FormDokterActivity.this, DaftarDokter.class);
                    startActivity(i);
                    finish();
                }, 2000);
            }

            @Override
            public void onFailure(@NotNull Call<PostPutDeleteDoctorResponse> call, @NotNull Throwable t) {
                Snackbar.make(view, Objects.requireNonNull(t.getMessage()), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void addDoctor(View view) {
        DoctorModel data = new DoctorModel(binding.etNamaDokter.getText().toString());
        Call<PostPutDeleteDoctorResponse> call = ApiConfig.getApiService().createDoctor(data);
        call.enqueue(new Callback<PostPutDeleteDoctorResponse>() {
            @Override
            public void onResponse(@NotNull Call<PostPutDeleteDoctorResponse> call, @NotNull Response<PostPutDeleteDoctorResponse> response) {
                assert response.body() != null;
                Snackbar.make(view, response.body().getMessage(), Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(FormDokterActivity.this, DaftarDokter.class);
                    startActivity(i);
                    finish();
                }, 2000);
            }

            @Override
            public void onFailure(@NotNull Call<PostPutDeleteDoctorResponse> call, @NotNull Throwable t) {
                Snackbar.make(view, Objects.requireNonNull(t.getMessage()), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}