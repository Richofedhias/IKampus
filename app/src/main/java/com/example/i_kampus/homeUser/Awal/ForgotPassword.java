package com.example.i_kampus.homeUser.Awal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText emailuser;
    private ProgressBar proggres;
    private Button send;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        inisialisasi();
        proggres.setVisibility(View.GONE);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailuser.getText().toString();
                proggres.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty((email))){
                    Toast.makeText(ForgotPassword.this, "Masukan Email",Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.sendPasswordResetEmail(emailuser.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            proggres.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPassword.this, "Password Send to your email", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ForgotPassword.this, Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ForgotPassword.this, "Email Anda tidak terdaftar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }

    public void inisialisasi(){
        mAuth = FirebaseAuth.getInstance();
        emailuser = findViewById(R.id.email);
        proggres = findViewById(R.id.progressBar);
        send = findViewById(R.id.send);
    }
}
