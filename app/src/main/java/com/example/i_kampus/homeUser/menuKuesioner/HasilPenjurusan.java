package com.example.i_kampus.homeUser.menuKuesioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.i_kampus.R;

public class HasilPenjurusan extends AppCompatActivity {
    TextView totalSoal,jawabanBenar,jawabanSalah,hasil,kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_penjurusan);

        hasil = findViewById(R.id.tVhasil);
        kategori = findViewById(R.id.tVkategori);

        Intent i = getIntent();

        String benar = i.getStringExtra("corect");
        String hasill = i.getStringExtra("hasil");

        hasil.setText("Hasil : " + hasill);
        kategori.setText(benar);

    }

}
