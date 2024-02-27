package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Activity.FoodListActivity;
import com.example.foodapp.Domain.Category;
import com.example.foodapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Category> items;
    Context context;

    public CategoryAdapter(ArrayList<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.tittleTv.setText("" + items.get(position).getName());

        switch (position) {
            case 0: {
                holder.pic.setBackgroundResource(R.drawable.cat_0_background);
                break;
            }
            case 1: {
                holder.pic.setBackgroundResource(R.drawable.cat_1_background);
                break;
            }
            case 2: {
                holder.pic.setBackgroundResource(R.drawable.cat_2_background);
                break;
            }
            case 3: {
                holder.pic.setBackgroundResource(R.drawable.cat_3_background);
                break;
            }
            case 4: {
                holder.pic.setBackgroundResource(R.drawable.cat_4_background);
                break;
            }
            case 5: {
                holder.pic.setBackgroundResource(R.drawable.cat_5_background);
                break;
            }
            case 6: {
                holder.pic.setBackgroundResource(R.drawable.cat_6_background);
                break;
            }
            case 7: {
                holder.pic.setBackgroundResource(R.drawable.cat_7_background);
                break;
            }
        }

        int dreawableresourceId = context.getResources().getIdentifier(items.get(position)
                .getImagePath(),"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(dreawableresourceId)
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodListActivity.class);
            intent.putExtra("CategoryId", items.get(position).getId());
            intent.putExtra("categoryName",items.get(position).getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends  RecyclerView.ViewHolder {
        TextView tittleTv;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tittleTv = itemView.findViewById(R.id.categoryNameTv);
            pic = itemView.findViewById(R.id.imgCat);
        }
    }
}
