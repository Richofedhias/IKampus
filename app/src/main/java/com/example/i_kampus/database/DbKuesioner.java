package com.example.i_kampus.database;

import android.app.Application;

import com.firebase.client.Firebase;

public class DbKuesioner extends Application {
//    private int _ID;
//    private String Soal;
//    private String OPTA;
//    private String OPTB;
//    private String OPTC;
//    private String OPTD;
//    private String OPTE;
//    private String Jawaban;
//
//    public DbKuesioner()
//    {
//        _ID=0;
//        Soal="";
//        OPTA="";
//        OPTB="";
//        OPTC="";
//        OPTD="";
//        OPTE="";
//        Jawaban="";
//    }
//
//    public DbKuesioner(String soal, String OPTA, String OPTB, String OPTC, String OPTD, String OPTE, String jawaban) {
//        Soal = soal;
//        this.OPTA = OPTA;
//        this.OPTB = OPTB;
//        this.OPTC = OPTC;
//        this.OPTD = OPTD;
//        this.OPTE = OPTE;
//        Jawaban = jawaban;
//    }
//
//    public int get_ID() {
//        return _ID;
//    }
//
//    public void set_ID(int _ID) {
//        this._ID = _ID;
//    }
//
//    public String getSoal() {
//        return Soal;
//    }
//
//    public void setSoal(String soal) {
//        Soal = soal;
//    }
//
//    public String getOPTA() {
//        return OPTA;
//    }
//
//    public void setOPTA(String OPTA) {
//        this.OPTA = OPTA;
//    }
//
//    public String getOPTB() {
//        return OPTB;
//    }
//
//    public void setOPTB(String OPTB) {
//        this.OPTB = OPTB;
//    }
//
//    public String getOPTC() {
//        return OPTC;
//    }
//
//    public void setOPTC(String OPTC) {
//        this.OPTC = OPTC;
//    }
//
//    public String getOPTD() {
//        return OPTD;
//    }
//
//    public void setOPTD(String OPTD) {
//        this.OPTD = OPTD;
//    }
//
//    public String getOPTE() {
//        return OPTE;
//    }
//
//    public void setOPTE(String OPTE) {
//        this.OPTE = OPTE;
//    }
//
//    public String getJawaban() {
//        return Jawaban;
//    }
//
//    public void setJawaban(String jawaban) {
//        Jawaban = jawaban;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
