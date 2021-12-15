package com.nandaiqbalh.comely.model.brand;

public class Brand {

    private int id;
    private String brand_name_eng;
    private String brand_name_ina;
    private String brand_image;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_name_eng() {
        return brand_name_eng;
    }

    public void setBrand_name_eng(String brand_name_eng) {
        this.brand_name_eng = brand_name_eng;
    }

    public String getBrand_name_ina() {
        return brand_name_ina;
    }

    public void setBrand_name_ina(String brand_name_ina) {
        this.brand_name_ina = brand_name_ina;
    }

    public String getBrand_image() {
        return brand_image;
    }

    public void setBrand_image(String brand_image) {
        this.brand_image = brand_image;
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
