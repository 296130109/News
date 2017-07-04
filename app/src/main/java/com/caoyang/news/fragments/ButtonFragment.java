package com.caoyang.news.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.caoyang.news.controllers.ButtonFragmentController;
import com.caoyang.news.databinding.FragmentButtonBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {
    private FragmentButtonBinding binding;
    private ButtonFragmentController controller;

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentButtonBinding.inflate(inflater);
        controller = new ButtonFragmentController(this, binding);
        binding.setController(controller);

        return binding.getRoot();
    }

}
