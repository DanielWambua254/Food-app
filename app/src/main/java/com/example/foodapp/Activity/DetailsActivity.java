package com.example.foodapp.Activity;


import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.ManagmentCart;
import com.example.foodapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends BaseActivity {
    ActivityDetailsBinding binding;
    private Foods object;
    private int num = 1;

    private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        binding.backDetailsButton.setOnClickListener(v -> finish());

        managmentCart = new ManagmentCart(this);

        Glide.with(DetailsActivity.this)
                .load(object.getImagePath())
                .transform(new CenterCrop())
                .into(binding.detailsImageView);

        binding.detailsPriceTv.setText("$" + object.getPrice());
        binding.detailsTitleTv.setText(object.getTitle());
        binding.detailsTime.setText("" + object.getTimeValue());
        binding.detailsDescriptionTv.setText(object.getDescription());
        binding.ratingTv.setText(object.getStar() + " rating.");
        binding.ratingBar.setRating(object.getStar());
        binding.detailsTotalPticeTv.setText("$" + (num * object.getPrice()));

        binding.detailsAddBtn.setOnClickListener(v -> {
            num = num + 1;
            binding.detailNumTv.setText(num + "");
            binding.detailsTotalPticeTv.setText(  "$" + (num * object.getPrice()));

        });

        binding.detailsMinusBtn.setOnClickListener(v -> {
            if (num > 1) {
                num = num - 1;
                binding.detailNumTv.setText(num + "");
                binding.detailsTotalPticeTv.setText(  "$" + (num * object.getPrice()));
            }
        });

        binding.addToCartBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);
        });
    }

    private void getIntentExtra() {
        object = (Foods) getIntent().getSerializableExtra("object");
    }
}