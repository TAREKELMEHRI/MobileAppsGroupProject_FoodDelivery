package com.example.groupproject_fooddelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class SingleMenuItem_AddToCart extends Activity {
    public RelativeLayout clickImageLayout;
    public TextView menuItemHomeName, menuItemHomePrice, addToCart;
    public ImageView menuItemImage;
    public FoodDomain object;
    public Spinner spinnerItemQuantity;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_order_select_item_template);

        initView();
        getBundle();

    }

   public void getBundle() {
        object= (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getFoodPic(),"drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(menuItemImage);

        menuItemHomeName.setText(object.getFoodName());
        menuItemHomePrice.setText(String.valueOf(object.getFoodPrice()));
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SingleToneClass singleToneClass = com.example.groupproject_fooddelivery.SingleToneClass.getInstance();
                List<FoodDomain> orders = singleToneClass.getData();
                orders.add(object);
                singleToneClass.setData(orders);
            }
        });

        }


    public void initView() {
        addToCart = findViewById(R.id.addToCart);
        spinnerItemQuantity = findViewById(R.id.spinnerItemQuantity);
        menuItemHomeName = findViewById(R.id.menuItemHomeName);
        clickImageLayout = findViewById(R.id.clickImageLayout);
        menuItemImage = findViewById(R.id.menuItemImage);
        menuItemHomePrice = findViewById(R.id.menuItemHomePrice);

    }

    public void goHome(View view){
        Intent intent=new Intent(SingleMenuItem_AddToCart.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goToCart(View view){
        Intent intent=new Intent(SingleMenuItem_AddToCart.this, MyCartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void addToCart(View view){
        Intent intent=new Intent(SingleMenuItem_AddToCart.this, MyCartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }


}
