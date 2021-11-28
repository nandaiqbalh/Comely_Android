package com.nandaiqbalh.comely.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.nandaiqbalh.comely.R;

public class RegisterActivity extends AppCompatActivity {

    // TODO: DEKLARASI MEMBER VARIABEL
    TextView tv_sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // TODO: INISIASI VARIABEL
        tv_sign_in = (TextView) findViewById(R.id.tv_sign_in);

        // function button
        mainButton();
    }

    private void mainButton(){
        tv_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}