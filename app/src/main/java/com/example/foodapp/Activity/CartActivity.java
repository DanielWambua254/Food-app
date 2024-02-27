package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.foodapp.Adapter.CartAdapter;
import com.example.foodapp.Helper.ChangeNumberItemsListener;
import com.example.foodapp.Helper.ManagmentCart;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
    ActivityCartBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentCart;
    private  double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managmentCart = new ManagmentCart(this);
        setVariable();
        calculateCart();
        initializeCart();
    }

    private void initializeCart() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptyCartText.setVisibility(View.VISIBLE);
            binding.cartScrollView.setVisibility(View.GONE);
        } else {
            binding.emptyCartText.setVisibility(View.GONE);
            binding.cartScrollView.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.cartRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        binding.cartRecyclerView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentageTax = 0.02; //percentage 2%
        double delivery = 10; //10dollar
        tax = Math.round(managmentCart.getTotalFee() * percentageTax * 100) / 100;
        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) *100) /100;
        float itemTotal = Math.round(managmentCart.getTotalFee() * 100) /100;

        binding.subTotalTv.setText("$" + itemTotal);
        binding.cartTotalTaxTv.setText("$" + tax);
        binding.deliveryFeeTv.setText("$" + delivery);
        binding.cartTotalTv.setText("$" + total);
    }

    private void setVariable() {
        binding.cartBackBtn.setOnClickListener(v -> finish());

    }
}