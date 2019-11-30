package com.example.i_kampus.homeUser.menuUtama;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.i_kampus.homeUser.Awal.Kategori;
import com.example.i_kampus.R;
import com.example.i_kampus.homeUser.Awal.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.mikhaellopez.circularimageview.CircularImageView;

public class AboutUs extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {
    CircularImageView infoRicho, infoZahara, infoMilzam;
    DrawerLayout drawer;
    NavigationView navigationView;
    CircularImageView profil;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us2);

        infoRicho = findViewById(R.id.infoRicho);
        infoZahara = findViewById(R.id.infoZahara);
        infoMilzam = findViewById(R.id.infoMilzam);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        View header = navigationView.getHeaderView(0);
        profil = header.findViewById(R.id.profile);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AboutUs.this, Profil.class);
                startActivity(intent);
            }
        });

        infoRicho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klikRicho();
            }
        });
        infoZahara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klikZahara();
            }
        });
        infoMilzam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klikMilzam();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Apakah Kamu yakin untuk Keluar ?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        firebaseAuth.signOut();
                        Intent i = new Intent(AboutUs.this,Login.class);
                        startActivity(i);
                        AboutUs.super.onBackPressed();
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
                Intent h= new Intent(AboutUs.this,BerandaNew.class);
                startActivity(h);
                finish();
                break;
            case R.id.nav_about:
                Intent i= new Intent(AboutUs.this, AboutUs.class);
                startActivity(i);
                finish();
                break;
            case R.id.nav_help:
                Intent g= new Intent(AboutUs.this, Bantuan.class);
                startActivity(g);
                finish();
                break;
            case R.id.nav_exit:
                firebaseAuth.signOut();
                Intent k= new Intent(AboutUs.this, Login.class);
                startActivity(k);
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void klikRicho() {
        DialogRichoActivity informationDialog = new DialogRichoActivity();
        informationDialog.show(getSupportFragmentManager(), "information dialog");
    }

    private void klikZahara() {
        DialogPutriActivity informationDialog = new DialogPutriActivity();
        informationDialog.show(getSupportFragmentManager(), "information dialog");
    }

    private void klikMilzam() {
        DialogMilzamActivity informationDialog = new DialogMilzamActivity();
        informationDialog.show(getSupportFragmentManager(), "information dialog");
    }
}
