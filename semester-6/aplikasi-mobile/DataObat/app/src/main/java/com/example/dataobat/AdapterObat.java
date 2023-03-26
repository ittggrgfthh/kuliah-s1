package com.example.dataobat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterObat extends RecyclerView.Adapter<AdapterObat.myviewholder> {
    ArrayList<ModelObat> obatArrayList;
    Context context;

    public AdapterObat(ArrayList<ModelObat> obatArrayList, Context context) {
        this.obatArrayList = obatArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterObat.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.format_obat, parent, false);
        return new AdapterObat.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterObat.myviewholder holder, int position) {
        ModelObat obat = obatArrayList.get(position);
        holder.cKode.setText(obat.getFieldKode());
        holder.cNama.setText(obat.getFieldNama());
        holder.cJumlah.setText(obat.getFieldJumlah());
        holder.cSatuan.setText(obat.getFieldSatuan());
        holder.cHarga.setText(obat.getFieldHarga());
    }

    @Override
    public int getItemCount() {
        return obatArrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView cKode, cNama, cJumlah, cSatuan, cHarga;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            cKode = itemView.findViewById(R.id.kode);
            cNama = itemView.findViewById(R.id.nama);
            cJumlah = itemView.findViewById(R.id.jumlah);
            cSatuan = itemView.findViewById(R.id.satuan);
            cHarga = itemView.findViewById(R.id.harga);
        }
    }
}
