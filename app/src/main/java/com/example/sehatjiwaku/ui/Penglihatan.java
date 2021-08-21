package com.example.sehatjiwaku.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sehatjiwaku.R;

public class Penglihatan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penglihatan);

        ImageButton back = (ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Penglihatan.this, DaftarHalusinasi.class);
                startActivity(intent);
            }
        });

        ImageButton penanganan = (ImageButton) findViewById(R.id.btn_penanganan);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Penglihatan.this, Penanganan.class);
                startActivity(intent);
            }
        });
    }
}
