package com.example.proa12senin06476;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper dbh;

    EditText nim, nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbh = new DatabaseHelper(this);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
    }
    public void SaveMhs(View view) {
        dbh.saveData(nim.getText().toString(), nama.getText().toString());
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
    public void Cancel(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }


}