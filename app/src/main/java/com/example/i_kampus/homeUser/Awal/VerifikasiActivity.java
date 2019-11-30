package com.example.i_kampus.homeUser.Awal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VerifikasiActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    private TextView email;
    private Button submit;

    @Override
    protected void onStart() {
        super.onStart();

        String userEmail = mUser.getEmail();
        email.setText(userEmail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi);
        inisialisasi();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerification();
            }
        });

    }

    private void inisialisasi(){
        email = findViewById(R.id.email);
        submit = findViewById(R.id.submit);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

    }

    private void sendVerification(){
        mUser.sendEmailVerification().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(VerifikasiActivity.this, "Verifikasi Code Sent To :" + mUser.getEmail(),Toast.LENGTH_SHORT).show();
                Intent login = new Intent(VerifikasiActivity.this, Login.class);
                startActivity(login);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(VerifikasiActivity.this, "Verifikasi Code Failed to send" ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}