package com.example.warship;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.warship.databinding.ItemRowWarshipBinding;

import java.util.ArrayList;

public class WarshipRVAdapter extends RecyclerView.Adapter<WarshipRVAdapter.WarshipRVViewHolder> {
    private final ArrayList<Warship> warshipArrayList;
    private OnItemClickCallback onItemClickCallback;

    public WarshipRVAdapter(ArrayList<Warship> warshipArrayList) {
        this.warshipArrayList = warshipArrayList;
    }

    @NonNull
    @Override
    public WarshipRVAdapter.WarshipRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowWarshipBinding binding = ItemRowWarshipBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WarshipRVViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WarshipRVViewHolder holder, int position) {
        Warship warship = warshipArrayList.get(position);
        Glide.with(holder.itemView.getContext()).load(warship.getImgUrl()).into(holder.binding.imgItemPhoto);
        holder.binding.tvItemName.setText(warship.getName());
        holder.binding.tvItemPrice.setText(String.valueOf(warship.getCurrencyDollar()));

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(warship));
    }

    @Override
    public int getItemCount() {
        return warshipArrayList.size();
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public static class WarshipRVViewHolder extends RecyclerView.ViewHolder{
        ItemRowWarshipBinding binding;
        public WarshipRVViewHolder(@NonNull ItemRowWarshipBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Warship data);
    }
}
