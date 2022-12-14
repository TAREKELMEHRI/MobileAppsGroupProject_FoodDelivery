package com.example.groupproject_fooddelivery;

import java.util.ArrayList;
import java.util.List;

public class SingleToneClass {
    List<FoodDomain> orders = new ArrayList<FoodDomain>();
    private static final SingleToneClass ourInstance = new SingleToneClass();
    public static SingleToneClass getInstance() {
        return ourInstance;
    }
    private SingleToneClass() {
    }
    public void setData(List<FoodDomain> s) {
        this.orders = s;
    }
    public List<FoodDomain> getData() {
        return orders;
    }
}
