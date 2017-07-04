package com.caoyang.news.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.caoyang.news.databinding.FragmentMainBinding;
import com.caoyang.news.fragments.SportsFragment;
import com.caoyang.news.fragments.RecreationFragment;
import com.caoyang.news.fragments.MainFragment;
import com.caoyang.news.fragments.NewsFragment;
import com.caoyang.news.fragments.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoyang on 17-6-27.
 */

public class MainFragmentController {


    private final MainFragment fragment;
    private final FragmentMainBinding binding;
    private List<Fragment> listFragment = new ArrayList<>();
    private List<String> listString = new ArrayList<>();

    public MainFragmentController(MainFragment fragment, FragmentMainBinding binding) {
        this.fragment = fragment;
        this.binding = binding;
        addList();
        init();
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private void addList() {
        listFragment.add(new NewsFragment());
        listFragment.add(new VideoFragment());
        listFragment.add(new SportsFragment());
        listFragment.add(new RecreationFragment());
        listString.add("要闻");
        listString.add("视频");
        listString.add("体育");
        listString.add("娱乐");
    }

    private void init() {
        binding.viewPager.setAdapter(new FragmentPagerAdapter(fragment.getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return listFragment.get(position);
            }

            @Override
            public int getCount() {
                return listFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return listString.get(position);
            }
        });

    }
}
