package com.example.groupproject_fooddelivery;

import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Stream;

public class RestaurantDomain implements Serializable {

    public String restaurantName;
    public String restaurantPic;

    public RestaurantDomain(String restaurantName, String restaurantPic) {
        this.restaurantName = restaurantName;
        this.restaurantPic = restaurantPic;

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantPic() {
        return restaurantPic;
    }

    public void setRestaurantPic(String restaurantPic) {
        this.restaurantPic = restaurantPic;
    }




}
