package com.example.sehatjiwaku.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sehatjiwaku.databinding.ActivityFormGejalaBinding;
import com.example.sehatjiwaku.model.DataGejala;

public class FormGejala extends AppCompatActivity {
    private ActivityFormGejalaBinding binding;
    public final static String KEY_UPDATE_GEJALA = "key update gejala";
    private DataGejala dataGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormGejalaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        dataGejala = getIntent().getParcelableExtra(KEY_UPDATE_GEJALA);
        if(dataGejala != null){
            binding.tvNamaGejala.setText(dataGejala.getNamaGejala());
            String idPenyakit = dataGejala.getIdPenyakit();
            switch (idPenyakit){
                case "201" : binding.tvNamaPenyakit.setText("Halusinasi Pendengaran"); break;
                case "202" : binding.tvNamaPenyakit.setText("Halusinasi Penglihatan"); break;
                case "203" : binding.tvNamaPenyakit.setText("Halusinasi Penciuman"); break;
                case "204" : binding.tvNamaPenyakit.setText("Halusinasi Pengecapan"); break;
                case "205" : binding.tvNamaPenyakit.setText("Halusinasi Perabaan"); break;
            }
        }
    }
}