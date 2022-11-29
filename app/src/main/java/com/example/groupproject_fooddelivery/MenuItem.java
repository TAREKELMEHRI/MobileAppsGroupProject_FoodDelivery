package com.example.groupproject_fooddelivery;

public class MenuItem {

    int MenuImage;
    double MenuPrice;
    String MenuItemName;

    public MenuItem(int menuImage, double menuPrice, String menuItemName) {
        MenuImage = menuImage;
        MenuPrice = menuPrice;
        MenuItemName = menuItemName;
    }

    public int getMenuImage() {
        return MenuImage;
    }

    public void setMenuImage(int menuImage) {
        MenuImage = menuImage;
    }

    public String getMenuPrice() {
        String MenuPriceString = Double.toString(MenuPrice);
        return MenuPriceString;
    }

    public void setMenuPrice(double menuPrice) {
        MenuPrice = menuPrice;
    }

    public String getMenuItemName() {
        return MenuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        MenuItemName = menuItemName;
    }


}
