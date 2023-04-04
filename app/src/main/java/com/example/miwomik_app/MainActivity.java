package com.example.miwomik_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.miwomik_app.adapter.FragAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private ViewPager2 viewPager2;

    private TabLayout tabLayout;

    private FragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new FragAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabLayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Number");
                    tab.setIcon(R.drawable.baseline_star_24);
                    break;
                case 1:
                    tab.setText("Colour");
                    break;

                case 2:
                    tab.setText("Pharse");
                    break;

                case 3:
                    tab.setText("Family");
                    break;
            }
        });
        tabLayoutMediator.attach();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(R.drawable.baseline_star_24);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(null);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}