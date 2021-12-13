package com.nandaiqbalh.comely.activity.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.nandaiqbalh.comely.MainActivity;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.activity.LoginActivity;
import com.nandaiqbalh.comely.adapter.CustomSpinnerAdapter;
import com.nandaiqbalh.comely.helper.CustomItemSpinner;
import com.nandaiqbalh.comely.helper.SharedPrefs;
import com.nandaiqbalh.comely.model.user.User;

import java.util.ArrayList;
import java.util.Calendar;

public class ChangeProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Spinner
    Spinner customSpinner;
    ArrayList<CustomItemSpinner> customList;
    int width = 200;

    // Date
    EditText edt_Date;
    DatePickerDialog.OnDateSetListener dateSetListener;

    // Button
    LinearLayout btnBackFromUpdate;

    // Form
    EditText edtName, edtUsername, edtPhone;

    SharedPrefs s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inisialisasiVariabel();
        customSpinner();

        customDate();

        // mainButton
        mainButton();

        // atur default value form
        aturValueForm();
    }

    private void inisialisasiVariabel(){

        customSpinner = (Spinner) findViewById(R.id.spinner_gender);
        edt_Date = (EditText) findViewById(R.id.edt_birthday_update);
        // Lanjutan form
        edtName = (EditText) findViewById(R.id.edt_name_update);
        edtUsername = (EditText) findViewById(R.id.edt_username_update);
        edtPhone = (EditText) findViewById(R.id.edt_phone_update);

        btnBackFromUpdate = (LinearLayout) findViewById(R.id.btn_back_from_profile);

        // shared prefs
        s = new SharedPrefs(ChangeProfileActivity.this);
    }

    private void mainButton(){
        // back
        btnBackFromUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void aturValueForm(){
        if (s.getUser() == null){
            Intent intent = new Intent(ChangeProfileActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return;
        }

        User user = s.getUser();

        edtName.setText(user.getName());
        edtPhone.setText(user.getPhone());

        if (user.getUsername() == null){
            edtUsername.setText("Not set.");
        } else {
            edtUsername.setText(user.getUsername());
        }


        if (user.getGender() == null){
            customSpinner.setSelection(0);
        } else if (user.getGender().equalsIgnoreCase("Female")){
            customSpinner.setSelection(1);
        }

        if (user.getBirthday() == null){
            edt_Date.setText("Not set.");
        } else {
            edt_Date.setText(user.getBirthday());
        }
    }

    private void customSpinner(){
        
        customList = getCustomList();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, customList);
        if (customSpinner != null) {
            customSpinner.setAdapter(customSpinnerAdapter);
            customSpinner.setOnItemSelectedListener(this);
        }
    }

    private void customDate(){

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        edt_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ChangeProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month +1;
                        String date = day + " - " + month + " - " + year;
                        edt_Date.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }

    private ArrayList<CustomItemSpinner> getCustomList() {

        customList = new ArrayList<>();
        customList.add(new CustomItemSpinner("Male", R.drawable.ic_male_gender));
        customList.add(new CustomItemSpinner("Female", R.drawable.ic_female_gender));

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