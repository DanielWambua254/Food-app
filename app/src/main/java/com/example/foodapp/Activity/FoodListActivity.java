package com.example.foodapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp.Adapter.FoodList;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityFoodListBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FoodListActivity extends BaseActivity {
    ActivityFoodListBinding binding;
    private RecyclerView.Adapter recyclerFoodList;
    private  int categoryId;
    private String categoryName;
    private String searchText;
    private boolean isSearch;
    private boolean isViewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        initializeList();
    }

    private void initializeList() {
        DatabaseReference myRef = database.getReference("Foods");
        binding.errorMsg.setVisibility(View.GONE);
        binding.foodListProgressBar.setVisibility(View.VISIBLE);
        ArrayList<Foods> list = new  ArrayList<>();

        Query query;
        if (isSearch) {
            query = myRef.orderByChild("Title").startAt(searchText).endAt(searchText+"\uf8ff");
        } else if (isViewAll) {
            query = myRef.orderByChild("BestFood").equalTo(true);
        } else {
            query = myRef.orderByChild("CategoryId").equalTo(categoryId);
        }

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue: snapshot.getChildren()) {
                        list.add(issue.getValue(Foods.class));
                    }
                    if (list.size() > 0) {
                        binding.foodListView.setLayoutManager(new GridLayoutManager(FoodListActivity.this, 2));
                        recyclerFoodList = new  FoodList(list);
                        binding.foodListView.setAdapter(recyclerFoodList);
                    }
                    binding.foodListProgressBar.setVisibility(View.GONE);

                } else {
                    binding.foodListProgressBar.setVisibility(View.GONE);
                    binding.errorMsg.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIntentExtra() {
        categoryId = getIntent().getIntExtra("CategoryId",0);
        categoryName = getIntent().getStringExtra("categoryName");
        searchText = getIntent().getStringExtra("text");
        isSearch = getIntent().getBooleanExtra("isSearch", false);
        isViewAll = getIntent().getBooleanExtra("isViewAll", false);

        if (isSearch) {
            binding.listTittleTv.setText(searchText);
        } else if (isViewAll) {
            binding.listTittleTv.setText("Today's best foods");
        } else {
            binding.listTittleTv.setText(categoryName);
        }

        binding.backBtn.setOnClickListener(v -> finish());

    }
}