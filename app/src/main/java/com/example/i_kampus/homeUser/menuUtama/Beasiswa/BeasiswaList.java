package com.example.i_kampus.homeUser.menuUtama.Beasiswa;

public class BeasiswaList {
    String judul;
    int image;
    String pendaftaran;
    String tes;

    public BeasiswaList(String judul, int image, String pendaftaran) {
        this.judul = judul;
        this.image = image;
        this.pendaftaran = pendaftaran;
    }

    public BeasiswaList(String judul, int image, String pendaftaran, String tes) {
        this.judul = judul;
        this.image = image;
        this.pendaftaran = pendaftaran;
        this.tes = tes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPendaftaran() {
        return pendaftaran;
    }

    public void setPendaftaran(String pendaftaran) {
        this.pendaftaran = pendaftaran;
    }

    public String getTes() {
        return tes;
    }

    public void setTes(String tes) {
        this.tes = tes;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
