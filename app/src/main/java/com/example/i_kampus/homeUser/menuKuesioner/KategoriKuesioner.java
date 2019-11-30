package com.example.i_kampus.homeUser.menuKuesioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.i_kampus.R;

public class KategoriKuesioner extends AppCompatActivity {
    Button psikolog, penjurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_kuesioner);
        inisialisasi();

        psikolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriKuesioner.this, MulaiKuesionerPsikologi.class);
                startActivity(intent);
            }
        });

        penjurusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriKuesioner.this, MulaiKuesionerPenjurusan.class);
                startActivity(intent);
            }
        });

    }
    public void inisialisasi(){
        psikolog = findViewById(R.id.psikologi);
        penjurusan = findViewById(R.id.penjurusan);
    }
}
