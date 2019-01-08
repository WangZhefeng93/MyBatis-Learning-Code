package com.ccff.mybatis.model;

public class ShoppingCart {
    private int productId;
    private String productName;
    private int number;
    private double price;
    private double totalAmount;

    //无参构造方法
    public ShoppingCart() {
    }

    //有参构造方法
    public ShoppingCart(int productId, String productName, int number, double price, double totalAmount) {
        this.productId = productId;
        this.productName = productName;
        this.number = number;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    //计算购物车中商品的总金额
    public void init(){
        this.totalAmount = this.number * this.price;
    }

    //提供一系列get、set方法
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
