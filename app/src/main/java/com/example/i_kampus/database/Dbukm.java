package com.example.i_kampus.database;

public class Dbukm {
    String idUkm,namaKampus,namaUkm,deskripsiUkm,gambarUkm;

    public Dbukm() {
    }

    public Dbukm(String namaUkm, String deskripsiUkm, String gambarUkm) {
        this.namaUkm = namaUkm;
        this.deskripsiUkm = deskripsiUkm;
        this.gambarUkm = gambarUkm;
    }

    public String getIdUkm() {
        return idUkm;
    }

    public void setIdUkm(String idUkm) {
        this.idUkm = idUkm;
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public void setNamaKampus(String namaKampus) {
        this.namaKampus = namaKampus;
    }

    public String getNamaUkm() {
        return namaUkm;
    }

    public void setNamaUkm(String namaUkm) {
        this.namaUkm = namaUkm;
    }

    public String getDeskripsiUkm() {
        return deskripsiUkm;
    }

    public void setDeskripsiUkm(String deskripsiUkm) {
        this.deskripsiUkm = deskripsiUkm;
    }

    public String getGambarUkm() {
        return gambarUkm;
    }

    public void setGambarUkm(String gambarUkm) {
        this.gambarUkm = gambarUkm;
    }
}
