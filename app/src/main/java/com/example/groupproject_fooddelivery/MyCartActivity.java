package com.example.groupproject_fooddelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCartActivity extends Activity {
    public TextView menuItemHomeName, menuItemHomePrice, addToCart;
    public ImageView menuItemImage;
    public FoodDomain object;
    public RecyclerView ordersListView;
    public RecyclerView.Adapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        getBundle();
    }

    public void goHome(View view){
        Intent intent=new Intent(MyCartActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void checkout(View view){
        Intent intent=new Intent(MyCartActivity.this, OrderCheckoutActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }


    private String setOrderVars(){
        double totalCost = 0.00;
        SingleToneClass singleToneClass = com.example.groupproject_fooddelivery.SingleToneClass.getInstance();
        List<FoodDomain> orders = singleToneClass.getData();

        for (FoodDomain item: orders){
            if (item.getNumberInCart() != 0){
                totalCost = totalCost + (item.getNumberInCart() * item.getFoodPrice());
            }
        }
        return String.valueOf(totalCost);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, foodPrice, quantity, value;
        ImageView foodPic;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName=itemView.findViewById(R.id.selectedItemHomeName);
            foodPic=itemView.findViewById(R.id.selectedItemImage);
            quantity = itemView.findViewById(R.id.selectedItemQuantity);
            foodPrice=itemView.findViewById(R.id.selectedItemPrice);
            value=itemView.findViewById(R.id.orderTotalValue);
        }

    }
    public void getBundle() {
//        object= (FoodDomain) getIntent().getSerializableExtra("object");
//
//        int drawableResourceId=this.getResources().getIdentifier(object.getFoodPic(),"drawable", this.getPackageName());
//        Glide.with(this)
//                .load(drawableResourceId)
//                .into(menuItemImage);
//
//        menuItemHomeName.setText(object.getFoodName());
//        menuItemHomePrice.setText(String.valueOf(object.getFoodPrice()));
//        addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SingleToneClass singleToneClass = com.example.groupproject_fooddelivery.SingleToneClass.getInstance();
//                List<FoodDomain> orders = singleToneClass.getData();
//                orders.add(object);
//                singleToneClass.setData(orders);
//            }
//        });

        SingleToneClass singleToneClass = com.example.groupproject_fooddelivery.SingleToneClass.getInstance();
        List<FoodDomain> orders = singleToneClass.getData();
        ArrayList<FoodDomain> ordersList =new ArrayList<>();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ordersListView=findViewById(R.id.ordersListView);
        ordersListView.setLayoutManager(linearLayoutManager);

        for (FoodDomain item: orders){
            ordersList.add(item);
        }

        String totalCost = setOrderVars();
        TextView textView = findViewById(R.id.orderTotalValue);
        textView.setText(totalCost);

        adapter2=new MyCartAdapter(ordersList);
        ordersListView.setAdapter(adapter2);

    }

}
