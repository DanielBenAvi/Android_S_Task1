package com.example.android_s_task1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.android_s_task1.FragmetsInerface.LoginFragmentInterface;
import com.example.android_s_task1.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class LoginFragment extends Fragment {


    private TextInputLayout passwordEditText;
    private MaterialButton loginButton;

    private LoginFragmentInterface loginFragmentInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loginFragmentInterface = (LoginFragmentInterface) context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(
                v -> loginFragmentInterface.onLoginButtonClicked(Objects.requireNonNull(passwordEditText.getEditText()).getText().toString())
        );


        return view;
    }
}