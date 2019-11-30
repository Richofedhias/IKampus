package com.example.i_kampus.homeUser.menuUtama.ProgramStudi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbProdi;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UnpadProgramStudi extends AppCompatActivity {

    private DatabaseReference database;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    private ArrayList<DbProdi> prodiLists;
    private RecyclerView rv_Prodilist;
    private ProgramStudiAdapter adapter;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unpad_program_studi);

        database = FirebaseDatabase.getInstance().getReference("Prodi");
        database.keepSynced(true);

        rv_Prodilist = findViewById(R.id.prodi);
        rv_Prodilist.setHasFixedSize(true);


//        adapter = new ProgramStudiAdapter(prodiLists,PorgramStudi.this);
        rv_Prodilist.setLayoutManager(new LinearLayoutManager(this));
//        rv_Prodilist.setAdapter(adapter);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<DbProdi, ProdiViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<DbProdi, ProdiViewHolder>(DbProdi.class, R.layout.list_prodi_item, ProdiViewHolder.class , database) {
            @Override
            protected void populateViewHolder(ProdiViewHolder viewHolder, DbProdi model, int position) {
                viewHolder.setImage(UnpadProgramStudi.this,model.getGambar());
                viewHolder.setNamaProdi(model.getNamaProdi());
                viewHolder.setAkreditasi("Akreditasi: " + model.getAkreditasiProdi());
            }
        };
        rv_Prodilist.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ProdiViewHolder extends RecyclerView.ViewHolder {

        public ProdiViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setNamaProdi(String namaProdi) {
            TextView nama = itemView.findViewById(R.id.namaProdi_list);
            nama.setText(namaProdi);
        }

        public void setAkreditasi(String akreditasiProdi) {
            TextView akre = itemView.findViewById(R.id.akreditasi);
            akre.setText(akreditasiProdi);
        }

        public void setImage(Context context, String Image) {
            ImageView gambar = itemView.findViewById(R.id.gambar_prodi);
            Picasso.with(context).load(Image).into(gambar);
        }
    }
}
