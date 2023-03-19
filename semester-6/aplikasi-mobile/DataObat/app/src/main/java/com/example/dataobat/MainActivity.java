package com.example.dataobat;

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
    ListView listObat;

    ArrayList listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DatabaseHelper(this);
        listObat = findViewById(R.id.listObat);
        listItem = new ArrayList<>();

        Cursor cursor = dbh.ReadData();
        listItem.clear();

        while (cursor.moveToNext()){
        listItem.add(cursor.getString(0) + "     " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3) + " " + cursor.getString(4));
        }
        adapter = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listItem);
        listObat.setAdapter(adapter);
    }



    public void InputObat(View view) {
        Intent intent = new Intent(MainActivity.this, InputObat.class);
        startActivity(intent);
    }
}