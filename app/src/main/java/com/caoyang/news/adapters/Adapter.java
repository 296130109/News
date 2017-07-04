package com.caoyang.news.adapters;

import android.support.v4.app.Fragment;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.caoyang.news.R;
import com.caoyang.news.datas.RssDataItem;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoyang on 17-6-27.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private Fragment fragment;
    private List<RssDataItem> rssData = new ArrayList<>();

    public Adapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return rssData.size();
    }

    @Override
    public RssDataItem getItem(int position) {
        return rssData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_view, null);
            convertView.setTag(new Holder(convertView));
        }

        Holder holder = (Holder) convertView.getTag();

        RssDataItem rssData = getItem(position);
        holder.text.setText(rssData.getTitle());

        return convertView;
    }

    public void add(RssDataItem item) {
        rssData.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<RssDataItem> items) {
        rssData.addAll(items);
        notifyDataSetChanged();
    }

    public void clear(){
        rssData.clear();
        notifyDataSetChanged();
    }

    class Holder {
        private TextView text;

        public Holder(View convertView) {
            text = (TextView) convertView.findViewById(R.id.text_content);
        }
    }

}
