package com.example;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.activity.DetailKhs;
import com.example.activity.EntryKhs;
import com.example.adapter.KhsRvAdapter;
import com.example.database.DatabaseHelper;
import com.example.database.dao.KhsDao;
import com.example.database.model.Khs;
import com.example.mid06476.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    DatabaseHelper databaseHelper;
    private final ArrayList<Khs> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mengganti setContentView dengan binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Mengubah judul yang ada pada App Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Kartu Hasil Studi");

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        KhsDao khsDao = new KhsDao(database);

        binding.rvKhs.setHasFixedSize(true);
        list.clear();
        list.addAll((Collection<? extends Khs>) khsDao.getAll());
        showRecyclerList();

        binding.addKhs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, EntryKhs.class)));
    }

    private void showRecyclerList() {
        // Mengatur layout linear pada RecyclerView
        binding.rvKhs.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi adapter untuk RecyclerView
        KhsRvAdapter khsRvAdapter = new KhsRvAdapter(list);

        // Menyambungkan adapter diatas ke RecyclerView pada XML.
        binding.rvKhs.setAdapter(khsRvAdapter);

        // onClick pindah ke DetailMedicine, dengan membawa data: Medicine
        khsRvAdapter.setOnItemClickCallback(data -> {
            Intent intentDetail = new Intent(MainActivity.this, DetailKhs.class);
            intentDetail.putExtra("key_khs", data);
            startActivity(intentDetail);
        });
    }

}