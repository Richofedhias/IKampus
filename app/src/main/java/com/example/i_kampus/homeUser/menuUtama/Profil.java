package com.example.i_kampus.homeUser.menuUtama;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbKampus;
import com.example.i_kampus.database.User;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.Map;

public class Profil extends AppCompatActivity {

    private FirebaseDatabase getDatabase;
    FirebaseAuth Mauth;
    private DatabaseReference database;
    CircularImageView profil;
    TextView firstname, lastname, email, notelp;
    private String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Mauth = FirebaseAuth.getInstance();
        getDatabase = FirebaseDatabase.getInstance();
        database = getDatabase.getReference();
        FirebaseUser user = Mauth.getCurrentUser();


        firstname = findViewById(R.id.firstnameProfil);
        lastname = findViewById(R.id.lastnameProfil);
        email = findViewById(R.id.email_profil);
        notelp = findViewById(R.id.telp_profil);


        database = FirebaseDatabase.getInstance().getReference();
        database.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    User user = noteDataSnapshot.getValue(User.class);
                    user.setKey(noteDataSnapshot.getKey());
                    firstname.setText(user.getFirstName());
                    lastname.setText(user.getLastName());
                    email.setText(user.getEmail());
                    notelp.setText(user.getNoTelfon());
                }
            }
//        User user1 = new User(firstName,lastName,userEmail,userNo);
//        String key = database.push().getKey();
//        database.child(key).setValue(user1);
//
//        database = FirebaseDatabase.getInstance().getReference().child(key);
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                final User user = dataSnapshot.getValue(User.class);
//
//                firstname.setText(user.getFirstName());
//                lastname.setText(user.getLastName());
//                notelp.setText(user.getNoTelfon());
//                email.setText(user.getEmail());
//            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Button btn_editProfil = findViewById(R.id.btn_editProfil);
        btn_editProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, EditProfil.class);
                startActivity(intent);
            }
        });
    }

}
