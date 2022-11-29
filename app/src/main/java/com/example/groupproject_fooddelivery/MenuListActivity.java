package com.example.groupproject_fooddelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class MenuListActivity extends Activity {

    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_item_list);

        listView2 = findViewById(R.id.menuListView);

        ArrayList<MenuItem> arrayList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            if (bundle.getString("ChosenRestaurant") == "com.example.groupproject_fooddelivery.Restaurant@5f6203d"){

                arrayList.add(new MenuItem(R.drawable._pizza_home, 13.99, "American Honey"));
                arrayList.add(new MenuItem(R.drawable._pizza_home, 13.99, "Maverick"));
                arrayList.add(new MenuItem(R.drawable._pizza_home, 13.99, "Simp"));

            }else{

                arrayList.add(new MenuItem(R.drawable.tajofindia_home, 18.95, "Chicken Tikka Masala"));
                arrayList.add(new MenuItem(R.drawable.tajofindia_home, 18.95, "Taj Karai"));
                arrayList.add(new MenuItem(R.drawable.tajofindia_home, 14.95, "Bengan Bhartha"));

                arrayList.add(new MenuItem(R.drawable.dukesgrocery_home, 16.50, "Proper Burger"));
                arrayList.add(new MenuItem(R.drawable.dukesgrocery_home, 15.50, "Truffle Mac & Cheese"));
                arrayList.add(new MenuItem(R.drawable.dukesgrocery_home, 16.50, "Fired Up Chicken"));

            }
        }




        MenuListAdapter menuListAdapter = new MenuListAdapter(this, R.layout.menu_item_template, arrayList);

        listView2.setAdapter(menuListAdapter);

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
