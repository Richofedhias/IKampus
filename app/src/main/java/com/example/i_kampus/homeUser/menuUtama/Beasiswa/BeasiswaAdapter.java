package com.example.i_kampus.homeUser.menuUtama.Beasiswa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i_kampus.R;

import java.util.ArrayList;

public class BeasiswaAdapter extends RecyclerView.Adapter<BeasiswaAdapter.myViewHolder> {

    ArrayList<BeasiswaList> beasiswaLists;

    public BeasiswaAdapter(ArrayList<BeasiswaList> beasiswaLists) {
        this.beasiswaLists = beasiswaLists;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_beasiswa_item,viewGroup,false);
        return new BeasiswaAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        BeasiswaList nama = beasiswaLists.get(i);
        myViewHolder.judul.setText(nama.getJudul());
        myViewHolder.pendaftaran.setText(nama.getPendaftaran());
        myViewHolder.tes.setText(nama.getTes());
        myViewHolder.gambar.setImageResource(nama.getImage());
    }

    @Override
    public int getItemCount() { return beasiswaLists.size(); }

    class myViewHolder extends RecyclerView.ViewHolder {

        final TextView judul, pendaftaran, tes;
        final ImageView gambar;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            pendaftaran = itemView.findViewById(R.id.pendaftaran);
            tes = itemView.findViewById(R.id.tes);
            gambar = itemView.findViewById(R.id.gambarBeasiswa);
        }
    }
}
