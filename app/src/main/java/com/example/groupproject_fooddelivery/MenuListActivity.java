package com.example.groupproject_fooddelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuListActivity extends Activity {

    public RecyclerView restaurantMenuListView;
    public RecyclerView.Adapter adapter2;

    public TextView updateRestaurantBanner;
    public RestaurantDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_item_list);

        restaurantMenuView();
    }


    public void restaurantMenuView()  {
        object= (RestaurantDomain) getIntent().getSerializableExtra("object");
        String restaurantName = object.getRestaurantName();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        restaurantMenuListView=findViewById(R.id.restaurantMenuListView);
        restaurantMenuListView.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> menulist=new ArrayList<>();
        updateRestaurantBanner=findViewById(R.id.restaurantNameMenuPage);
        updateRestaurantBanner.setText(restaurantName);
        String test2 = "Taj of India";

        if (object.getRestaurantName().contains("&pizza") == true) {
            menulist.add(new FoodDomain("American Honey", 13.99, "_pizza_home"));
            menulist.add(new FoodDomain("Maverick", 13.99, "_pizza_home"));
            menulist.add(new FoodDomain("Simp", 13.99, "_pizza_home"));
        }
        else if (object.getRestaurantName().contains("Taj of India") == true) {
            menulist.add(new FoodDomain("Chicken Tikka Masala", 18.95, "tajofindia_home"));
            menulist.add(new FoodDomain("Taj Karai", 18.95, "tajofindia_home"));
            menulist.add(new FoodDomain("Bengan Bhartha", 14.95, "tajofindia_home"));
        } else {
            menulist.add(new FoodDomain("Proper Burger", 16.50, "dukesgrocery_home"));
            menulist.add(new FoodDomain("Truffle Mac & Cheese", 15.50, "dukesgrocery_home"));
            menulist.add(new FoodDomain("Fired Up Chicken", 16.50, "dukesgrocery_home"));
        }

        adapter2=new MenuListAdapter(menulist);
        restaurantMenuListView.setAdapter(adapter2);

    }



    public void goHome(View view){
        Intent intent=new Intent(MenuListActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goToCart(View view){
        Intent intent=new Intent(MenuListActivity.this, MyCartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }


}
