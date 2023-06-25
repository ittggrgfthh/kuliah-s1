package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateDataBarang extends AppCompatActivity {
    EditText editCode, editName, editUnit, editAmount, editPrice, editExpired, editPackaging, editType;
    Button updateButton;

    DatabaseReference databaseReference;
    ModelBarang modelBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_barang);

        editCode = findViewById(R.id.itemCode);
        editName = findViewById(R.id.itemName);
        editUnit = findViewById(R.id.itemUnit);
        editAmount = findViewById(R.id.itemAmount);
        editPrice = findViewById(R.id.itemPrice);
        editExpired = findViewById(R.id.itemExpired);
        editPackaging = findViewById(R.id.itemPackaging);
        editType = findViewById(R.id.itemType);

        updateButton = findViewById(R.id.updateButton);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        modelBarang = new ModelBarang();

        //menampilkan data barang sesuai dengan kode
        Bundle bundle = getIntent().getExtras();
        editCode.setText(bundle.getString("itemCode"));
        editName.setText(bundle.getString("itemName"));
        editUnit.setText(bundle.getString("itemUnit"));
        editAmount.setText(bundle.getString("itemAmount"));
        editPrice.setText(bundle.getString("itemPrice"));
        editExpired.setText(bundle.getString("itemExpired"));
        editPackaging.setText(bundle.getString("itemPackaging"));
        editType.setText(bundle.getString("itemType"));

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemKey = bundle.getString("itemKey");

                modelBarang.setItemCode(editCode.getText().toString());
                modelBarang.setItemName(editName.getText().toString());
                modelBarang.setItemUnit(editUnit.getText().toString());
                modelBarang.setItemAmount(editAmount.getText().toString());
                modelBarang.setItemPrice(Integer.parseInt(editPrice.getText().toString()));
                modelBarang.setItemExpired(editExpired.getText().toString());
                modelBarang.setItemPackaging(editPackaging.getText().toString());
                modelBarang.setItemType(editType.getText().toString());

                databaseReference.child("barang")
                        .child(itemKey)
                        .setValue(modelBarang)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(UpdateDataBarang.this, bundle.getString("itemCode") + " berhasil diupdate!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}