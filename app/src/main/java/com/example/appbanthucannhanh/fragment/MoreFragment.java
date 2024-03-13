package com.example.appbanthucannhanh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.appbanthucannhanh.R;
import com.example.appbanthucannhanh.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MoreFragment extends Fragment {


    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);



        viewPager = view.findViewById(R.id.viewPager_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new OrderedFragment(), "Đơn hàng đã đặt");
        adapter.addFragment(new FavoriteOrderFragment(), "Đơn đặt hàng yêu thích");
        adapter.addFragment(new DetailsSavedFragment(), "Địa chỉ đã lưu");
        adapter.addFragment(new AccountDetailsFragment(), "Chi tiết tài khoản");
        adapter.addFragment(new ChangePasswordFragment(), "Đặt lại mật khẩu");

        viewPager.setAdapter(adapter);
        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
