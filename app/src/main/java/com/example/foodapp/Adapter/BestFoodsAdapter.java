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
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.ManagmentCart;
import com.example.foodapp.R;

import java.util.ArrayList;

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;
    private Foods object;
    private int num = 1;

    private ManagmentCart managmentCart;

    public BestFoodsAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_best_foods, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.viewholder holder, int position) {
        holder.tittleTv.setText("" + items.get(position).getTitle());
        holder.startTv.setText("" + items.get(position).getStar());
        holder.priceTv.setText("$ " + items.get(position).getPrice());
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

//        holder.addBtn.setOnClickListener(v -> {
//            object = items.get(position);
//            object.setNumberInCart(num);
//            managmentCart.insertFood(object);
//        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends  RecyclerView.ViewHolder {
        TextView tittleTv, startTv, timeTv, priceTv, addBtn;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tittleTv = itemView.findViewById(R.id.tittleTv);
            startTv = itemView.findViewById(R.id.starTv);
            priceTv = itemView.findViewById(R.id.priceTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            addBtn = itemView.findViewById(R.id.bestFoodAddBtn);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
