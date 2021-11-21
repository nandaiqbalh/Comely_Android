package com.nandaiqbalh.comely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.WindowManager;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // menambahkan fragment ke dalam frame layout lewat fragment manager
        fragmentManager.beginTransaction().add(R.id.container, homeFragment).show(homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, keranjangFragment).show(keranjangFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, akunFragment).show(akunFragment).commit();

    }
}