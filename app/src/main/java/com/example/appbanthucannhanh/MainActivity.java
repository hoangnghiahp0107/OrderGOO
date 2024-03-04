package com.example.appbanthucannhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.appbanthucannhanh.fragment.AdminFragment;
import com.example.appbanthucannhanh.fragment.HomeFragment;
import com.example.appbanthucannhanh.fragment.OrderFragment;
import com.example.appbanthucannhanh.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    public String DATABASE_NAME = "database_og";
    public String DB_PATH_SUFFIX="/databases/";
    public static SQLiteDatabase database = null;
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
        processCopy();
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

                if(item.getItemId()==R.id.bottomAdmin){
                    fmNew = new AdminFragment();
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
    public String getDatabasesPath(){
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX;
    }
    private void processCopy(){
        try {
            File file = getDatabasePath(DATABASE_NAME);
            if(!file.exists()){
                copyDatabaseFromAssest();
                Toast.makeText(this,"Copy Database Successful", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(this,"Copy Database Fail", Toast.LENGTH_SHORT).show();
        }
    }
    private void copyDatabaseFromAssest(){
        try {
            InputStream inputFile = getAssets().open(DATABASE_NAME);
            String outputFileName = getDatabasesPath();
            File file = new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!file.exists())
                file.mkdir();
            OutputStream outFile = new FileOutputStream(outputFileName);
            byte []buffer = new byte[1024];
            int length;
            while((length=inputFile.read(buffer))>0) outFile.write(buffer,0,length);
            outFile.flush();
            outFile.close();
            inputFile.close();
        }
        catch (Exception ex){
            Log.e("Error", ex.toString());
        }
    }
}