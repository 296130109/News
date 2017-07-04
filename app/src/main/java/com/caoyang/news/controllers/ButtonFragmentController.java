package com.caoyang.news.controllers;

import com.caoyang.news.databinding.FragmentButtonBinding;
import com.caoyang.news.fragments.ButtonFragment;

/**
 * Created by caoyang on 17-6-27.
 */

public class ButtonFragmentController {
    private final ButtonFragment fragment;
    private final FragmentButtonBinding binding;

    public ButtonFragmentController(ButtonFragment fragment, FragmentButtonBinding binding) {
        this.fragment = fragment;
        this.binding = binding;
    }
}
