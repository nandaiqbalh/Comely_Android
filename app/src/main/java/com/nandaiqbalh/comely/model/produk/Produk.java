package com.nandaiqbalh.comely.model.produk;

import java.io.Serializable;

public class Produk implements Serializable {
    private int id;
    private int category_id;
    private int brand_id;
    private String product_name_eng;
    private String product_code;
    private String product_quantity;
    private String selling_prize;
    private String discount_prize;
    private String product_tag_eng;
    private String product_size_eng;
    private String product_color_eng;
    private String product_thumbnail;
    private String short_desc_eng;
    private String long_desc_eng;
    private int hot_deal;
    private int featured;
    private int special_offer;
    private int status;
    private String created_at;
    private String updated_at;

    // constructor


    public Produk(String product_name_eng, String selling_prize, String product_thumbnail) {
        this.product_name_eng = product_name_eng;
        this.selling_prize = selling_prize;
        this.product_thumbnail = product_thumbnail;
    }

    // constructor
    public Produk() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getProduct_name_eng() {
        return product_name_eng;
    }

    public void setProduct_name_eng(String product_name_eng) {
        this.product_name_eng = product_name_eng;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getSelling_prize() {
        return selling_prize;
    }

    public void setSelling_prize(String selling_prize) {
        this.selling_prize = selling_prize;
    }

    public String getDiscount_prize() {
        return discount_prize;
    }

    public void setDiscount_prize(String discount_prize) {
        this.discount_prize = discount_prize;
    }

    public String getProduct_tag_eng() {
        return product_tag_eng;
    }

    public void setProduct_tag_eng(String product_tag_eng) {
        this.product_tag_eng = product_tag_eng;
    }

    public String getProduct_size_eng() {
        return product_size_eng;
    }

    public void setProduct_size_eng(String product_size_eng) {
        this.product_size_eng = product_size_eng;
    }

    public String getProduct_color_eng() {
        return product_color_eng;
    }

    public void setProduct_color_eng(String product_color_eng) {
        this.product_color_eng = product_color_eng;
    }

    public String getProduct_thumbnail() {
        return product_thumbnail;
    }

    public void setProduct_thumbnail(String product_thumbnail) {
        this.product_thumbnail = product_thumbnail;
    }

    public String getShort_desc_eng() {
        return short_desc_eng;
    }

    public void setShort_desc_eng(String short_desc_eng) {
        this.short_desc_eng = short_desc_eng;
    }

    public String getLong_desc_eng() {
        return long_desc_eng;
    }

    public void setLong_desc_eng(String long_desc_eng) {
        this.long_desc_eng = long_desc_eng;
    }

    public int getHot_deal() {
        return hot_deal;
    }

    public void setHot_deal(int hot_deal) {
        this.hot_deal = hot_deal;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public int getSpecial_offer() {
        return special_offer;
    }

    public void setSpecial_offer(int special_offer) {
        this.special_offer = special_offer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}

