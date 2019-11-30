package com.example.i_kampus.homeUser.menuUtama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.i_kampus.R;

public class PencarianKampus extends AppCompatActivity {
    Spinner spinnerProvinsi, spinnerDaerah, spinnerKampus;
    Button search;
    EditText searchEt;
    final String[] provinsi = {
            "Jawa Barat"
    };
    final String[] jawaBarat = {
            "Bandung"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian_kampus);
        inisialisasi();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,provinsi);
        spinnerProvinsi.setAdapter(adapter);
        spinnerProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(PencarianKampus.this,R.layout.support_simple_spinner_dropdown_item,jawaBarat);
                    spinnerDaerah.setAdapter(adapter);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerDaerah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(PencarianKampus.this, R.layout.support_simple_spinner_dropdown_item, kampusBandung);
//                    spinnerKampus.setAdapter(adapter);
                    search.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (searchEt.getText().toString().equals("Telkom University")) {
                                Intent intent = new Intent(PencarianKampus.this, BerandaNew.class);
                                startActivity(intent);
                                finish();
                            }else if (searchEt.getText().toString().equals("Universitas Padjajaran")){
                                Intent intent = new Intent(PencarianKampus.this, UnpadBeranda.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(PencarianKampus.this,"Kampus Tidak Ada",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void inisialisasi() {
        spinnerProvinsi = findViewById(R.id.provinsi);
        spinnerDaerah = findViewById(R.id.daerah);
        searchEt = findViewById(R.id.pencarianKampus);
        spinnerProvinsi.setPrompt("Pilih Provinsi");
        search = findViewById(R.id.search);


    }
}
