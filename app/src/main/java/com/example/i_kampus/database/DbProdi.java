package com.example.i_kampus.database;

public class DbProdi {
    String idProdi,namaKampus,namaProdi,deskripsiProdi,akreditasiProdi,gambar;

    public DbProdi() {
    }

    public DbProdi(String namaProdi, String akreditasiProdi, String gambar) {
        this.namaProdi = namaProdi;
        this.akreditasiProdi = akreditasiProdi;
        this.gambar = gambar;
    }

    public DbProdi(String namaProdi, String deskripsiProdi, String akreditasiProdi, String gambar) {
        this.namaProdi = namaProdi;
        this.deskripsiProdi = deskripsiProdi;
        this.akreditasiProdi = akreditasiProdi;
        this.gambar = gambar;
    }

    public String getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(String idProdi) {
        this.idProdi = idProdi;
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public void setNamaKampus(String namaKampus) {
        this.namaKampus = namaKampus;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    public String getDeskripsiProdi() {
        return deskripsiProdi;
    }

    public void setDeskripsiProdi(String deskripsiProdi) {
        this.deskripsiProdi = deskripsiProdi;
    }

    public String getAkreditasiProdi() {
        return akreditasiProdi;
    }

    public void setAkreditasiProdi(String akreditasiProdi) {
        this.akreditasiProdi = akreditasiProdi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
