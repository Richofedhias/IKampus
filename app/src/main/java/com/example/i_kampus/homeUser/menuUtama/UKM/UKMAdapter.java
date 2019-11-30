//package com.example.i_kampus.homeUser.menuUtama.UKM;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.example.i_kampus.R;
//import com.example.i_kampus.database.Dbukm;
//
//import java.util.ArrayList;
//
//public class UKMAdapter extends RecyclerView.Adapter<UKMAdapter.UKMHolder> {
//    ArrayList<Dbukm> ukmLists;
//    private Activity mActivity;
//
//    public UKMAdapter(ArrayList<Dbukm> ukmLists, Activity mActivity) {
//        this.ukmLists = ukmLists;
//        this.mActivity = mActivity;
//    }
//
//    @NonNull
//    @Override
//    public UKMHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_ukm_item, viewGroup, false);
//        return new UKMHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UKMHolder ukmHolder, int i) {
//        final Dbukm list = ukmLists.get(i);
//        ukmHolder.tvNamaUKM.setText(list.getNamaUkm());
//        ukmHolder.ivLogoUKM.setImageResource(list.getGambarUKM());
//        ukmHolder.lr_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent goDetail = new Intent(mActivity, ProdiDetail.class);
////                goDetail.putExtra("id", list.getKey());
////                goDetail.putExtra("", list.getNama_UKM());
////                goDetail.putExtra("", list.getLogo_UKM());
////
////                mActivity.startActivity(goDetail);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return ukmLists.size();
//    }
//
//    public class UKMHolder extends RecyclerView.ViewHolder {
//        public LinearLayout lr_layout;
//        public TextView tvNamaUKM;
//        public ImageView ivLogoUKM;
//
//        public UKMHolder(@NonNull View itemView) {
//            super(itemView);
//            tvNamaUKM = itemView.findViewById(R.id.namaUKM_list);
//            ivLogoUKM = itemView.findViewById(R.id.gambar_UKM);
//        }
//    }
//}
