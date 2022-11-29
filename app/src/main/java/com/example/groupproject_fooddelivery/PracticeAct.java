package com.example.groupproject_fooddelivery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PracticeAct extends Activity {

    TextView txtok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice);

        txtok = (TextView) findViewById(R.id.textViewok);
        Bundle bundle = getIntent().getExtras();
        if (bundle !=null) {

            txtok.setText(bundle.getString("ChosenRestaurant"));
        }
    }


}