package com.example.sehatjiwaku.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sehatjiwaku.api.ApiConfig;
import com.example.sehatjiwaku.databinding.ActivityDaftarBinding;
import com.example.sehatjiwaku.model.RegisterModel;
import com.example.sehatjiwaku.model.RegisterResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {
    private ActivityDaftarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDaftarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.login.setOnClickListener(v -> prosesDaftar());

        binding.btnMasuk.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        });

    }

    private void prosesDaftar() {
        RegisterModel data = new RegisterModel(
                binding.password.getText().toString(),
                binding.namaUser.getText().toString(),
                "admin",
                binding.username.getText().toString()
        );

        Call<RegisterResponse> client = ApiConfig.getApiService().register(data);
        client.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NotNull Call<RegisterResponse> call, @NotNull Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    Toast.makeText(Daftar.this, response.body().getMessages(), Toast.LENGTH_LONG).show();
                    clearEditText();
                }else{
                    assert response.body() != null;
                    Toast.makeText(Daftar.this, response.body().getMessages(), Toast.LENGTH_LONG).show();
                    Log.d("Daftar", "onResponse: " + response.body().getMessages());
                }
            }

            @Override
            public void onFailure(@NotNull Call<RegisterResponse> call, @NotNull Throwable t) {
                Toast.makeText(Daftar.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.d("Daftar", "onFailure: " + t.toString());
            }
        });
    }

    private void clearEditText(){
        binding.password.setText("");
        binding.namaUser.setText("");
        binding.username.setText("");
    }
}
