package com.nandaiqbalh.comely.activity.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nandaiqbalh.comely.MainActivity;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.activity.LoginActivity;
import com.nandaiqbalh.comely.helper.SharedPrefs;
import com.nandaiqbalh.comely.model.user.User;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout btnBackFromProfile;

    Button btnChangeProfile;

    SharedPrefs s;

    TextView tvName, tvUsername, tvEmail, tvPhone, tvGender, tvBirthday;

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

        // setTextValue
        aturValueText();

    }

    private void inisiasiVariabel(){
        btnBackFromProfile = (LinearLayout) findViewById(R.id.btn_back_from_profile);

        btnChangeProfile = (Button) findViewById(R.id.btn_change_profile);

        // shared prefs
        s = new SharedPrefs(ProfileActivity.this);
        // text view
        tvName = (TextView) findViewById(R.id.tv_nama);
        tvUsername = (TextView) findViewById(R.id.tv_username);
        tvEmail = (TextView) findViewById(R.id.tv_email_profile);
        tvPhone = (TextView) findViewById(R.id.tv_phone_profile);
        tvGender = (TextView) findViewById(R.id.tv_gender);
        tvBirthday = (TextView) findViewById(R.id.tv_birthday);
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

        btnChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, ChangeProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void aturValueText(){

        if (s.getUser() == null){
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return;
        }

        User user = s.getUser();

        tvName.setText(user.getName());
        tvPhone.setText(user.getPhone());
        tvEmail.setText(user.getEmail());

        if (user.getUsername() == null){
            tvUsername.setText("Not set.");
        } else {
            tvUsername.setText(user.getUsername());
        }

        if (user.getGender() == null){
            tvGender.setText("Not set.");
        } else {
            tvGender.setText(user.getGender());
        }

        if (user.getBirthday() == null){
            tvBirthday.setText("Not set.");
        } else {
            tvBirthday.setText(user.getBirthday());
        }
    }
}