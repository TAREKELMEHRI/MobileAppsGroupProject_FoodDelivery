package com.example.groupproject_fooddelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantsListActivity extends Activity {

    public RecyclerView.Adapter adapter;
    public RecyclerView recyclerViewRestaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_list);

        recyclerViewRestaurant();

    }

    public void recyclerViewRestaurant() {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewRestaurantList=findViewById(R.id.restaurantListView);
        recyclerViewRestaurantList.setLayoutManager(linearLayoutManager);

        ArrayList<RestaurantDomain> restaurant=new ArrayList<>();
        restaurant.add(new RestaurantDomain("&pizza", "_pizza_home"));
        restaurant.add(new RestaurantDomain("Taj of India", "tajofindia_home"));
        restaurant.add(new RestaurantDomain("Duke's Grocery", "dukesgrocery_home"));

        adapter=new RestaurantListAdapter(restaurant);
        recyclerViewRestaurantList.setAdapter(adapter);

    }

    public void goHome(View view){
        Intent intent=new Intent(RestaurantsListActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goToCart(View view){
        Intent intent=new Intent(RestaurantsListActivity.this, MyCartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

}
