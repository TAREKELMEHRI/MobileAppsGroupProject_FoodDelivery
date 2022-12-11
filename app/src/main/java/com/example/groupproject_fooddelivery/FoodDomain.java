package com.example.groupproject_fooddelivery;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    public String foodName;
    public Double foodPrice;
    public String foodPic;
    public int numberInCart;

    public FoodDomain(String foodName, Double foodPrice, String foodPic ) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodPic = foodPic;

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

}
