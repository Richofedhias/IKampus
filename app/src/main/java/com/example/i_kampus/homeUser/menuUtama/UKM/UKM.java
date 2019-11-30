package com.example.i_kampus.homeUser.menuUtama.UKM;

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
import com.example.i_kampus.database.Dbukm;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UKM extends AppCompatActivity {
    private DatabaseReference database;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    RecyclerView rv_ukm;
    ArrayList<Dbukm> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukm);

        database = FirebaseDatabase.getInstance().getReference("UKM");
        database.keepSynced(true);

        rv_ukm = findViewById(R.id.ukm);
        rv_ukm.setHasFixedSize(true);
        rv_ukm.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Dbukm, UKM.UKMViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Dbukm, UKM.UKMViewHolder>(Dbukm.class, R.layout.list_ukm_item, UKM.UKMViewHolder.class , database) {
            @Override
            protected void populateViewHolder(UKMViewHolder viewHolder, Dbukm model, int position) {
                viewHolder.setImage(UKM.this,model.getGambarUkm());
                viewHolder.setNamaUKM(model.getNamaUkm());
            }
        };

        rv_ukm.setAdapter(firebaseRecyclerAdapter);
    }

    public static class UKMViewHolder extends RecyclerView.ViewHolder {

        public UKMViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setNamaUKM(String namaUKM) {
            TextView nama = itemView.findViewById(R.id.namaUKM_list);
            nama.setText(namaUKM);
        }

        public void setImage(Context context, String Image) {
            ImageView gambar = itemView.findViewById(R.id.gambar_UKM);
            Picasso.with(context).load(Image).into(gambar);
        }
    }
}
