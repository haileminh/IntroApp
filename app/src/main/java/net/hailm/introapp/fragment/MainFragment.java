package net.hailm.introapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hailm.introapp.R;
import net.hailm.introapp.adapter.IntroAdapter;
import net.hailm.introapp.model.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private View rootView;
    private ViewPager viewPager;
    private IntroAdapter introAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newIntansce() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }

    private void initializeComponents() {
        viewPager = rootView.findViewById(R.id.vpg_main);

        CourseFragment javaFragment = CourseFragment.newInstanse();
        CourseFragment androidFragment = CourseFragment.newInstanse();
        CourseFragment iosFragment = CourseFragment.newInstanse();
        LoginRegisterFragment loginRegisterFragment = LoginRegisterFragment.newInstance();

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(javaFragment);
        fragmentArrayList.add(androidFragment);
        fragmentArrayList.add(iosFragment);
        fragmentArrayList.add(loginRegisterFragment);

        ArrayList<Course> listCourse = new ArrayList<>();
        Course androidCourse = new Course(getString(R.string.android_title), getString(R.string.android_description), R.drawable.ic_android);
        Course iosCourse = new Course(getString(R.string.android_title).replace("Android", "IOS"),
                getString(R.string.android_description).replace("Android", "IOS"),
                R.drawable.ic_android);
        Course javaCourse = new Course(getString(R.string.android_title).replace("Android", "JAva"),
                getString(R.string.android_description).replace("Android", "Java"),
                R.drawable.ic_android);
        listCourse.add(androidCourse);
        listCourse.add(iosCourse);
        listCourse.add(javaCourse);

        introAdapter = new IntroAdapter(getFragmentManager(), fragmentArrayList, listCourse);
        viewPager.setAdapter(introAdapter);
    }
}
