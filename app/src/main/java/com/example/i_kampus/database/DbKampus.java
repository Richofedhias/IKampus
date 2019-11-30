package com.example.i_kampus.database;

public class DbKampus {
    private String idKampus, namaKampus, deskripsiKampus, lokasiKampus, noTelpKampus, emailKampus,gambarKampus;

    public DbKampus() {
    }

    public DbKampus(String deskripsiKampus, String lokasiKampus, String noTelpKampus, String emailKampus, String gambarKampus) {
        this.deskripsiKampus = deskripsiKampus;
        this.lokasiKampus = lokasiKampus;
        this.noTelpKampus = noTelpKampus;
        this.emailKampus = emailKampus;
        this.gambarKampus = gambarKampus;
    }

    public String getIdKampus() {
        return idKampus;
    }

    public void setIdKampus(String idKampus) {
        this.idKampus = idKampus;
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public void setNamaKampus(String namaKampus) {
        this.namaKampus = namaKampus;
    }

    public String getDeskripsiKampus() {
        return this.deskripsiKampus;
    }

    public void setDeskripsiKampus(String deskripsiKampus) {
        this.deskripsiKampus = deskripsiKampus;
    }

    public String getLokasiKampus() {
        return this.lokasiKampus;
    }

    public void setLokasiKampus(String lokasiKampus) {
        this.lokasiKampus = lokasiKampus;
    }

    public String getNoTelpKampus() {
        return noTelpKampus;
    }

    public void setNoTelpKampus(String noTelpKampus) {
        this.noTelpKampus = noTelpKampus;
    }

    public String getEmailKampus() {
        return this.emailKampus;
    }

    public void setEmailKampus(String emailKampus) {
        this.emailKampus = emailKampus;
    }

    public String getGambarKampus() {
        return gambarKampus;
    }

    public void setGambarKampus(String gambarKampus) {
        this.gambarKampus = gambarKampus;
    }
}

