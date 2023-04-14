package com.example.warship;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.warship.databinding.ActivityDetailWarshipBinding;

public class DetailWarship extends AppCompatActivity {
    int counter = 0;
    ActivityDetailWarshipBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailWarshipBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Warship warship = getIntent().getParcelableExtra("key_warship");

        binding.tvName.setText(warship.getName());
        binding.tvPrice.setText(warship.getCurrencyDollar());
        binding.tvDescription.setText(warship.getDescription());
        Glide.with(this).load(warship.getImgUrl()).into(binding.warshipDetailImg);

        checkCounter(counter, warship.getPrice());

        binding.btnMinus.setOnClickListener(v -> {
            counter--;
            checkCounter(counter, warship.getPrice());
        });

        binding.btnPlus.setOnClickListener(v -> {
            counter++;
            checkCounter(counter, warship.getPrice());
        });
    }

    public void checkCounter(int counter, int price){
        if(counter <= 0){
            counter = 0;
            binding.btnMinus.setEnabled(false);
            binding.btnMinus.setBackground(getDrawable(R.drawable.btn_border_disabled));
            binding.btnMinus.setColorFilter(getColor(R.color.grey));
        }else{
            binding.btnMinus.setEnabled(true);
            binding.btnMinus.setBackground(getDrawable(R.drawable.btn_border));
            binding.btnMinus.setColorFilter(getColor(R.color.black));
        }
        binding.tvCount.setText(String.valueOf(counter));
        binding.tvTotalPrice.setText(Warship.convertIntToDollar((price * counter)));
    }
}