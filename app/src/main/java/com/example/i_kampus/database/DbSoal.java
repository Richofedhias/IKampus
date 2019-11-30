package com.example.i_kampus.database;

import android.app.Activity;
import android.app.Application;

import com.firebase.client.Firebase;

public class DbSoal {

    public String question, opsiA, opsiB, opsiC, opsiD, opsiE, jawaban;

    public DbSoal() {
    }

    public DbSoal(String question, String opsiA, String opsiB, String opsiC, String opsiD, String opsiE, String jawaban) {
        this.question = question;
        this.opsiA = opsiA;
        this.opsiB = opsiB;
        this.opsiC = opsiC;
        this.opsiD = opsiD;
        this.opsiE = opsiE;
        this.jawaban = jawaban;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpsiA() {
        return opsiA;
    }

    public void setOpsiA(String opsiA) {
        this.opsiA = opsiA;
    }

    public String getOpsiB() {
        return opsiB;
    }

    public void setOpsiB(String opsiB) {
        this.opsiB = opsiB;
    }

    public String getOpsiC() {
        return opsiC;
    }

    public void setOpsiC(String opsiC) {
        this.opsiC = opsiC;
    }

    public String getOpsiD() {
        return opsiD;
    }

    public void setOpsiD(String opsiD) {
        this.opsiD = opsiD;
    }

    public String getOpsiE() {
        return opsiE;
    }

    public void setOpsiE(String opsiE) {
        this.opsiE = opsiE;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
