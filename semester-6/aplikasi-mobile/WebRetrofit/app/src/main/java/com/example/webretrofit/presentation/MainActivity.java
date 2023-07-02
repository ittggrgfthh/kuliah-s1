package com.example.webretrofit.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.webretrofit.INTERFACE.InterfacePegawai;
import com.example.webretrofit.R;
import com.example.webretrofit.adapter.AdapterPegawai;
import com.example.webretrofit.api.ConnectAPI;
import com.example.webretrofit.model.Pegawai;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_pegawai;
    ArrayList<Pegawai> pegawaiArrayList = new ArrayList<>();
    InterfacePegawai interfacePegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_pegawai = findViewById(R.id.rvPegawai);
        interfacePegawai = ConnectAPI.retrofitConnectAPI().create(InterfacePegawai.class);

        rv_pegawai.setLayoutManager(new LinearLayoutManager(this));
        readData();


    }

    private void readData() {
        Call<List<Pegawai>> pegawaiCall = interfacePegawai.displayGuru();
        pegawaiCall.enqueue(new Callback<List<Pegawai>>() {
            @Override
            public void onResponse(Call<List<Pegawai>> call, Response<List<Pegawai>> response) {
                ArrayList<Pegawai> arrayList = (ArrayList<Pegawai>) response.body();
                AdapterPegawai adapterPegawai = new AdapterPegawai(arrayList);
                rv_pegawai.setAdapter(adapterPegawai);
            }

            @Override
            public void onFailure(Call<List<Pegawai>> call, Throwable t) {

            }
        });
    }
}