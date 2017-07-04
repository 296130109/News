package com.caoyang.news.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.caoyang.news.controllers.MainActivityController;
import com.caoyang.news.R;
import com.caoyang.news.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        controller = new MainActivityController(this, binding);
        binding.setController(controller);
    }
}
