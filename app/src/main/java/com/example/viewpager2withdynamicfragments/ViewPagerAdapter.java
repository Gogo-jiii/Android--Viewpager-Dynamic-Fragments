package com.example.viewpager2withdynamicfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class ViewPagerAdapter extends FragmentStateAdapter {

    private String[] fragmentData;
    private int numPages;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String[] fragmentData,
                            int numPages) {
        super(fragmentActivity);

        this.fragmentData = fragmentData;
        this.numPages = numPages;
    }

    @NonNull @Override public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("key", fragmentData[position]);
        ViewpagerFragment fragment = new ViewpagerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override public int getItemCount() {
        return numPages;
    }
}