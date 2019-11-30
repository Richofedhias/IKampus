package com.example.i_kampus.homeUser.menuUtama.Kampus;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbKampus;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class UnpadKampus extends AppCompatActivity {
    private TextView deskripsi, lokasi, email, noTelp;
    private DatabaseReference reference;
    private FirebaseAuth auth;
    private FirebaseDatabase getDatabase;
    private String GetUserID;
    private ImageView gambar;
    private int total = 1;

    private void inisialisasi() {
        deskripsi = findViewById(R.id.deskripsiKampus);
        lokasi = findViewById(R.id.tVlokasi);
        email = findViewById(R.id.tVemail);
        noTelp = findViewById(R.id.tVnoTelp);
        gambar = findViewById(R.id.gambar_kampus);
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampus);
        inisialisasi();
//        reference = FirebaseDatabase.getInstance().getReference("Kampus").child("2");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                final DbKampus dbKampus = dataSnapshot.getValue(DbKampus.class);
//
//                deskripsi.setText(dbKampus.getDeskripsiKampus());
//                lokasi.setText(dbKampus.getLokasiKampus());
//                noTelp.setText(dbKampus.getNoTelpKampus());
//                email.setText(dbKampus.getEmailKampus());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        reference = FirebaseDatabase.getInstance().getReference().child("key");
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                DbKampus data = dataSnapshot.getValue(DbKampus.class);
//                deskripsi.setText(data.getDeskripsiKampus());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//       showKampus();

        /*
         * Mendapatkan referensi dari lokasi Admin dan tutunannya yaitu User ID dari masing-masing
         * akun user dan menambahkan ChildListener untuk menangani kejadian saat data ditambahkan,
         * diubah, dihapus dan dialihkan.
         */
//        reference.child("i-kampus").child(GetUserID).addChildEventListener(new ChildEventListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                //Mengambil daftar item dari database, setiap kali ada turunannya
//                DbKampus dbKampus = dataSnapshot.getValue(DbKampus.class);
//                deskripsi.setText(dbKampus.getDeskripsiKampus());
//                lokasi.setText(dbKampus.getLokasiKampus());
//                email.setText(dbKampus.getEmailKampus());
//                noTelp.setText(dbKampus.getNoTelpKampus());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                //......
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                //......
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//                //.....
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //Digunakan untuk menangani kejadian Error
//                Log.e("MyListData", "Error: ", databaseError.toException());
//            }
    }
}



//
//    private void showKampus() {
//       reference = FirebaseDatabase.getInstance().getReference();
//      reference.child("Kampus").addValueEventListener(new ValueEventListener() {
//           @Override
//               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//               String id = dataSnapshot.getKey();
//               String deskripsiKampus = dataSnapshot.child("deskripsiKampus").getValue().toString();
//              String lokasiKampus = dataSnapshot.child("lokasiKampus").getValue().toString();
//               String emailKampus = dataSnapshot.child("emailKampus").getValue().toString();
//               String telpKampus = dataSnapshot.child("noTelpKampus").getValue().toString();
//
//               DbKampus dbKampus = new DbKampus();
//               deskripsi.setText(dbKampus.getDeskripsiKampus(deskripsiKampus));
//               lokasi.setText(dbKampus.getLokasiKampus(lokasiKampus));
//               email.setText(dbKampus.getEmailKampus());
//               noTelp.setText(dbKampus.getNoTelpKampus());
//               Log.d("apa","value is : "+ dbKampus);
//           }
//
//          @Override
//           public void onCancelled(@NonNull DatabaseError databaseError) {
//               Log.d("yahh","Gagal Memunculkan Firebase", databaseError.toException());
//           }
//       });
//    }
//    }


