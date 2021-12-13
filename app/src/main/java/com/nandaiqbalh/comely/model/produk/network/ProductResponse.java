package com.nandaiqbalh.comely.model.produk.network;

import com.nandaiqbalh.comely.model.produk.Produk;

import java.util.ArrayList;

public class ProductResponse {

    private int success = 0;
    private String message;
    private ArrayList<Produk> product = new ArrayList<>();

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Produk> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Produk> product) {
        this.product = product;
    }
}
