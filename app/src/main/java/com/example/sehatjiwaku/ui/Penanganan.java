package com.example.sehatjiwaku.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sehatjiwaku.R;

public class Penanganan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_penanganan);

        ImageButton ahli = (ImageButton) findViewById(R.id.btn_ahli);
        ahli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Penanganan.this, DaftarDokter.class);
                startActivity(intent);
            }
        });
    }
}
