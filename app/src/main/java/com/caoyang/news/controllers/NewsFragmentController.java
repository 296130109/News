package com.caoyang.news.controllers;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.caoyang.news.Config;
import com.caoyang.news.activitys.Main2Activity;
import com.caoyang.news.adapters.Adapter;
import com.caoyang.news.databinding.FragmentNewsBinding;
import com.caoyang.news.datas.RssDataItem;
import com.caoyang.news.fragments.NewsFragment;
import com.caoyang.news.rss.Reader;
import com.caoyang.news.rss.ReaderError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoyang on 17-6-27.
 */

public class NewsFragmentController {
    private List<RssDataItem> list = new ArrayList<>();
    private final NewsFragment fragment;
    private final FragmentNewsBinding binding;
    private Adapter adapter;
    private List<String> listString = new ArrayList<>();
    private List<String> listContent = new ArrayList<>();

    public NewsFragmentController(final NewsFragment fragment, FragmentNewsBinding binding) {
        this.fragment = fragment;
        this.binding = binding;
        addListeners();

        configAdapter();
        loadRssData();
    }

    private void addListeners() {
        binding.swiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadRssData();
            }
        });

        binding.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem == 0) {
                    binding.swiper.setEnabled(true);
                } else {
                    binding.swiper.setEnabled(false);
                }
            }
        });

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(fragment.getContext(), Main2Activity.class);
//                String content_text = listContent.get(position);
//                intent.putExtra("configAdapter", content_text);
//
//                fragment.getContext().startActivity(intent);
            }
        });
    }

    private void loadRssData() {
        binding.swiper.setRefreshing(true);
        Reader.loadRss(fragment.getContext(), Config.RSS_SOURCE, new Reader.OnSuccessCallback() {
            @Override
            public void onSuccess(List<RssDataItem> rssData) {
                binding.swiper.setRefreshing(false);

                adapter.clear();
                adapter.addAll(rssData);
            }
        }, new Reader.OnFailCallback() {
            @Override
            public void onFail(ReaderError error) {
                binding.swiper.setRefreshing(false);
                Toast.makeText(fragment.getContext(), "加载数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void configAdapter() {
        adapter = new Adapter(fragment.getContext());
        binding.listView.setAdapter(adapter);
    }

    private StringRequest stringRequest = null;

    public List<RssDataItem> getList() {
        return list;
    }
}
