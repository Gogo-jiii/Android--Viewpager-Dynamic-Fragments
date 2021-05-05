package com.example.viewpager2withdynamicfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.viewpager2withdynamicfragments.transformers.AntiClockSpinTransformation;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private static final int NUM_PAGES = 5;
    private String[] fragmentData = {"A", "B", "C", "D", "E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        pagerAdapter = new ViewPagerAdapter(this, fragmentData, NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(new AntiClockSpinTransformation());
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, NUM_PAGES);
        ViewPagerUtil.getInstance().onBackPressed(viewPager, getSupportFragmentManager());
    }

    @Override
    public void onBackPressed() {
        setViewPagerBackPress();
    }

    private void setViewPagerBackPress() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}