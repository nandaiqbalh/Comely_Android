package com.nandaiqbalh.comely;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nandaiqbalh.comely.activity.LoginActivity;
import com.nandaiqbalh.comely.fragment.AkunFragment;
import com.nandaiqbalh.comely.fragment.HomeFragment;
import com.nandaiqbalh.comely.fragment.KeranjangFragment;
import com.nandaiqbalh.comely.helper.SharedPrefs;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    // STATUS LOGIN
    private boolean statusLogin = false;

    // Shared prefs
    SharedPrefs s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // default fragment
        Fragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        // bottom navigation view
        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // shared preferences
        s = new SharedPrefs(this);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_beranda:
                            selectedFragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                            break;
                        case R.id.nav_keranjang:
                            selectedFragment = new KeranjangFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                            break;
                        case R.id.nav_akun:
                            if (s.getStatusLogin()){
                                selectedFragment = new AkunFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                            } else {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                finish();
                                startActivity(intent);
                            }
                            break;
                        default:
                            return Boolean.parseBoolean(null);
                    }

                    return true;
                }
            };

}