package com.example.webretrofit.INTERFACE;

import com.example.webretrofit.model.Pegawai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfacePegawai {
    @GET("pegawai/")
    Call<List<Pegawai>> displayPegawai();

    @GET("guru/")
    Call<List<Pegawai>> displayGuru();
}
