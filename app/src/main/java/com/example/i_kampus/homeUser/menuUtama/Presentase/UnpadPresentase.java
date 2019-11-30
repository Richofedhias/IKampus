package com.example.i_kampus.homeUser.menuUtama.Presentase;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class UnpadPresentase extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private float[] data = {1000,
            1300,
            1200,
            1400,
            1400,
            1400,
            1400,
            900,
            1200,
            1300,
            1300,
            1300,
            1300,
            1300,
            1300,
            1300
    };
    private String[] fakultas = {"Fakultas Hukum","Fakultas Ekonomi dan Bisnis",
            "Fakultas Kedokteran",
            "Fakultas Matematika dan Ilmu Pengetahuan Alam",
            "Fakultas Pertanian",
            "Fakultas Kedokteran Gigi",
            "Fakultas Ilmu Budaya",
            "Fakultas Ilmu Sosial dan Ilmu Politik",
            "Fakultas Psikologi",
            "Fakultas Ilmu Komunikasi",
            "Fakultas Keperawatan",
            "Fakultas Perikanan dan Ilmu Kelautan",
            "Fakultas Teknologi Industri Pertanian",
            "Fakultas Farmasi",
            "Fakultas Teknik Geologi",
            "Fakultas Peternakan",
            "Pascasarjana"
    };
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unpad_presentase);

        //Presentasi dengan Pie Chart
        pieChart = findViewById(R.id.unpad_pieChart);

        pieChart.setCenterText("Fakultas");
        pieChart.setCenterTextSize(14);

        addDataSet();

        spinner = findViewById(R.id.unpad_spPresentase);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unpad_presentase, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addDataSet() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            entries.add(new PieEntry(data[i],i));
        }

        for (int i = 1; i < fakultas.length; i++) {
            strings.add(fakultas[i]);
        }

        PieDataSet pieDataSet = new PieDataSet(entries,"Fakultas yang tersedia");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#800080"));
        colors.add(Color.parseColor("#FF00FF"));
        colors.add(Color.parseColor("#000080"));
        colors.add(Color.parseColor("#0000FF"));
        colors.add(Color.parseColor("#008080"));
        colors.add(Color.parseColor("#00FFFF"));
        colors.add(Color.parseColor("#008000"));
        colors.add(Color.parseColor("#808000"));
        colors.add(Color.parseColor("#FFFF00"));
        colors.add(Color.parseColor("#800000"));
        colors.add(Color.parseColor("#FF0000"));
        colors.add(Color.parseColor("#C0C0C0"));
        colors.add(Color.parseColor("#808080"));
        colors.add(Color.parseColor("#44A226"));
        colors.add(Color.parseColor("#B20B50"));
        colors.add(Color.parseColor("#A4A709"));

        pieDataSet.setColors(colors);

        Legend l = pieChart.getLegend();
        l.setForm(Legend.LegendForm.CIRCLE);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
