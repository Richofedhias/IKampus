package com.example.i_kampus.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i_kampus.R;

public class slideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public slideAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.prodi,
            R.drawable.beasiswa,
            R.drawable.presentase,
            R.drawable.latihansoal
    };

    public String [] slider_headling = {
            "PRODI",
            "BEASISWA",
            "PRESENTASE",
            "KUISIONER"
    };

    public String[] slide_desc = {
            "Berisi Informasi tentang program studi yang ada di Peguruan Tinggi",
            "Berisi Informasi tentang Beasiswa yang ada di Peguruan Tinggi",
            "Berisi Informasi tentang Presentase fakultas dengan peminat terbanyak di Peguruan Tinggi tersebut",
            "Berisi Kuesioner Psikologi dan Kuesioner Penjurusan"
    };


    @Override
    public int getCount() {
        return slider_headling.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.slide_layout, container, false);

        ImageView sliderview = view.findViewById(R.id.slide_image);
        TextView sliderhead = view.findViewById(R.id.slide_heading);
        TextView sliderdesc = view.findViewById(R.id.slide_desc);

        sliderview.setImageResource(slide_images[position]);
        sliderhead.setText(slider_headling[position]);
        sliderdesc.setText(slide_desc[position]);

        container.addView(view);

            return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);
    }
}
