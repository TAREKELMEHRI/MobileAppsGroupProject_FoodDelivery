package com.example.groupproject_fooddelivery;


import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {
    ArrayList<RestaurantDomain>restaurantDomains;

    public RestaurantListAdapter(ArrayList<RestaurantDomain> restaurantDomains) {
        this.restaurantDomains = restaurantDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_template, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RestaurantListAdapter.ViewHolder holder, int position) {
        holder.restaurantName.setText(restaurantDomains.get(position).getRestaurantName());
        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "_pizza_home";
            //   holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.home_icon_svg));
                break;
            }
            case 1: {
                picUrl = "tajofindia_home";
            //    holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.home_icon_svg));
                break;
            }

            case 2: {
                picUrl = "dukesgrocery_home";
            //    holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.home_icon_svg));
                break;
            }

        }
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.restaurantPic);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MenuListActivity.class);
                intent.putExtra("object", restaurantDomains.get(position));

            //    if (restaurantDomains.get(position).getRestaurantName() == "&pizza") {
                    intent.putExtra("object2", "&pizza");
            /*    } else if (restaurantDomains.get(position).getRestaurantName() == "tajofindia") {
                    intent.putExtra("object2", "tajofindia");
                } else {
                    intent.putExtra("object2", "dukesgrocery");
                }   */

                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView restaurantName;
        ImageView restaurantPic;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName=itemView.findViewById(R.id.restaurantHomeName);
            restaurantPic=itemView.findViewById(R.id.restaurantHomeImage);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }

    }

}
