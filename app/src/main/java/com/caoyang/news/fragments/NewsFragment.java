package com.caoyang.news.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.caoyang.news.R;
import com.caoyang.news.controllers.NewsFragmentController;
import com.caoyang.news.databinding.FragmentNewsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

private FragmentNewsBinding binding;
    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater);
        binding.setController(new NewsFragmentController(this,binding));
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return binding.getRoot();
    }

}
