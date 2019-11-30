package com.example.i_kampus.homeUser.menuUtama.LatihanSoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.i_kampus.R;

public class ResultActivity extends AppCompatActivity {
//    TextView totalSoal,jawabanBenar,jawabanSalah;
    TextView hasil,nilai;
    Button ulangi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        totalSoal = findViewById(R.id.tVtotalSoal);
//        jawabanBenar = findViewById(R.id.tVjawabanBenar);
//        jawabanSalah = findViewById(R.id.tVjawabanSalah);
//
//        Intent i = getIntent();
//
//        String soal = i.getStringExtra("total");
//        String benar = i.getStringExtra("corect");
//        String salah = i.getStringExtra("incorrect");
//
//        totalSoal.setText(soal);
//        jawabanBenar.setText(benar);
//        jawabanSalah.setText(salah);
        ulangi = findViewById(R.id.ulangi);
        hasil = findViewById(R.id.hasilLatihan);
        nilai = findViewById(R.id.nilai);

        Intent i = getIntent();

        String benar = i.getStringExtra("correct");
        String salah = i.getStringExtra("incorrect");
        String nilaii = i.getStringExtra("hasil");

        nilai.setText("Yang Benar = " + benar +"\nYang Salah = " + salah);
        hasil.setText(nilaii);

        ulangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulangi(v);
            }
        });
    }

    public void ulangi(View view) {
        finish();
        Intent intent = new Intent(this,LatihanSoal.class);
        startActivity(intent);
    }
}
