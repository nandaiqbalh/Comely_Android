package com.nandaiqbalh.comely.activity.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.helper.SharedPrefs;
import com.nandaiqbalh.comely.model.produk.Produk;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView ivGambarProduk;
    TextView tvNamaProduk, tvHargaProduk, tvBrand, tvKodeProduk, tvDeskripsiProduk;

    // intent getExtra
    Gson gson = new Gson();
    Produk produk;

    // Toolbar
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // inisialisasi variabel
        inisialisasi();

        // get info produk
        getInformasiProduk();

    }

    private void inisialisasi(){
        ivGambarProduk = (ImageView) findViewById(R.id.iv_gambar_produk);
        tvNamaProduk = (TextView) findViewById(R.id.tv_nama_produk_detail);
        tvHargaProduk = (TextView) findViewById(R.id.tv_harga_produk_detail);
        tvBrand = (TextView) findViewById(R.id.tv_brand_detail);
        tvKodeProduk = (TextView) findViewById(R.id.tv_code_detail);
        tvDeskripsiProduk = (TextView) findViewById(R.id.tv_deskripsi_detail);

        // toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void getInformasiProduk(){

        String dataProduk = getIntent().getStringExtra("extra"); // ambil value dari intent
        produk = gson.fromJson(dataProduk, Produk.class); // cast dari bentuk String ke bentuk Object Produk

        // set value
        if (produk != null){
            tvNamaProduk.setText(produk.getProduct_name_eng());
            tvHargaProduk.setText(NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(Integer.valueOf(produk.getSelling_prize())));
            tvDeskripsiProduk.setText(produk.getLong_desc_eng());

            // Gambar
            String imageURL =  "http://192.168.160.130/udemy/latihan_ecommerce/public/" + produk.getProduct_thumbnail();
            Picasso.get()
                    .load(imageURL)
                    .placeholder(R.drawable.iv_logo)
                    .error(R.drawable.iv_logo)
                    .into(ivGambarProduk);

            // set toolbar
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(produk.getProduct_name_eng());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}