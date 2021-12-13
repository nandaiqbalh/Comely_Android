package com.nandaiqbalh.comely.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.model.produk.Produk;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.myViewHolder> {

    Activity activity;
    ArrayList<Produk> dataHolder;

    // constructor
    public ProdukAdapter(Activity activity, ArrayList<Produk> dataHolder){
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
        // Gambar
        String imageURL = "http://192.168.160.130/udemy/latihan_ecommerce/public/" + dataHolder.get(position).getProduct_thumbnail();
        Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.iv_logo)
                .error(R.drawable.iv_logo)
                .into(holder.gambarProduk);


    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        ImageView gambarProduk;
        TextView namaProduk, hargaProduk;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarProduk = itemView.findViewById(R.id.img_gambar_produk);
            namaProduk = itemView.findViewById(R.id.tv_nama_produk);
            hargaProduk = itemView.findViewById(R.id.tv_harga_produk);
        }
    }
}
