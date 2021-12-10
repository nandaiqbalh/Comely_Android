package com.nandaiqbalh.comely.activity.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.adapter.CustomSpinnerAdapter;
import com.nandaiqbalh.comely.helper.CustomItemSpinner;

import java.util.ArrayList;

public class ChangeProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner customSpinner;
    ArrayList<CustomItemSpinner> customList;
    int width = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inisialisasiVariabel();
        customSpinner();

    }

    private void inisialisasiVariabel(){
        customSpinner = (Spinner) findViewById(R.id.spinner_gender);
    }

    private void customSpinner(){
        
        customList = getCustomList();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, customList);
        if (customSpinner != null) {
            customSpinner.setAdapter(customSpinnerAdapter);
            customSpinner.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<CustomItemSpinner> getCustomList() {

        customList = new ArrayList<>();
        customList.add(new CustomItemSpinner("Male", R.drawable.ic_calendar));
        customList.add(new CustomItemSpinner("Female", R.drawable.ic_gender));

        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        try {
            LinearLayout linearLayout = findViewById(R.id.layout_custom_spinner);
            width = linearLayout.getWidth();
        } catch (Exception e) {

        }
        customSpinner.setDropDownWidth(width);

        CustomItemSpinner item = (CustomItemSpinner) adapterView.getSelectedItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}