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

public class Presentase extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private float[] data = {1000, 1300, 1200,1400,900, 1200,1300};
    private String[] fakultas = {"FIT","FIK", "FEB", "FKB", "FRI", "FTE", "FIF"};
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentase);

        //Presentasi dengan Pie Chart
        pieChart = findViewById(R.id.pieChart);

        pieChart.setCenterText("Fakultas");
        pieChart.setCenterTextSize(14);

        addDataSet();

        spinner = findViewById(R.id.unpad_spPresentase);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.presentase, android.R.layout.simple_spinner_item);
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
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);
        colors.add(Color.CYAN);

        pieDataSet.setColors(colors);

        Legend l = pieChart.getLegend();
        l.setForm(Legend.LegendForm.CIRCLE);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
