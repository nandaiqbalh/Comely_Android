package com.nandaiqbalh.comely.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.activity.product.ProductDetailActivity;
import com.nandaiqbalh.comely.model.produk.Produk;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.myViewHolder> {

    Activity activity;
    ArrayList<Produk> dataHolder;

    // putString
    Gson gson = new Gson();
    Produk produk;

    // constructor
    public ProdukAdapter(Activity activity, ArrayList<Produk> dataHolder) {
        this.activity = activity;
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produk_home, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.namaProduk.setText(dataHolder.get(position).getProduct_name_eng());
        holder.hargaProduk.setText(NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(Integer.valueOf(dataHolder.get(position).getSelling_prize())));

        if (dataHolder.get(position).getDiscount_prize().equalsIgnoreCase("0")) {
            holder.diskonProduk.setVisibility(View.GONE);
        } else {
            double diskonPrize, sellingPrize, diskonFinal;

            try {
                diskonPrize = Double.parseDouble(dataHolder.get(position).getDiscount_prize());
            } catch (NumberFormatException e) {
                diskonPrize = 0;
            }

            try {
                sellingPrize = Double.parseDouble(dataHolder.get(position).getSelling_prize());
            } catch (NumberFormatException e) {
                sellingPrize = 0;
            }


            diskonFinal = diskonPrize / sellingPrize * 100;
            int angkaSignifikan = 1;
            double tempDiskon = Math.pow(10, angkaSignifikan);
            double diskonTampil = (double) Math.round(diskonFinal*tempDiskon)/tempDiskon;

            holder.diskonProduk.setText(diskonTampil + "%");
        }

        // Gambar
        String imageURL = "http://192.168.160.130/udemy/latihan_ecommerce/public/" + dataHolder.get(position).getProduct_thumbnail();
        Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.iv_logo)
                .error(R.drawable.iv_logo)
                .into(holder.gambarProduk);

        holder.layoutProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ProductDetailActivity.class);

                String stringData = gson.toJson(dataHolder.get(position), Produk.class); // cast data Produk ke dalam string
                intent.putExtra("extra", stringData);
                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView gambarProduk;
        TextView namaProduk, hargaProduk;
        TextView diskonProduk;
        CardView layoutProduct;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarProduk = itemView.findViewById(R.id.img_gambar_produk);
            namaProduk = itemView.findViewById(R.id.tv_nama_produk);
            hargaProduk = itemView.findViewById(R.id.tv_harga_produk);
            diskonProduk = itemView.findViewById(R.id.tv_diskon_produk);

            // layout card view
            layoutProduct = itemView.findViewById(R.id.cv_layout_product);
        }
    }
}
