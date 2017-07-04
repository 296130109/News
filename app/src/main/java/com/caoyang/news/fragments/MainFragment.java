package com.caoyang.news.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caoyang.news.R;
import com.caoyang.news.controllers.MainFragmentController;
import com.caoyang.news.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private MainFragmentController controller;

    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater);
        controller = new MainFragmentController(this, binding);
        binding.setController(controller);
        return binding.getRoot();
    }

}
