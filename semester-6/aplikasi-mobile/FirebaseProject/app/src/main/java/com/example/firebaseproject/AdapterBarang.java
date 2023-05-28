package com.example.firebaseproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ViewHolder> {
    Activity activity;
    ArrayList<ModelBarang> modelBarangArrayList;
    DatabaseReference databaseReference;

    public AdapterBarang(Activity activity, ArrayList<ModelBarang> modelBarangArrayList) {
        this.activity = activity;
        this.modelBarangArrayList = modelBarangArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.format_rv_barang, parent, false);
        return new AdapterBarang.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rvCode.setText(modelBarangArrayList.get(position).getItemCode());
        holder.rvName.setText(modelBarangArrayList.get(position).getItemName());
        holder.rvUnit.setText(modelBarangArrayList.get(position).getItemUnit());
        holder.rvPrice.setText(String.valueOf(modelBarangArrayList.get(position).getItemPrice()));
        holder.rvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        databaseReference = FirebaseDatabase.getInstance().getReference();
                        databaseReference.child("barang")
                                .child(modelBarangArrayList.get(position).getKey())
                                .removeValue()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(activity, "Data berhasil dihapus!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setMessage("Apakah anda yakin menghapus " + modelBarangArrayList.get(position).getItemName() + "?");
            builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelBarangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rvCode, rvName, rvUnit, rvPrice;
        ImageView rvDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rvCode = itemView.findViewById(R.id.rvItemCode);
            rvName = itemView.findViewById(R.id.rvItemName);
            rvUnit = itemView.findViewById(R.id.rvItemUnit);
            rvPrice = itemView.findViewById(R.id.rvItemPrice);
            rvDelete = itemView.findViewById(R.id.deleteButton);
        }
    }
}
