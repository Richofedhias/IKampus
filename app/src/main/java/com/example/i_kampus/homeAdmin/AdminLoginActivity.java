package com.example.i_kampus.homeAdmin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.example.i_kampus.database.Admin;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLoginActivity extends AppCompatActivity {
    private EditText user, password;
    private Button loginn;
    ProgressDialog pDialog;
    private int total = 2;

    //DATABASE
    DatabaseReference dbAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        inisilisasi();

        //INTENT BUTTON
        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminlog();
            }
        });
    }

    private void adminlog() {
        displayLoader();

        //Inisialisasi Database
        dbAdmin = FirebaseDatabase.getInstance().getReference("Admin").child(String.valueOf(total));
        dbAdmin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Admin admin = dataSnapshot.getValue(Admin.class);
                //Admin Login cek
                if (user.getText().toString().equals(admin.getUsername())&&password.getText().toString().equals(admin.getPassword())){
                    Intent intent = new Intent(AdminLoginActivity.this, InputKampus.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(AdminLoginActivity.this, "Anda Bukan Admin", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void displayLoader(){
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Verifikasi Akun....");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void inisilisasi() {
        user = findViewById(R.id.usernameInput);
        password = findViewById(R.id.passwordInput);
        loginn = findViewById(R.id.loginAdminn);
    }
}
