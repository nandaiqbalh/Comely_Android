package com.nandaiqbalh.comely.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.helper.SharedPrefs;

public class LoginActivity extends AppCompatActivity {

    SharedPrefs s;
    Button loginButton;

    TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // inisiasi shared prefs
        s = new SharedPrefs(this);

        // inisiasi button
        loginButton = (Button) findViewById(R.id.btn_login);

        // inisiasi textview
        tv_register = (TextView) findViewById(R.id.tv_register);

        mainButton();


    }

    private void mainButton(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setStatusLogin(true);
            }
        });

        // btn register
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}