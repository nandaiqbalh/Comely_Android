package com.nandaiqbalh.comely;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nandaiqbalh.comely.fragment.AkunFragment;
import com.nandaiqbalh.comely.fragment.HomeFragment;
import com.nandaiqbalh.comely.fragment.KeranjangFragment;

public class MainActivity extends AppCompatActivity {

    // FRAGMENT
    HomeFragment homeFragment = new HomeFragment();
    KeranjangFragment keranjangFragment = new KeranjangFragment();
    AkunFragment akunFragment = new AkunFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment active = homeFragment;

    BottomNavigationView bottomNavigationView;

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

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_beranda:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_keranjang:
                            selectedFragment = new KeranjangFragment();
                            break;
                        case R.id.nav_akun:
                            selectedFragment = new AkunFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();

                    return true;
                }
            };

}