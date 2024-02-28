package com.example.appbanthucannhanh.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.appbanthucannhanh.R;
import com.example.appbanthucannhanh.adapter.FoodAdapter;
import com.example.appbanthucannhanh.model.Food;

import java.sql.Blob;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FoodFragment extends Fragment {
    public String DATABASE_NAME = "database_og";
    public String DB_PATH_SUFFIX="/databases/";
    public static SQLiteDatabase database = null;
    RecyclerView recyclerFood;
    FoodAdapter foodAdapter;
    ArrayList<Food> arr_Food;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private void loadData(){
        arr_Food.add(new Food(1,"1 Gà Xốt Cua", 41000, "1 Miếng Gà Xốt Cua",R.drawable.gaxotchua, "newFood"));
        arr_Food.add(new Food(2,"2 Gà Xốt Cua", 79000, "2 Miếng Gà Xốt Cua",R.drawable.gaxotchua, "newFood"));
        arr_Food.add(new Food(3,"3 Gà Xốt Cua", 117000, "3 Miếng Gà Xốt Cua",R.drawable.gaxotchua, "newFood"));
        arr_Food.add(new Food(4,"6 Gà Xốt Cua", 231000, "1 Miếng Gà Xốt Cua",R.drawable.gaxotchua, "newFood"));
        arr_Food.add(new Food(5,"Combo Gà Xốt Cua A", 93000, "1 Miếng Gà Xốt Cua + 1 Burger (bất kỳ) + 1 Pepsi Lon",R.drawable.gaxotchua, "newFood"));
        arr_Food.add(new Food(6,"Combo Gà Xốt Cua B", 41000, "2 Miếng Gà Xốt Cua + 1 Gà Viên Popcorn (vừa) + 2 Pepsi Lon",R.drawable.gaxotchua, "newFood"));
        arr_Food.add(new Food(7,"Combo Gà Xốt Cua C", 199000,"3 Miếng Gà Xốt Cua + 1 Miếng Gà(bất kỳ) + 3 Gà Miếng Nuggets + 2 Pepsi Lon", R.drawable.gaxotchua, "newFood"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        recyclerFood = view.findViewById(R.id.recyclerFood);
        arr_Food = new ArrayList<>();
        foodAdapter = new FoodAdapter(getActivity(), arr_Food);
        recyclerFood.setAdapter(foodAdapter);
        recyclerFood.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadData();
        return view;
    }
}