package com.example.sehatjiwaku.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sehatjiwaku.R;

public class Opening3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening3);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageButton lanjutkan = findViewById(R.id.btn_lanjutkan);
        lanjutkan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opening3.this, Login.class);
                startActivity(intent);
            }
        });

        Button lewati = findViewById(R.id.btn_lewati);
        lewati.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opening3.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
