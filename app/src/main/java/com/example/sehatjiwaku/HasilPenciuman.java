package com.example.sehatjiwaku;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HasilPenciuman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_penciuman);

        ImageButton ahli = findViewById(R.id.btn_ahli);
        ahli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilPenciuman.this, DaftarDokter.class);
                startActivity(intent);
            }
        });

        ImageButton selesai = findViewById(R.id.btn_selesai);
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilPenciuman.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
