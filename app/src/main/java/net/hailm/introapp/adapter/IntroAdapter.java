package net.hailm.introapp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.hailm.introapp.model.Course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hai_l on 28/01/2018.
 */

public class IntroAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mListFragment;
    private ArrayList<Course> mListCourse;

    public IntroAdapter(FragmentManager fm, ArrayList<Fragment> listFragment, ArrayList<Course> listCourse) {
        super(fm);
        this.mListFragment = listFragment;
        this.mListCourse = listCourse;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mListFragment.get(position);
        if (position < mListFragment.size() - 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("POS", position);
            bundle.putSerializable("COURSE", (Serializable) mListCourse.get(position));
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
