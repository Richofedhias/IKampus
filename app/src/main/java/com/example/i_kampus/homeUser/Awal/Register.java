package com.example.i_kampus.homeUser.Awal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.example.i_kampus.database.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText firstname, lastname, email, password, notelpon, re_pass;
    private Button btnRegister;
    private FirebaseAuth Mauth;
    private DatabaseReference reference;
    private ProgressDialog loading;
    private ImageView showPass, hidePass, showPass2, hidePass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Mauth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("User");
        inisialisasi();
        showPass.setVisibility(View.GONE);
        showPass2.setVisibility(View.GONE);
        hidePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showPass.setVisibility(View.VISIBLE);
                hidePass.setVisibility(View.GONE);
            }
        });
        showPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hidePass.setVisibility(View.VISIBLE);
                showPass.setVisibility(View.GONE);
            }
        });
        hidePass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                re_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showPass2.setVisibility(View.VISIBLE);
                hidePass2.setVisibility(View.GONE);
            }
        });

        showPass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                re_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hidePass2.setVisibility(View.VISIBLE);
                showPass2.setVisibility(View.GONE);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuatAkun();
            }
        });
    }

    private void inisialisasi() {

        loading = new ProgressDialog(this);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.emailRegis);
        notelpon = findViewById(R.id.telpRegis);
        password = findViewById(R.id.password);
        re_pass = findViewById(R.id.confirmPass);
        btnRegister = findViewById(R.id.register);
        showPass = findViewById(R.id.showPass);
        hidePass = findViewById(R.id.hidePass);
        showPass2 = findViewById(R.id.showPass2);
        hidePass2 = findViewById(R.id.hidePass2);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

    }

    //
    private void BuatAkun() {
        String firstName = firstname.getText().toString();
        String lastName = lastname.getText().toString();
        String userEmail = email.getText().toString();
        String userNo = notelpon.getText().toString();
        String pass = password.getText().toString();
        String confirmpass = re_pass.getText().toString();
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
//        Matcher matcher = Pattern.compile(validemail).matcher(pass);
//        if (matcher.matches()) {
//            Toast.makeText(getApplicationContext(), "Valid", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "Karakter tidak boleh digunakan", Toast.LENGTH_SHORT).show();
//        }
        if (TextUtils.isEmpty(firstName)) {
            Toast.makeText(this, "Masukan Firstname Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(lastName)) {
            Toast.makeText(this, "Masukan Lastname Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userEmail) || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            Toast.makeText(this, "Masukan Email dengan Benar", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userNo) || userNo.length() <= 11) {
            Toast.makeText(this, "Masukan  No Telfon terlebih dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Masukan Password", Toast.LENGTH_SHORT).show();
        } else if (pass.length() <= 7) {
            Toast.makeText(this, "Masukan Password minimum 8 karakter ", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(confirmpass)) {
            Toast.makeText(this, "Masukan Re-Password ", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(confirmpass)) {
            Toast.makeText(this, "Masukan Password yang sama", Toast.LENGTH_SHORT).show();
        } else {
            loading.setTitle("Creating New Account");
            loading.setMessage("Please Wait, yess");
            loading.setCanceledOnTouchOutside(true);
            loading.show();
            User user = new User(firstName, lastName, userEmail, userNo, pass);
            String key = reference.push().getKey();
            reference.child(key).setValue(user);

            Mauth.createUserWithEmailAndPassword(userEmail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        toVerifikasi();
                        Toast.makeText(Register.this, "Account Created Succes", Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                    } else {
                        String message = task.getException().toString();
                        Toast.makeText(Register.this, "Error " + message, Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                    }
                }
            });
        }


    }

    private void toVerifikasi() {
        Intent VerifikasiIntent = new Intent(Register.this, VerifikasiActivity.class);
        startActivity(VerifikasiIntent);
        finish();
    }
}
