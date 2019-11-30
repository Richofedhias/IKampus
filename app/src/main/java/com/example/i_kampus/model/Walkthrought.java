package com.example.i_kampus.model;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i_kampus.homeUser.Awal.Login;
import com.example.i_kampus.R;
//import com.firebase.client.snapshot.Index;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class Walkthrought extends AppCompatActivity {
    private ViewPager slideview;
    private LinearLayout mDOtLayout;

    private Button next;
    private Button prev;
    private Button skip;

    private int mCurrent;

    private TextView[] mdots;

    private slideAdapter slide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrought);
        try {
            InputStream inputStream = Walkthrought.this.openFileInput("confirm.txt");
            Intent intent = new Intent(Walkthrought.this, Login.class);
            startActivity(intent);
            finish();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, showing tutorial");
        }
        slideview = findViewById(R.id.viewPager);
        mDOtLayout = findViewById(R.id.dotslayout);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int batas = slideview.getCurrentItem()+3;
               slideview.setCurrentItem(batas);
            }
        });

        slide = new slideAdapter(this);
        addDotsIndicator(0);
        slideview.addOnPageChangeListener(view);

        slideview.setAdapter(slide);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int batas = slideview.getCurrentItem()+1;
                if (batas < mdots.length){
                    slideview.setCurrentItem(batas);
                }else{
                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Walkthrought.this.openFileOutput("confirm.txt", Context.MODE_PRIVATE));
                        outputStreamWriter.write("true");
                        outputStreamWriter.close();
                    } catch (Exception e) {
                        Toast.makeText(Walkthrought.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(Walkthrought.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideview.setCurrentItem(mCurrent-1);

            }
        });
    }
    public void addDotsIndicator(int position){
        mdots = new TextView[4];
        mDOtLayout.removeAllViews();
        for (int i = 0; i < mdots.length; i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorTransparan));

            mDOtLayout.addView(mdots[i]);

        }
        if (mdots.length>0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    ViewPager.OnPageChangeListener view = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            mCurrent = i;
            if (i == 0){
                next.setEnabled(true);
                prev.setEnabled(false);
                prev.setVisibility(View.INVISIBLE);

                next.setText("Next");
                prev.setText("");
            }else if (i == mdots.length-1){

                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);

                next.setText("Finish");
                prev.setText("Back");
            }else {

                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);

                next.setText("Next");
                prev.setText("Back");
            }
        }

        private void startMainActivity(){


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
