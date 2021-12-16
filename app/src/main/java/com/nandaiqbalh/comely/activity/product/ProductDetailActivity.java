package com.nandaiqbalh.comely.activity.product;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.adapter.CustomSpinnerAdapter;
import com.nandaiqbalh.comely.helper.CustomItemSpinner;
import com.nandaiqbalh.comely.model.brand.Brand;
import com.nandaiqbalh.comely.model.produk.Produk;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView ivGambarProduk;
    TextView tvNamaProduk, tvHargaProduk, tvBrand, tvKodeProduk, tvDeskripsiProduk;
    TextView tvSelectSize, tvSelectColor;

    Spinner sizeSpinner;
    ArrayList<CustomItemSpinner> customSizeList;
    int width = 200;

    Spinner colorSpinner;
    ArrayList<CustomItemSpinner> customColorList;

    // intent getExtra
    Gson gson = new Gson();
    Produk produk;
    Brand brand;

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

//        // get all brand
//        getAllBrand();

        customSizeSpinner();

        customColorSpinner();

    }

    private void inisialisasi() {
        ivGambarProduk = (ImageView) findViewById(R.id.iv_gambar_produk);
        tvNamaProduk = (TextView) findViewById(R.id.tv_nama_produk_detail);
        tvHargaProduk = (TextView) findViewById(R.id.tv_harga_produk_detail);
        tvBrand = (TextView) findViewById(R.id.tv_brand_detail);
        tvKodeProduk = (TextView) findViewById(R.id.tv_code_detail);
        tvDeskripsiProduk = (TextView) findViewById(R.id.tv_deskripsi_detail);

        tvSelectSize = (TextView) findViewById(R.id.tv_select_size);
        tvSelectColor = (TextView) findViewById(R.id.tv_select_color);

        // Spinner
        sizeSpinner = (Spinner) findViewById(R.id.spinner_size);
        colorSpinner = (Spinner) findViewById(R.id.spinner_color);

        // toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    private void getInformasiProduk() {

        String dataProduk = getIntent().getStringExtra("extra"); // ambil value dari intent
        produk = gson.fromJson(dataProduk, Produk.class); // cast dari bentuk String ke bentuk Object Produk

        // set value
        if (produk != null) {
            tvNamaProduk.setText(produk.getProduct_name_eng());
            tvHargaProduk.setText(NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(Integer.valueOf(produk.getSelling_prize())));
            tvDeskripsiProduk.setText(produk.getShort_desc_eng());
            tvKodeProduk.setText(produk.getProduct_code());

            // brand name (unsuccess)
            tvBrand.setText("Unregistered Brand");


            // Gambar
            String imageURL = "http://192.168.160.130/udemy/latihan_ecommerce/public/" + produk.getProduct_thumbnail();
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

//    private ArrayList<Brand> brandArrayList = new ArrayList<>();
//    private void getAllBrand(){
//        Call<BrandResponse> brandResponseCall = ApiConfig.getService().brandAll();
//        brandResponseCall.enqueue(new Callback<BrandResponse>() {
//            @Override
//            public void onResponse(Call<BrandResponse> call, Response<BrandResponse> response) {
//                BrandResponse respon = response.body();
//                if (respon.getSuccess() == 1){
//                    brandArrayList = respon.getBrand();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BrandResponse> call, Throwable t) {
//
//            }
//        });
//    }

    private void customSizeSpinner() {

        customSizeList = getCustomSizeList();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, customSizeList);
        if (sizeSpinner != null) {
            sizeSpinner.setAdapter(customSpinnerAdapter);
            sizeSpinner.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<CustomItemSpinner> getCustomSizeList() {

        customSizeList = new ArrayList<>();

        if (produk.getProduct_size_eng() != null) {

            String[] dataSize = produk.getProduct_size_eng().split(",");
            for (int i = 0; i < dataSize.length; i++) {

                customSizeList.add(new CustomItemSpinner(dataSize[i], R.drawable.ic_checklist));
            }

        } else {
            tvSelectSize.setVisibility(View.GONE);
            sizeSpinner.setVisibility(View.GONE);
        }


        return customSizeList;
    }

    private void customColorSpinner() {

        customColorList = getCustomColorList();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, customColorList);
        if (colorSpinner != null) {
            colorSpinner.setAdapter(customSpinnerAdapter);
            colorSpinner.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<CustomItemSpinner> getCustomColorList() {

        customColorList = new ArrayList<>();

        if (produk.getProduct_color_eng() != null){
            String[] dataColor = produk.getProduct_color_eng().split(",");

            for (int i = 0; i < dataColor.length; i++) {

                customColorList.add(new CustomItemSpinner(dataColor[i], R.drawable.ic_checklist));
            }
        } else {
            tvSelectColor.setVisibility(View.GONE);
            colorSpinner.setVisibility(View.GONE);
        }


        return customColorList;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        try {
            LinearLayout linearLayout = findViewById(R.id.layout_custom_spinner);
            width = linearLayout.getWidth();
        } catch (Exception e) {

        }
        sizeSpinner.setDropDownWidth(width);
        colorSpinner.setDropDownWidth(width);

        CustomItemSpinner item = (CustomItemSpinner) adapterView.getSelectedItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}