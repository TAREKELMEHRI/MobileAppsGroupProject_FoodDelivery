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

    public void createRestuarantListings(){
        List<RestuarantListing> restuarntList = new ArrayList<RestuarantListing>();

        RestuarantListing restuarantListing = new RestuarantListing();
        restuarantListing.setRestuarantName("&Pizza");
        restuarantListing.setAddress("1234 Street st");
        restuarantListing.setPicLink(null);

        restuarntList.add(restuarantListing);

        LinearLayout l = (LinearLayout) findViewById(R.id.linearLayout);

        for(RestuarantListing s : restuarntList){
            Button newButton = new Button(this);
            newButton.setText(s.getRestuarantName());
            newButton.setBackgroundColor(0xFF99D6D6);
            l.addView(newButton);
        }


    }

}