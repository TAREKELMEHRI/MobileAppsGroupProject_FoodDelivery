package com.example.groupproject_fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void logIn(View view){
        Intent intent=new Intent(MainActivity.this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void signUp(View view){
        Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void guestCheckout(View view){
        Intent intent=new Intent(MainActivity.this, GuestCheckoutActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goHome(View view){
        Intent intent=new Intent(MainActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goToCart(View view){
        Intent intent=new Intent(MainActivity.this, MyCartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goToRestaurants(View view){
        Intent intent=new Intent(MainActivity.this, RestaurantsListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void goToMenu(View view){
        Intent intent=new Intent(MainActivity.this, MenuListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void addToCart(View view){
        SingleToneClass singleToneClass = com.example.groupproject_fooddelivery.SingleToneClass.getInstance();
        List<FoodDomain> orders = singleToneClass.getData();
        Intent intent=new Intent(MainActivity.this, MyCartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }



}