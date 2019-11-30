package com.example.i_kampus.homeUser.Awal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.i_kampus.R;
import com.example.i_kampus.homeUser.menuKuesioner.KategoriKuesioner;
import com.example.i_kampus.homeUser.menuUtama.PencarianKampus;

public class Kategori extends AppCompatActivity {
    private ImageView kampus, kuesioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        kampus = findViewById(R.id.kampus);
        kuesioner = findViewById(R.id.kuesioner);

        kampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kategori.this, PencarianKampus.class);
                startActivity(intent);
                finish();
            }
        });

        kuesioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kategori.this, KategoriKuesioner.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
