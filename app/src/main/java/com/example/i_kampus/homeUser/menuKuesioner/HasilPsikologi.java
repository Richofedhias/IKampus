package com.example.i_kampus.homeUser.menuKuesioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.i_kampus.R;

public class HasilPsikologi extends AppCompatActivity {
    TextView totalSoal,jawabanBenar,jawabanSalah,hasil,kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_psikologi);

        jawabanBenar = findViewById(R.id.benar);
        jawabanSalah = findViewById(R.id.salah);
        hasil = findViewById(R.id.tVhasilPsi);
        kategori = findViewById(R.id.tVkategoriPsi);

        Intent i = getIntent();

        String benar = i.getStringExtra("corect");
        String hasill = i.getStringExtra("hasil");
        String salah = i.getStringExtra("incorrect");
        String kategorii = i.getStringExtra("kategori");

        hasil.setText("Hasil : " + hasill);
        jawabanBenar.setText("Benar : " + benar);
        jawabanSalah.setText("Salah : " + salah);
        kategori.setText(kategorii);
    }
}
