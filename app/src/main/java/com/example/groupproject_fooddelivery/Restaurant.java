package com.example.groupproject_fooddelivery;

public class Restaurant {
    int Image;
    String Des;

    public Restaurant(int image, String des) {
        Image = image;
        Des = des;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

}
