package net.hailm.introapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.hailm.introapp.OnSkipNextListener;
import net.hailm.introapp.R;
import net.hailm.introapp.adapter.IntroAdapter;
import net.hailm.introapp.model.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements OnSkipNextListener, View.OnClickListener {
    private View rootView;
    private ViewPager viewPager;
    private IntroAdapter introAdapter;
    private View indicator1, indicator2, indicator3;
    private TextView txtNext, txtSkip;
    private RelativeLayout lrRelativeLayout;
    private OnSkipNextListener callBack;
    private int currentPage = 0;

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
        registerListener();
    }

    private void initializeComponents() {
        viewPager = rootView.findViewById(R.id.vpg_main);

        txtNext = rootView.findViewById(R.id.txt_next);
        txtSkip = rootView.findViewById(R.id.txt_skip);
        indicator1 = rootView.findViewById(R.id.indicator1);
        indicator2 = rootView.findViewById(R.id.indicator2);
        indicator3 = rootView.findViewById(R.id.indicator3);
        lrRelativeLayout = rootView.findViewById(R.id.rl_bottom);
        callBack = this;
        CourseFragment javaFragment = CourseFragment.newInstanse(callBack);
        CourseFragment androidFragment = CourseFragment.newInstanse(callBack);
        CourseFragment iosFragment = CourseFragment.newInstanse(callBack);
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

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        indicator1.setBackgroundResource(R.drawable.bg_login_register_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_login_register_active);
                        indicator3.setBackgroundResource(R.drawable.bg_login_register_active);
                        lrRelativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        indicator1.setBackgroundResource(R.drawable.bg_login_register_active);
                        indicator2.setBackgroundResource(R.drawable.bg_login_register_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_login_register_active);
                        lrRelativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        indicator1.setBackgroundResource(R.drawable.bg_login_register_active);
                        indicator2.setBackgroundResource(R.drawable.bg_login_register_active);
                        indicator3.setBackgroundResource(R.drawable.bg_login_register_inactive);
                        lrRelativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        lrRelativeLayout.setVisibility(View.GONE);
                }
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void registerListener() {
        txtSkip.setOnClickListener(this);
        txtNext.setOnClickListener(this);
    }

    @Override
    public void onSkip() {
//        viewPager.setCurrentItem(4, true);
    }

    @Override
    public void onNext(int currentPage) {
//        viewPager.setCurrentItem(currentPage + 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_next:
                viewPager.setCurrentItem(currentPage + 1);
                break;
            case R.id.txt_skip:
                viewPager.setCurrentItem(4, true);
                break;
        }
    }
}
