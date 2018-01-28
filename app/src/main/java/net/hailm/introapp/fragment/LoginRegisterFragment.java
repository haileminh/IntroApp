package net.hailm.introapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.hailm.introapp.R;


public class LoginRegisterFragment extends Fragment implements View.OnClickListener {
    private View rootView;
    private TextView txtLogin;
    private TextView txtRegister;
    private EditText edtUserName;
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnLoginRegister;

    public LoginRegisterFragment() {
        // Required empty public constructor
    }

    public static LoginRegisterFragment newInstance() {
        LoginRegisterFragment loginRegisterFragment = new LoginRegisterFragment();
        return loginRegisterFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login_register, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();

    }


    private void initializeComponents() {
        txtLogin = rootView.findViewById(R.id.txt_login);
        txtRegister = rootView.findViewById(R.id.txt_register);
        edtUserName = rootView.findViewById(R.id.edt_user_name);
        edtEmail = rootView.findViewById(R.id.edt_email);
        edtPass = rootView.findViewById(R.id.edt_pass);
        btnLoginRegister = rootView.findViewById(R.id.btn_login_register);

        txtLogin.setOnClickListener(this);
        txtRegister.setOnClickListener(this);
        btnLoginRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_login:
                txtLogin.setBackgroundResource(R.drawable.bg_login_register_active);
                txtRegister.setBackgroundResource(R.drawable.bg_login_register_inactive);
                edtUserName.setVisibility(View.GONE);
                btnLoginRegister.setText("login");
                break;
            case R.id.txt_register:
                txtLogin.setBackgroundResource(R.drawable.bg_login_register_inactive);
                txtRegister.setBackgroundResource(R.drawable.bg_login_register_active);
                edtUserName.setVisibility(View.VISIBLE);
                btnLoginRegister.setText("Register");
                break;
            case R.id.btn_login_register:
                break;
        }
    }
}
