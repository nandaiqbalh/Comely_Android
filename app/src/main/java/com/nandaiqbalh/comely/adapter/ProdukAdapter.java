package com.nandaiqbalh.comely.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.model.Produk;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.myViewHolder> {

    ArrayList<Produk> dataHolder;

    // constructor
    public ProdukAdapter(ArrayList<Produk> dataHolder){
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
        holder.gambarProduk.setImageResource(dataHolder.get(position).getGambarProduk());
        holder.namaProduk.setText(dataHolder.get(position).getNamaProduk());
        holder.hargaProduk.setText(dataHolder.get(position).getHargaProduk());
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
