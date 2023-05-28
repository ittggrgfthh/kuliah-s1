package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editCode, editName, editUnit, editPrice;
    Button saveButton;
    ModelBarang modelBarang;
    DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find id
        editCode = findViewById(R.id.itemCode);
        editName = findViewById(R.id.itemName);
        editUnit = findViewById(R.id.itemUnit);
        editPrice = findViewById(R.id.itemPrice);
        saveButton = findViewById(R.id.saveButton);

        modelBarang = new ModelBarang();

        //firebase
        databaseRef = FirebaseDatabase.getInstance().getReference().child("barang");

        //when save button clicked
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelBarang.setItemCode(editCode.getText().toString());
                modelBarang.setItemName(editName.getText().toString());
                modelBarang.setItemUnit(editUnit.getText().toString());
                modelBarang.setItemPrice(Integer.parseInt(editPrice.getText().toString()));

                databaseRef.push().setValue(modelBarang);
            }
        });
    }
}