package net.hailm.introapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.hailm.introapp.OnSkipNextListener;
import net.hailm.introapp.R;
import net.hailm.introapp.model.Course;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "CourseFragment";
    private View rootView;
    private TextView txtTitle;
    private TextView txtDescription;
    private ImageView imageView;
    private int pos;

    private static OnSkipNextListener mCallBack;

    public CourseFragment() {
        // Required empty public constructor
    }

    public static CourseFragment newInstanse(OnSkipNextListener callBack) {
        CourseFragment courseFragment = new CourseFragment();
        mCallBack = callBack;
        return courseFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_course, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }


    private void initializeComponents() {
        txtTitle = rootView.findViewById(R.id.txt_title);
        txtDescription = rootView.findViewById(R.id.txt_description);
        imageView = rootView.findViewById(R.id.img);

        Bundle bundle = getArguments();
        if (bundle != null) {
            pos = bundle.getInt("POS");
            Log.d(TAG, "initializeComponents: " + pos);
            Course course = (Course) bundle.getSerializable("COURSE");
            txtTitle.setText(course.getTitle());
            txtDescription.setText(course.getDescription());
            imageView.setImageResource(course.getIdImage());

//            switch (pos) {
//                case 0:
//                    indicator1.setBackgroundResource(R.drawable.bg_login_register_inactive);
//                    indicator2.setBackgroundResource(R.drawable.bg_login_register_active);
//                    indicator3.setBackgroundResource(R.drawable.bg_login_register_active);
//                    break;
//                case 1:
//                    indicator1.setBackgroundResource(R.drawable.bg_login_register_active);
//                    indicator2.setBackgroundResource(R.drawable.bg_login_register_inactive);
//                    indicator3.setBackgroundResource(R.drawable.bg_login_register_active);
//                    break;
//                case 2:
//                    indicator1.setBackgroundResource(R.drawable.bg_login_register_active);
//                    indicator2.setBackgroundResource(R.drawable.bg_login_register_active);
//                    indicator3.setBackgroundResource(R.drawable.bg_login_register_inactive);
//                    break;
//            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_next:
                mCallBack.onNext(pos);
                break;
            case R.id.txt_skip:
                mCallBack.onSkip();
                break;
        }
    }
}
