package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListBarangPage extends AppCompatActivity {
    RecyclerView recyclerViewBarang;
    DatabaseReference databaseReference;
    ArrayList<ModelBarang> modelBarangArrayList = new ArrayList<>();
    ModelBarang modelBarang;
    FloatingActionButton inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_barang_page);

        recyclerViewBarang = findViewById(R.id.rvBarang);
        inputButton = findViewById(R.id.inputButton);

        //get data from firebase database realtime
        databaseReference = FirebaseDatabase.getInstance().getReference();
        displayBarang();
        recyclerViewBarang.setLayoutManager(new LinearLayoutManager(this));

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListBarangPage.this, MainActivity.class));
            }
        });

    }

    private void displayBarang() {
        databaseReference.child("barang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelBarangArrayList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    modelBarang = dataSnapshot.getValue(ModelBarang.class);
                    modelBarang.setKey(dataSnapshot.getKey());
                    modelBarangArrayList.add(modelBarang);
                }
                AdapterBarang adapterBarang = new AdapterBarang(ListBarangPage.this, modelBarangArrayList);
                recyclerViewBarang.setAdapter(adapterBarang);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}