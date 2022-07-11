package com.joydas1902.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.joydas1902.newsapp.fragments.BusinessFragment;
import com.joydas1902.newsapp.fragments.EntertainmentFragment;
import com.joydas1902.newsapp.fragments.HealthFragment;
import com.joydas1902.newsapp.fragments.HomeFragment;
import com.joydas1902.newsapp.fragments.ScienceFragment;
import com.joydas1902.newsapp.fragments.SportsFragment;
import com.joydas1902.newsapp.fragments.TechnologyFragment;

public class PagerAdapter extends FragmentStateAdapter {
    private final String[] titles = new String[] {"Home", "Sports", "Business","Health", "Science", "Entertainment", "Technology"};

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SportsFragment();
            case 2:
                return new BusinessFragment();
            case 3:
                return new HealthFragment();
            case 4:
                return new ScienceFragment();
            case 5:
                return new EntertainmentFragment();
            case 6:
                return new TechnologyFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {return titles.length;}
}