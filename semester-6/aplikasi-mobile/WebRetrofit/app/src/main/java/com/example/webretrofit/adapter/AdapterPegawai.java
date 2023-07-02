package com.example.webretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webretrofit.R;
import com.example.webretrofit.model.Pegawai;

import java.util.ArrayList;

public class AdapterPegawai extends RecyclerView.Adapter<AdapterPegawai.viewHolder> {
    ArrayList<Pegawai> pegawaiArrayList;

    public AdapterPegawai(ArrayList<Pegawai> pegawaiArrayList) {
        this.pegawaiArrayList = pegawaiArrayList;
    }

    @NonNull
    @Override
    public AdapterPegawai.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.format_rv, parent, false);
        return new AdapterPegawai.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPegawai.viewHolder holder, int position) {
        holder.code.setText(pegawaiArrayList.get(position).getKode());
        holder.name.setText(pegawaiArrayList.get(position).getNama());
        holder.position.setText(pegawaiArrayList.get(position).getJabatan());
        holder.salary.setText(String.valueOf(pegawaiArrayList.get(position).getGaji()));
    }

    @Override
    public int getItemCount() {
       return pegawaiArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView code, name, position, salary;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            code = itemView.findViewById(R.id.code);
            name = itemView.findViewById(R.id.name);
            position = itemView.findViewById(R.id.position);
            salary = itemView.findViewById(R.id.salary);
        }
    }
}
