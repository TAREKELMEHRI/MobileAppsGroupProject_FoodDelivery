package com.example.groupproject_fooddelivery;

public class RestuarantListing {

    public String getRestuarantName() {
        return restuarantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restuarantName = restuarantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    private String restuarantName;
    private String address;
    private String picLink;
}
