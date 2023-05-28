package com.example.proa12senin06476;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    ListView listMahasiswa;

    ArrayList listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DatabaseHelper(this);
        listMahasiswa = findViewById(R.id.listMahasiswa);
        listItem = new ArrayList<>();

        Cursor cursor = dbh.ReadData();
        listItem.clear();

        while (cursor.moveToNext()){
            listItem.add(cursor.getString(0) + " " + cursor.getString(1));
        }
        adapter = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listItem);
        listMahasiswa.setAdapter(adapter);
    }

    public void InputMahasiswa(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}