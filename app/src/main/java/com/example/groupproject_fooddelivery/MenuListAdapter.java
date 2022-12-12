package com.example.groupproject_fooddelivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ViewHolder> {
        ArrayList<FoodDomain>foodDomains;

    public MenuListAdapter(ArrayList<FoodDomain> foodDomains) {
            this.foodDomains = foodDomains;
            }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
            View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_template, parent, false);
            return new ViewHolder(inflate);
            }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MenuListAdapter.ViewHolder holder, int position) {
            holder.foodName.setText(foodDomains.get(position).getFoodName());
            holder.foodPrice.setText(String.format("%.2f", foodDomains.get(position).getFoodPrice()));

            int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getFoodPic(),"drawable",holder.itemView.getContext().getPackageName());

            Glide.with(holder.itemView.getContext())
            .load(drawableResourceId)
            .into(holder.foodPic);

            holder.clickImageLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.itemView.getContext(), SingleMenuItem_AddToCart.class);
                    intent.putExtra("object", foodDomains.get(position));
                    holder.itemView.getContext().startActivity(intent);
                }
        });

            }

    @Override
    public int getItemCount() {
            return foodDomains.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, foodPrice;
        ImageView foodPic;
        RelativeLayout clickImageLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName=itemView.findViewById(R.id.menuItemHomeName);
            foodPic=itemView.findViewById(R.id.menuItemImage);
            clickImageLayout=itemView.findViewById(R.id.clickImageLayout);
            foodPrice=itemView.findViewById(R.id.menuItemHomePrice);
        }

    }

    public void createRestuarantList(){

    }

}