package com.example.appbanthucannhanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appbanthucannhanh.adapter.FoodAdapter;
import com.example.appbanthucannhanh.model.Food;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    RecyclerView recyclerFood, recyclerOnePerson;
    FoodAdapter foodAdapter;
    ArrayList<Food> arr_Food, arr_OnePerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        addControls();
        loadData();
    }
    private void loadData(){
        arr_Food.add(new Food("1 Gà Xốt Cua", 41, "1 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_Food.add(new Food("2 Gà Xốt Cua", 79, "2 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_Food.add(new Food("3 Gà Xốt Cua", 117, "3 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_Food.add(new Food("6 Gà Xốt Cua", 231, "1 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_Food.add(new Food("Combo Gà Xốt Cua A", 93, "1 Miếng Gà Xốt Cua + 1 Burger (bất kỳ) + 1 Pepsi Lon",R.drawable.gaxotchua));
        arr_Food.add(new Food("Combo Gà Xốt Cua B", 141, "2 Miếng Gà Xốt Cua + 1 Gà Viên Popcorn (vừa) + 2 Pepsi Lon",R.drawable.gaxotchua));
        arr_Food.add(new Food("Combo Gà Xốt Cua C", 199,"3 Miếng Gà Xốt Cua + 1 Miếng Gà(bất kỳ) + 3 Gà Miếng Nuggets + 2 Pepsi Lon", R.drawable.gaxotchua));

        arr_OnePerson.add(new Food("Combo Gà Rán 1", 59, "1 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_OnePerson.add(new Food("Combo Gà Rán 2", 79, "2 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_OnePerson.add(new Food("Combo Gà Quay", 117, "3 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_OnePerson.add(new Food("Combo Burger Tôm", 231, "1 Miếng Gà Xốt Cua",R.drawable.gaxotchua));
        arr_OnePerson.add(new Food("Combo Burger Zinger", 93, "1 Miếng Gà Xốt Cua + 1 Burger (bất kỳ) + 1 Pepsi Lon",R.drawable.gaxotchua));
        arr_OnePerson.add(new Food("Combo Mì Ý Gà Viên", 141, "2 Miếng Gà Xốt Cua + 1 Gà Viên Popcorn (vừa) + 2 Pepsi Lon",R.drawable.gaxotchua));
        arr_OnePerson.add(new Food("Combo Mì Ý Gà Zinger", 199,"3 Miếng Gà Xốt Cua + 1 Miếng Gà(bất kỳ) + 3 Gà Miếng Nuggets + 2 Pepsi Lon", R.drawable.gaxotchua));
    }
    private void addControls(){
        recyclerFood = findViewById(R.id.recyclerFood);
        arr_Food = new ArrayList<>();
        foodAdapter = new FoodAdapter(this,arr_Food);
        recyclerFood.setAdapter(foodAdapter);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerFood.setLayoutManager(gridLayoutManager);
        recyclerFood.setLayoutManager(new LinearLayoutManager(this));


        recyclerOnePerson = findViewById(R.id.recyclerOnePerson);
        arr_OnePerson = new ArrayList<>();
        foodAdapter = new FoodAdapter(this,arr_OnePerson);
        recyclerOnePerson.setAdapter(foodAdapter);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerFood.setLayoutManager(gridLayoutManager);
        recyclerOnePerson.setLayoutManager(new LinearLayoutManager(this));
    }
}