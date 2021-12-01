package com.nandaiqbalh.comely.activity.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nandaiqbalh.comely.MainActivity;
import com.nandaiqbalh.comely.R;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout btnBackFromProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // method untuk inisiasi
        inisiasiVariabel();

        // method untuk button
        mainButton();

    }

    private void inisiasiVariabel(){
        btnBackFromProfile = (LinearLayout) findViewById(R.id.btn_back_from_profile);
    }

    private void  mainButton(){
        btnBackFromProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}