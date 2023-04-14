package com.example.warship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.warship.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final ArrayList<Warship> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvWarship.setHasFixedSize(true);
        list.clear();

        convertStringValueToListWarship();

        // Mengatur layout grid/linear pada RecyclerView dalam Vertical/Landscape
        if (getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvWarship.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            binding.rvWarship.setLayoutManager(new LinearLayoutManager(this));
        }

        // Inisialisasi adapter untuk RecyclerView
        WarshipRVAdapter warshipRVAdapter = new WarshipRVAdapter(list);

        // Menyambungkan adapter diatas ke RecyclerView pada XML.
        binding.rvWarship.setAdapter(warshipRVAdapter);

        // onClick pindah ke DetailWarship, dengan membawa value: Warship
        warshipRVAdapter.setOnItemClickCallback( value -> {
            Intent intentDetail = new Intent(MainActivity.this, DetailWarship.class);
            intentDetail.putExtra("key_warship", value);
            startActivity(intentDetail);
        });
    }

    private void convertStringValueToListWarship() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataType = getResources().getStringArray(R.array.data_type);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataImgUrl = getResources().getStringArray(R.array.data_img_url);
        int[] dataPrice = getResources().getIntArray(R.array.data_price);

        for (int i = 0; i < dataName.length; i++) {
            Warship warship = new Warship();

            warship.setName(dataName[i]);
            warship.setType(dataType[i]);
            warship.setDescription(dataDescription[i]);
            warship.setImgUrl(dataImgUrl[i]);
            warship.setPrice((int) dataPrice[i]);

            list.add(warship);
        }

    }

}