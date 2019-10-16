package com.example.doanshop;

import java.util.List;


public class Product {
    String price;
    String quantity;
    int pictureId;
    private List<Product> products;

    public Product(String quantity, int pictureId) {

        this.quantity = quantity;
        this.pictureId = pictureId;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public int getpictureId() {
        return pictureId;
    }

    public void setpictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

