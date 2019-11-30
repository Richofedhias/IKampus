package com.example.i_kampus.homeUser.menuUtama;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.i_kampus.homeUser.Awal.Login;
import com.example.i_kampus.homeUser.menuKuesioner.KuesionerPenjurusan;
import com.example.i_kampus.homeUser.menuUtama.Beasiswa.UnpadBeasiswa;
import com.example.i_kampus.R;
import com.example.i_kampus.database.User;
import com.example.i_kampus.homeUser.menuUtama.Kampus.UnpadKampus;
import com.example.i_kampus.homeUser.menuUtama.Presentase.UnpadPresentase;
import com.example.i_kampus.homeUser.menuUtama.ProgramStudi.UnpadProgramStudi;
import com.example.i_kampus.homeUser.menuUtama.UKM.UnpadUKM;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularimageview.CircularImageView;

public class UnpadBeranda extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private TextView tVuser;
    private ImageView gambar;
    //    private ImageButton kampus,beasiswa,prodi,ukm,presentase,latihan;
    private String userID;
    DrawerLayout drawer;
    LinearLayout linearKampus, linearBeasiswa, linearProdi, linearUKM, linearPresentase, linearLatihan;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase getDatabase;
    private DatabaseReference database;
    CircularImageView profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unpad_beranda);
        gambar = findViewById(R.id.gambarBeasiswa);
        linearKampus = findViewById(R.id.infoKampus);
        linearBeasiswa = findViewById(R.id.infoBeasiswa);
        linearProdi = findViewById(R.id.infoProdi);
        linearUKM= findViewById(R.id.infoUKM);
        linearPresentase = findViewById(R.id.infoPresentase);
        linearLatihan = findViewById(R.id.LatihanSoal);
        tVuser = findViewById(R.id.user);
        navigationView = findViewById(R.id.nav_view);
        firebaseAuth = FirebaseAuth.getInstance();
        View header = navigationView.getHeaderView(0);
        profil = header.findViewById(R.id.profile);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(UnpadBeranda.this, Profil.class);
                startActivity(intent);
            }
        });

        database = FirebaseDatabase.getInstance().getReference();
        database.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    User user = noteDataSnapshot.getValue(User.class);
                    user.setKey(noteDataSnapshot.getKey());
                    tVuser.setText(user.getFirstName());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        linearKampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnpadBeranda.this, UnpadKampus.class);
                startActivity(intent);
            }
        });

        linearBeasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnpadBeranda.this, UnpadBeasiswa.class);
                startActivity(intent);
            }
        });

        linearProdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnpadBeranda.this, UnpadProgramStudi.class);
                startActivity(intent);
            }
        });

        linearUKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnpadBeranda.this, UnpadUKM.class);
                startActivity(intent);
            }
        });

        linearPresentase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnpadBeranda.this, UnpadPresentase.class);
                startActivity(intent);
            }
        });

        linearLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(UnpadBeranda.this, KuesionerPenjurusan.class);
                startActivity(inten);
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Apakah Kamu yakin untuk Keluar ?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        firebaseAuth.signOut();
                        Intent i = new Intent(UnpadBeranda.this,Login.class);
                        startActivity(i);
                        UnpadBeranda.super.onBackPressed();
                        finish();
                    }
                })

                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.beranda_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id=item.getItemId();
        switch (id){

            case R.id.nav_beranda:
                Intent h= new Intent(UnpadBeranda.this,UnpadBeranda.class);
                startActivity(h);
                finish();
                break;
            case R.id.nav_about:
                Intent i= new Intent(UnpadBeranda.this, AboutUs.class);
                startActivity(i);
                finish();
                break;
            case R.id.nav_help:
                Intent g= new Intent(UnpadBeranda.this, Bantuan.class);
                startActivity(g);
                finish();
                break;
            case R.id.nav_exit:
                firebaseAuth.signOut();
                Intent k= new Intent(UnpadBeranda.this, Login.class);
                startActivity(k);
                finish();
                break;
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
