package com.nandaiqbalh.comely.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nandaiqbalh.comely.MainActivity;
import com.nandaiqbalh.comely.R;

public class SplashScreen extends AppCompatActivity {
    // member variable
    ImageView iv_splash;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Glide (library dari bumptech)
        // meluncurkan
        iv_splash = (ImageView) findViewById(R.id.iv_splash);
        Glide.with(SplashScreen.this)
                .load(R.drawable.iv_splash)
                .into(iv_splash);

        // postDelayed
        // untuk menampilkan tampilan awal dengan delayMilis.. setelah delay terpenuhi
        // maka akan masuk ke intent yang telah dibuat
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}

