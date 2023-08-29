package com.example.testdatabase;

public class Products {
    private int id;
    private String name;
    private double price;
    private String imgageName;

    public Products(){}

    public Products(int id, String name, double price, String imgageName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgageName = imgageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgageName() {
        return imgageName;
    }

    public void setImgageName(String imgageName) {
        this.imgageName = imgageName;
    }
}
