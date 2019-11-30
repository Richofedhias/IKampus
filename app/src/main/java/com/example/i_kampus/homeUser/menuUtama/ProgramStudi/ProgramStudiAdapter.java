package com.example.i_kampus.homeUser.menuUtama.ProgramStudi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbProdi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProgramStudiAdapter extends RecyclerView.Adapter<ProgramStudiAdapter.ProdiHolder> {
    List<DbProdi> prodiLists;
    private Activity mActivity;

    public ProgramStudiAdapter(List<DbProdi> prodiLists, Activity mActivity) {
        this.prodiLists = prodiLists;
        this.mActivity = mActivity;
    }

    @NonNull
    @Override
    public ProdiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_prodi_item, viewGroup, false);
        return new ProdiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdiHolder prodiHolder, int i) {
        DbProdi list = prodiLists.get(i);
        prodiHolder.tvNamaProdi.setText(list.getNamaProdi());
        prodiHolder.tvAkreditasi.setText(list.getAkreditasiProdi());
        Picasso.with(mActivity).load(list.getGambar()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(prodiHolder.ivLogoProdi);
    }

    @Override
    public int getItemCount() {
        return prodiLists.size();
    }

    public class ProdiHolder extends RecyclerView.ViewHolder {
        public LinearLayout lr_layout;
        public TextView tvNamaProdi, tvAkreditasi;
        public ImageView ivLogoProdi;

        public ProdiHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaProdi = itemView.findViewById(R.id.namaProdi_list);
            tvAkreditasi = itemView.findViewById(R.id.akreditasi);
            ivLogoProdi = itemView.findViewById(R.id.gambar_prodi);
        }
    }
}
