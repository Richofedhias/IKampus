package com.example.i_kampus.homeUser.menuKuesioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.i_kampus.R;

public class MulaiKuesionerPsikologi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai_kuesioner_psikologi);
        Button mulai = findViewById(R.id.button4);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MulaiKuesionerPsikologi.this, KuesionerPsikologi.class);
                startActivity(intent);
            }
        });
    }
}
