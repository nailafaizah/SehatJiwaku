package com.example.sehatjiwaku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Penciuman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penciuman);

        ImageButton back = (ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Penciuman.this, DaftarHalusinasi.class);
                startActivity(intent);
            }
        });

        ImageButton penanganan = (ImageButton) findViewById(R.id.btn_penanganan);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Penciuman.this, Penanganan.class);
                startActivity(intent);
            }
        });
    }
}
