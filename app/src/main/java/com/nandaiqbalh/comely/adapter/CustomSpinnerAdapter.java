package com.nandaiqbalh.comely.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.helper.CustomItemSpinner;

import java.util.ArrayList;
import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter {
    public CustomSpinnerAdapter(@NonNull Context context, ArrayList<CustomItemSpinner> customSpinnerAdapters) {
        super(context, 0, customSpinnerAdapters);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_layout, parent, false);
        }

        CustomItemSpinner item = (CustomItemSpinner) getItem(position);
        ImageView iv_spinner = convertView.findViewById(R.id.iv_spinner);
        TextView tv_spinner = convertView.findViewById(R.id.tv_spinner);

        if (item != null) {
            iv_spinner.setImageResource(item.getSpinnerGenderImage());
            tv_spinner.setText(item.getSpinnerGenderName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dropdown_layout, parent, false);
        }

        CustomItemSpinner item = (CustomItemSpinner) getItem(position);
        ImageView iv_dropdown = convertView.findViewById(R.id.iv_dropdown);
        TextView tv_dropdwon = convertView.findViewById(R.id.tv_dropdown);

        if (item != null) {
            iv_dropdown.setImageResource(item.getSpinnerGenderImage());
            tv_dropdwon.setText(item.getSpinnerGenderName());
        }
        return convertView;

    }
}
