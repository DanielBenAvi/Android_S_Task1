package com.example.android_s_task1.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_s_task1.R;
import com.google.android.material.textview.MaterialTextView;

public class HomeFragment extends Fragment {

    MaterialTextView homeFragmentTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeFragmentTextView = view.findViewById(R.id.homeFragmentTextView);


        return view;
    }
}