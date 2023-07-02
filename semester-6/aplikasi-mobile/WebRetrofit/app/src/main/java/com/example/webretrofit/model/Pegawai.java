package com.example.webretrofit.model;

public class Pegawai {
    String kode;
    String nama;
    String jabatan;
    int gaji;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public Pegawai(String kode, String nama, String jabatan, int gaji) {
        this.kode = kode;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }
}
