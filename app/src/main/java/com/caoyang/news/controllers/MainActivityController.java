package com.caoyang.news.controllers;

import com.caoyang.news.R;
import com.caoyang.news.activitys.MainActivity;
import com.caoyang.news.databinding.ActivityMainBinding;
import com.caoyang.news.fragments.ButtonFragment;
import com.caoyang.news.fragments.MainFragment;

/**
 * Created by caoyang on 17-6-27.
 */

public class MainActivityController {
    private final MainActivity activity;
    private final ActivityMainBinding binding;

    public MainActivityController(MainActivity activity, ActivityMainBinding binding) {

        this.activity = activity;
        this.binding = binding;
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tab_vp,new MainFragment()).commit();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_button,new ButtonFragment()).commit();
    }
}
