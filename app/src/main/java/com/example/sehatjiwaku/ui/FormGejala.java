package com.example.sehatjiwaku.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sehatjiwaku.R;
import com.example.sehatjiwaku.api.ApiConfig;
import com.example.sehatjiwaku.databinding.ActivityFormGejalaBinding;
import com.example.sehatjiwaku.model.DataGejala;
import com.example.sehatjiwaku.model.GejalaModel;
import com.example.sehatjiwaku.model.Penyakit;
import com.example.sehatjiwaku.model.PostPutDeleteGejalaResponse;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormGejala extends AppCompatActivity {
    private ActivityFormGejalaBinding binding;
    public final static String KEY_UPDATE_GEJALA = "key update gejala";
    private DataGejala dataGejala;
    private ArrayList<Penyakit> penyakits = new ArrayList<>();
    private String idp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormGejalaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        penyakits.add(new Penyakit("201", "Halusinasi Pendengaran"));
        penyakits.add(new Penyakit("202", "Halusinasi Penglihatan"));
        penyakits.add(new Penyakit("203", "Halusinasi Penciuman"));
        penyakits.add(new Penyakit("204", "Halusinasi Pengecapan"));
        penyakits.add(new Penyakit("205", "Halusinasi Perabaan"));

        ArrayAdapter<Penyakit> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, penyakits);
        binding.spPenyakit.setAdapter(adapter);

        binding.btnHapus.setVisibility(View.INVISIBLE);
        binding.btnHapus.setEnabled(false);

        dataGejala = getIntent().getParcelableExtra(KEY_UPDATE_GEJALA);
        if(dataGejala != null){
            binding.etNamaGejala.setText(dataGejala.getNamaGejala());
            String idPenyakit = dataGejala.getIdPenyakit();
            switch (idPenyakit){
                case "201" :
                    binding.spPenyakit.setSelection(0);
                    break;
                case "202" :
                    binding.spPenyakit.setSelection(1);
                    break;
                case "203" :
                    binding.spPenyakit.setSelection(2);
                    break;
                case "204" :
                    binding.spPenyakit.setSelection(4);
                    break;
                case "205" :
                    binding.spPenyakit.setSelection(5);
                    break;
            }

            binding.btnHapus.setVisibility(View.VISIBLE);
            binding.btnHapus.setEnabled(true);
            binding.btnSimpan.setText("Perbarui");
        }

        binding.spPenyakit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Penyakit penyakit = (Penyakit) parent.getSelectedItem();
                idp = penyakit.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.btnSimpan.setOnClickListener(v -> {
            if(binding.btnSimpan.getText().equals("Simpan")){
                createGejala(v);
            }else{
                updateGejala(v, dataGejala.getIdGejala());
            }
        });

        binding.btnHapus.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setPositiveButton("Yes", (dialog, id) -> {
                deleteGejala(v, dataGejala.getIdGejala());
            })
            .setNegativeButton("Cancel", (dialog, id) -> finish()
            );
            alertDialogBuilder.create();

        });
    }

    private void deleteGejala(View v, String id){
        Call<PostPutDeleteGejalaResponse> call = ApiConfig.getApiService().deleteGejala(id);
        call.enqueue(new Callback<PostPutDeleteGejalaResponse>() {
            @Override
            public void onResponse(@NotNull Call<PostPutDeleteGejalaResponse> call, @NotNull Response<PostPutDeleteGejalaResponse> response) {
                assert response.body() != null;
                Snackbar.make(v, response.body().getMessage(), Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(FormGejala.this, DaftarGejala.class);
                    startActivity(i);
                    finish();
                }, 2000);
            }

            @Override
            public void onFailure(@NotNull Call<PostPutDeleteGejalaResponse> call, @NotNull Throwable t) {
                Snackbar.make(v, Objects.requireNonNull(t.getMessage()), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void createGejala(View v) {
        GejalaModel data = new GejalaModel(idp, binding.etNamaGejala.getText().toString());
        Call<PostPutDeleteGejalaResponse> call = ApiConfig.getApiService().createGejala(data);
        call.enqueue(new Callback<PostPutDeleteGejalaResponse>() {
            @Override
            public void onResponse(@NotNull Call<PostPutDeleteGejalaResponse> call, @NotNull Response<PostPutDeleteGejalaResponse> response) {
                assert response.body() != null;
                Snackbar.make(v, response.body().getMessage(), Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(FormGejala.this, DaftarGejala.class);
                    startActivity(i);
                    finish();
                }, 2000);
            }

            @Override
            public void onFailure(@NotNull Call<PostPutDeleteGejalaResponse> call, @NotNull Throwable t) {
                Snackbar.make(v, Objects.requireNonNull(t.getMessage()), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void updateGejala(View v, String id){
        GejalaModel data = new GejalaModel(idp, binding.etNamaGejala.getText().toString());
        Call<PostPutDeleteGejalaResponse> call = ApiConfig.getApiService().updateGejala(Integer.parseInt(id), data);
        call.enqueue(new Callback<PostPutDeleteGejalaResponse>() {
            @Override
            public void onResponse(@NotNull Call<PostPutDeleteGejalaResponse> call, @NotNull Response<PostPutDeleteGejalaResponse> response) {
                assert response.body() != null;
                Snackbar.make(v, response.body().getMessage(), Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(FormGejala.this, DaftarGejala.class);
                    startActivity(i);
                    finish();
                }, 2000);
            }

            @Override
            public void onFailure(@NotNull Call<PostPutDeleteGejalaResponse> call, @NotNull Throwable t) {
                Snackbar.make(v, Objects.requireNonNull(t.getMessage()), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}