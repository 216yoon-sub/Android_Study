package com.example.musicplayerapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public int mCount;

    public MyAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new FragmentFbf();
        else if(index==1) return new FragmentIljido();
        else if(index==2) return new FragmentNy();
        else if(index==3) return new FragmentRainyseason();
        else if(index==4) return new FragmentYesiam();
        else return new FragmentWf();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position){
        return position%mCount;
    }
}
