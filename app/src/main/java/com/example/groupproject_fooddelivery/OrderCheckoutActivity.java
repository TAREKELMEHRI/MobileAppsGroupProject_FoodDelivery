package com.example.groupproject_fooddelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class OrderCheckoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_confirmation_page);
        getBundle();
    }

    public void goHome(View view){
        Intent intent=new Intent(OrderCheckoutActivity.this, MainActivity.class);
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

        singleToneClass.setData(new ArrayList<FoodDomain>());
        return String.valueOf(totalCost);
    }

    public void getBundle() {
        String totalCost = setOrderVars();
        TextView textView = findViewById(R.id.paymentAmountTotal);
        textView.setText(totalCost);

    }
}
