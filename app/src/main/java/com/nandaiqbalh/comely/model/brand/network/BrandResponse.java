package com.nandaiqbalh.comely.model.brand.network;

import com.nandaiqbalh.comely.model.brand.Brand;
import com.nandaiqbalh.comely.model.produk.Produk;

import java.util.ArrayList;

public class BrandResponse {
    private int success = 0;
    private String message;
    private ArrayList<Brand> brand = new ArrayList<>();

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

    public ArrayList<Brand> getBrand() {
        return brand;
    }

    public void setBrand(ArrayList<Brand> brand) {
        this.brand = brand;
    }
}
