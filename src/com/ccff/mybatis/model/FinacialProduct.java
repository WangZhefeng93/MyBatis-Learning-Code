package com.ccff.mybatis.model;

import java.util.Date;
import java.util.Set;

public class FinacialProduct {
    private int product_id;
    private String name;
    private float price;
    private String detail;
    private String pic;
    private Date invasttime;
    private Set<Batch> batches;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getInvasttime() {
        return invasttime;
    }

    public void setInvasttime(Date invasttime) {
        this.invasttime = invasttime;
    }

    public Set<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
    }

    @Override
    public String toString() {
        return "FinacialProduct{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", invasttime=" + invasttime +
                ", batches=" + batches +
                '}';
    }
}
