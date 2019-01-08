package com.ccff.mybatis.model;

import java.util.Date;
import java.util.Set;

public class Batch {
    private int batch_id;
    private String number;
    private Date createtime;
    private String note;
    private Customer customer;
    private Set<FinacialProduct> finacialProducts;

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<FinacialProduct> getFinacialProducts() {
        return finacialProducts;
    }

    public void setFinacialProducts(Set<FinacialProduct> finacialProducts) {
        this.finacialProducts = finacialProducts;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batch_id=" + batch_id +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", customer=" + customer +
                '}';
    }
}
