package com.example.dataobat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;

    RecyclerView recyclerObat;
    ArrayList<ModelObat> obatArrayList = new ArrayList<>();
    AdapterObat adapterObat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh = new DatabaseHelper(this);
        recyclerObat = findViewById(R.id.recyclerViewObat);

        Cursor cursor = dbh.ReadData();

        while (cursor.moveToNext()){
            ModelObat obat = new ModelObat();
            obat.setFieldKode(cursor.getString(0));
            obat.setFieldNama(cursor.getString(1));
            obat.setFieldJumlah(cursor.getString(2));
            obat.setFieldSatuan(cursor.getString(3));
            obat.setFieldHarga(cursor.getString(4));

            obatArrayList.add(obat);
        }

        recyclerObat.setLayoutManager(new LinearLayoutManager(this));
        adapterObat = new AdapterObat(obatArrayList, this);
        recyclerObat.setAdapter(adapterObat);
    }



    public void InputObat(View view) {
        Intent intent = new Intent(MainActivity.this, InputObat.class);
        startActivity(intent);
    }
}