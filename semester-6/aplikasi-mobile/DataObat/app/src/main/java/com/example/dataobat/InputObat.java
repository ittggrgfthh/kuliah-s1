package com.example.dataobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputObat extends AppCompatActivity {
    DatabaseHelper dbh;
    EditText kode, nama, jumlah, satuan, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_obat);
        dbh = new DatabaseHelper(this);
        kode = findViewById(R.id.kodeObat);
        nama = findViewById(R.id.namaObat);
        jumlah = findViewById(R.id.jumlahObat);
        satuan = findViewById(R.id.satuanObat);
        harga = findViewById(R.id.hargaObat);
    }

    public void SaveMhs(View view) {
        dbh.saveData(kode.getText().toString(), nama.getText().toString(), Integer.parseInt(jumlah.getText().toString()) , satuan.getText().toString(), Integer.parseInt(harga.getText().toString()));
        Intent intent = new Intent(InputObat.this, MainActivity.class);
        startActivity(intent);
    }
    public void Cancel(View view) {
        Intent intent = new Intent(InputObat.this, MainActivity.class);
        startActivity(intent);
    }
}