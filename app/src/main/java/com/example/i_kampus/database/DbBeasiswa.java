package com.example.i_kampus.database;

public class DbBeasiswa {
    String idBeasiswa,namaKampus,namaBeasiswa,deskripsiBeasiswa,jenisBeasiswa,tanggalbeasiswa,gambarBeasiswa;
    String tanggalAhkirBeasiswa;

    public DbBeasiswa() {
    }

    public DbBeasiswa(String namaBeasiswa, String deskripsiBeasiswa, String jenisBeasiswa, String tanggalbeasiswa, String gambarBeasiswa) {
        this.namaBeasiswa = namaBeasiswa;
        this.deskripsiBeasiswa = deskripsiBeasiswa;
        this.jenisBeasiswa = jenisBeasiswa;
        this.tanggalbeasiswa = tanggalbeasiswa;
        this.gambarBeasiswa = gambarBeasiswa;
    }

    public String getIdBeasiswa() {
        return idBeasiswa;
    }

    public void setIdBeasiswa(String idBeasiswa) {
        this.idBeasiswa = idBeasiswa;
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public void setNamaKampus(String namaKampus) {
        this.namaKampus = namaKampus;
    }

    public String getNamaBeasiswa() {
        return namaBeasiswa;
    }

    public void setNamaBeasiswa(String namaBeasiswa) {
        this.namaBeasiswa = namaBeasiswa;
    }

    public String getDeskripsiBeasiswa() {
        return deskripsiBeasiswa;
    }

    public void setDeskripsiBeasiswa(String deskripsiBeasiswa) {
        this.deskripsiBeasiswa = deskripsiBeasiswa;
    }

    public String getJenisBeasiswa() {
        return jenisBeasiswa;
    }

    public void setJenisBeasiswa(String jenisBeasiswa) {
        this.jenisBeasiswa = jenisBeasiswa;
    }

    public String getTanggalbeasiswa() {
        return tanggalbeasiswa;
    }

    public void setTanggalbeasiswa(String tanggalbeasiswa) {
        this.tanggalbeasiswa = tanggalbeasiswa;
    }

    public String getGambarBeasiswa() {
        return gambarBeasiswa;
    }

    public void setGambarBeasiswa(String gambarBeasiswa) {
        this.gambarBeasiswa = gambarBeasiswa;
    }
}
