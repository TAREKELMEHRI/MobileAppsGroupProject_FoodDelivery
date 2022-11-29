package com.example.groupproject_fooddelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class MenuListAdapter extends ArrayAdapter<MenuItem> {

    private Context iContext;
    private int iResource;

    public MenuListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> objects) {
        super(context, resource, objects);
        this.iContext = context;
        this.iResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(iContext);

        convertView = layoutInflater.inflate(iResource, parent,false);

        ImageView imageView = convertView.findViewById(R.id.menuItemImage);

        TextView txtName = convertView.findViewById(R.id.menuItemHomeName);

        TextView txtName2 = convertView.findViewById(R.id.menuItemHomePrice);

        imageView.setImageResource(getItem(position).getMenuImage());

        txtName.setText(getItem(position).getMenuItemName());

        txtName2.setText(getItem(position).getMenuPrice());

        return convertView;

    }


}
