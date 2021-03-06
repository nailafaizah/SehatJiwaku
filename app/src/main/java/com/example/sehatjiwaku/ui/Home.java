package com.example.sehatjiwaku.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sehatjiwaku.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton home = findViewById(R.id.menu_home);
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Home.class);
                startActivity(intent);
            }
        });

        ImageButton penyakit = findViewById(R.id.menu_penyakit);
        penyakit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, DaftarHalusinasi.class);
                startActivity(intent);
            }
        });

        ImageButton cari = findViewById(R.id.menu_cari);
        cari.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Cari.class);
                startActivity(intent);
            }
        });

        ImageButton ahli = findViewById(R.id.btn_ahli);
        ahli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, TemuiAhli.class);
                startActivity(intent);
            }
        });

        ImageButton info = findViewById(R.id.btn_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Informasi.class);
                startActivity(intent);
            }
        });
    }
}
