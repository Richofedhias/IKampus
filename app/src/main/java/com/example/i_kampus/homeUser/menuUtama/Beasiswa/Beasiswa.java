package com.example.i_kampus.homeUser.menuUtama.Beasiswa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbBeasiswa;
import com.example.i_kampus.database.Dbukm;
import com.example.i_kampus.homeUser.menuUtama.UKM.UKM;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Beasiswa extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private RecyclerView rv_list;
    private ArrayList<BeasiswaList> daftar = new ArrayList<>();
    private BeasiswaAdapter beasiswaAdapter;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beasiswa);

        rv_list = findViewById(R.id.list_beasiswa);
//        database = FirebaseDatabase.getInstance().getReference("Beasiswa");
//        database.keepSynced(true);

        beasiswaAdapter = new BeasiswaAdapter(daftar);
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setItemAnimator(new DefaultItemAnimator());
        rv_list.setAdapter(beasiswaAdapter);
        daftarMahasiswa();
        rv_list.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        spinner = findViewById(R.id.spBeasiswa);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.beasiswa, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseRecyclerAdapter<DbBeasiswa, Beasiswa.BeasiswaViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<DbBeasiswa, Beasiswa.BeasiswaViewHolder>(DbBeasiswa.class, R.layout.list_beasiswa_item, Beasiswa.BeasiswaViewHolder.class , database) {
//            @Override
//            protected void populateViewHolder(BeasiswaViewHolder viewHolder, DbBeasiswa model, int position) {
//                viewHolder.setImage(Beasiswa.this,model.getGambarBeasiswa());
//                viewHolder.setNamaBeasiswa(model.getNamaBeasiswa());
//                viewHolder.setTanggalBeasiswa(model.getTanggalbeasiswa());
//            }
//        };
//
//        rv_list.setAdapter(firebaseRecyclerAdapter);
//    }
//
//    public static class BeasiswaViewHolder extends RecyclerView.ViewHolder {
//
//        public BeasiswaViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//
//        public void setNamaBeasiswa(String namaBeasiswa) {
//            TextView nama = itemView.findViewById(R.id.judul);
//            nama.setText(namaBeasiswa);
//        }
//
//        public void setTanggalBeasiswa(String TanggalBeasiswa) {
//            TextView tgl = itemView.findViewById(R.id.pendaftaran);
//            tgl.setText(TanggalBeasiswa);
//        }
//
//        public void setImage(Context context, String Image) {
//            ImageView gambar = itemView.findViewById(R.id.gambarBeasiswa);
//            Picasso.with(context).load(Image).into(gambar);
//        }
//    }

    public void daftarMahasiswa(){
        daftar.add(new BeasiswaList("Beasiswa Jalur Prestasi Unggulan (JPU) 2019",R.drawable.beasiswa_jpu,"11 Februari 2019 s.d 27 April 2019","28 April 2019"));
        daftar.add(new BeasiswaList("Beasiswa FOJB (Forum OSIS Jawa Barat) 2019",R.drawable.beasiswa_fojb,"7 Januari 2019 s.d 9 Februari 2019","-"));
        daftar.add(new BeasiswaList("Beasiswa OSC (Online Scholarship Competition) 2019",R.drawable.beasiswa_osc,"30 Agustus 2018 s.d 2 November 2018","4 November 2018"));
        beasiswaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
