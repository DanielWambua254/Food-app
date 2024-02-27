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
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Activity.DetailsActivity;
import com.example.foodapp.Activity.FoodListActivity;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;

import java.util.ArrayList;

public class FoodList extends RecyclerView.Adapter<FoodList.viewholder> {
    ArrayList<Foods> items;
    Context context;
    public FoodList(ArrayList<Foods> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public FoodList.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.food_list_item,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodList.viewholder holder, int position) {
        holder.nameTv.setText("" +  items.get(position).getTitle());
        holder.priceTv.setText("$"+items.get(position).getPrice());
        holder.startTv.setText("" + items.get(position).getStar());
        holder.timeTv.setText(items.get(position).getTimeValue() + " min");

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView nameTv, timeTv, startTv, priceTv;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.foodListNameTv);
            timeTv = itemView.findViewById(R.id.foodListTimeTv);
            startTv = itemView.findViewById(R.id.foodListStarTv);
            priceTv = itemView.findViewById(R.id.foodListPriceTv);
            pic = itemView.findViewById(R.id.foodListPic);
        }
    }
}
