package com.example.appbanthucannhanh.fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

//lb cho Recyler view items
import com.example.appbanthucannhanh.R;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.appbanthucannhanh.adapter.HomeAdapter;
import com.example.appbanthucannhanh.model.Home;

// lb cho carousel banner
import android.os.Handler;
import android.os.Looper;

import java.util.List;


public class HomeFragment extends Fragment {

    //Các biến cho Banner loop
    private ImageView banner;
    private int currentBannerIndex = 0;
    private final int[] bannerImages = {R.drawable.kfcbanner, R.drawable.logo, R.drawable.img};
    private static final long BANNER_CHANGE_INTERVAL = 4000;
    private Handler bannerHandler = new Handler(Looper.getMainLooper());

    //Các biến cho recyler view
    private RecyclerView recyclerView;
    private HomeAdapter comboAdapter;
    private List<Home> comboList;




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        banner = view.findViewById(R.id.home_carousel);
        recyclerView = view.findViewById(R.id.home_combo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        comboList = createSampleData();
        comboAdapter = new HomeAdapter(getActivity(), comboList);
        recyclerView.setAdapter(comboAdapter);

        startBannerCarousel();

        return view;
    }

    private Runnable bannerRunnable = new Runnable() {
        @Override
        public void run() {
            updateBanner();
            bannerHandler.postDelayed(this, BANNER_CHANGE_INTERVAL);
        }
    };

    private void startBannerCarousel() {
        bannerHandler.postDelayed(bannerRunnable, BANNER_CHANGE_INTERVAL);
    }

    private void updateBanner() {
        if (getActivity() != null) {
            if (currentBannerIndex < bannerImages.length - 1) {
                currentBannerIndex++;
            } else {
                currentBannerIndex = 0;
            }
            banner.setImageResource(bannerImages[currentBannerIndex]);
        }
    }

    // Hàm tạo data mẫu

    private List<Home> createSampleData() {
        List<Home> data = new ArrayList<>();

        data.add(new Home("Combo 1", R.drawable.kfcbanner, "10000$", "Chicken + Pepsi + Pizza"));
        data.add(new Home("Combo 2", R.drawable.kfcbanner, "12000$", "Burger + Coke + Fries"));
        data.add(new Home("Combo 4", R.drawable.kfcbanner, "10000$", "Chicken + Pepsi + Pizza"));
        data.add(new Home("Combo 5", R.drawable.kfcbanner, "10000$", "Chicken + Pepsi + Pizza"));
        data.add(new Home("Combo 6", R.drawable.kfcbanner, "10000$", "Chicken + Pepsi + Pizza"));

        return data;
    }

}