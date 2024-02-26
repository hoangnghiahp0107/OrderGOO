package com.example.appbanthucannhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.appbanthucannhanh.fragment.HomeFragment;
import com.example.appbanthucannhanh.fragment.OrderFragment;
import com.example.appbanthucannhanh.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        if (savedInstanceState == null) {
            // Nếu savedInstanceState rỗng, tức là activity được tạo lần đầu tiên, thì hiển thị HomeFragment
            loadFragment(new HomeFragment());
        }
    }
    private void loadFragment(Fragment fmNew){
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_frame, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
    private void addEvents(){
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                if(item.getItemId()==R.id.bottomHome){
                    fmNew = new HomeFragment();
                    loadFragment(fmNew);
                    return true;
                }
                if (item.getItemId() == R.id.bottomOrder) {
                    fmNew = new OrderFragment();
                    loadFragment(fmNew);
                    return true;
                }

                if(item.getItemId()==R.id.bottomSetting){
                    fmNew = new SettingFragment();
                    loadFragment(fmNew);
                    return true;
                }
                return true;
            }
        });
    }
    private void addControls(){
        bottomNav = findViewById(R.id.bottomNav);
    }
}