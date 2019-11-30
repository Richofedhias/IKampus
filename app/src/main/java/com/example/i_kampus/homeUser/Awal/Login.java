package com.example.i_kampus.homeUser.Awal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.i_kampus.R;
import com.example.i_kampus.homeAdmin.AdminLoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText username, pass;
    private TextView forgot,admLogin, resetText;
    private Button register, login;
    private FirebaseAuth mAuth;
    private ImageView showpassword, hidepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inisilisasi();
        resetText = findViewById(R.id.reset);
        mAuth = FirebaseAuth.getInstance();
        hidepassword.setVisibility(View.GONE);
        hidepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showpassword.setVisibility(View.VISIBLE);
                hidepassword.setVisibility(View.GONE);
            }
        });
        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hidepassword.setVisibility(View.VISIBLE);
                showpassword.setVisibility(View.GONE);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMasukbiasa();
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
//
//
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrasi = new Intent(Login.this, Register.class);
                startActivity(registrasi);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(Login.this, ForgotPassword.class);
                startActivity(forgot);
            }
        });
        admLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(Login.this, AdminLoginActivity.class);
                startActivity(admin);
            }
        });

        resetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                pass.setText("");
            }
        });


    }

    private void inisilisasi() {
        username = findViewById(R.id.namaLengkap);
        pass = findViewById(R.id.password);
        register = findViewById(R.id.register);
        forgot = findViewById(R.id.forgotPass);
        login = findViewById(R.id.login);
        showpassword = findViewById(R.id.showPass);
        hidepassword = findViewById(R.id.hidePass);
        admLogin = findViewById(R.id.adminLog);
    }

    private void onMasukbiasa() {
        String email = username.getText().toString();
        String password = pass.getText().toString();
//        String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
//
//                "\\@" +
//
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//
//                "(" +
//
//                "\\." +
//
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//
//                ")+";
//        Matcher matcher = Pattern.compile(validemail).matcher(password);
//        if (matcher.matches()) {
//            Toast.makeText(getApplicationContext(), "Valid", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "Karakter tidak boleh digunakan", Toast.LENGTH_SHORT).show();
//        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Mohon Untuk Diisi dengan benar", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Mohon Untuk Diisi dengan benar", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                SendUserToKategoriActivity();
                                Toast.makeText(Login.this, "Kamu Berhasil Login", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "TIdak Berhasil Login, Mohon untuk dicek, apakah sudah daftar apa belum " , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void SendUserToKategoriActivity() {
        Intent mainIntent = new Intent(Login.this, Kategori.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }


}
