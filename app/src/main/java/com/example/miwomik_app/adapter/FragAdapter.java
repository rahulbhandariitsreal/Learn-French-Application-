package com.example.miwomik_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.miwomik_app.ColorFrag;
import com.example.miwomik_app.FamilyFrag;
import com.example.miwomik_app.NumberFrag;
import com.example.miwomik_app.PhraseFrag;

public class FragAdapter extends FragmentStateAdapter {


    public FragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0:
               return new NumberFrag();
           case 1:
               return new ColorFrag();
           case 2:
               return new PhraseFrag();
           case 3:
               return new FamilyFrag();
           default:
               return null;
       }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
