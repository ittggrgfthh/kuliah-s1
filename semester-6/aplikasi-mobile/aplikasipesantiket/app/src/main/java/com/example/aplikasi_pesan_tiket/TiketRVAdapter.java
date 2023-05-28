package com.example.aplikasi_pesan_tiket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TiketRVAdapter extends RecyclerView.Adapter<TiketRVAdapter.TiketRVHolder> {
    private final ArrayList<TiketModel> tiketModelArrayList;

    public TiketRVAdapter(ArrayList<TiketModel> tiketModelArrayList){
        this.tiketModelArrayList =tiketModelArrayList;
    }

    @NonNull
    @Override
    public TiketRVAdapter.TiketRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tiket, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TiketRVAdapter.TiketRVHolder holder, int position) {
        TiketModel tiketModel =tiketModelArrayList.get(position);

        holder.tvName.setText(tiketModel.getName());
        holder.tvPrice.setText(tiketModel.getPrice());
        holder.tvImg.set(tiketModel.getImg());
    }

    @Override
    public int getItemCount() {
        return tiketModelArrayList.size();
    }

    public class TiketRVHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPrice, tvImg, tvTypeList;

        public TiketRVHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tiket_name);
            tvImg = itemView.findViewById(R.id.tiket_img);
            tvPrice = itemView.findViewById(R.id.tiket_price);
        }
    }
}
