package com.nandaiqbalh.comely.model.produk;

import java.io.Serializable;

public class Produk implements Serializable {
    private String namaProduk;
    private String hargaProduk;
    private int gambarProduk = 0;

    // constructor
    public Produk (String namaProduk, String hargaProduk, int gambarProduk){
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.gambarProduk = gambarProduk;
    }

    // setter and getter
    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public int getGambarProduk() {
        return gambarProduk;
    }

    public void setGambarProduk(int gambarProduk) {
        this.gambarProduk = gambarProduk;
    }
}
